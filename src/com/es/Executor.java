package com.es;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class Executor {
	private final Credentials credentials;
	private final InetSocketAddress host;
	private final String scheme;
	private HttpClient client = null;
	private HttpHost target = null;

	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	private static final int DEFAULT_TIMEOUT_MILLIS = 50000; // 50 seconds
	private static final long DEFAULT_KEEPALIVE_TIMEOUT_MILLIS = 50000; // 50
																		// seconds
	private static final int GENERIC_ERROR_CODE = 600;

	private enum HttpMethod {
		GET, POST, PUT, DELETE
	}

	public Executor(Credentials credentials, InetSocketAddress host, String scheme) {
		this.credentials = credentials;
		this.host = host;
		this.scheme = scheme;
	}

	public <T> T get(URI endpoint, Class<T> klass) {
		return get(endpoint, klass, "", new String[] {}, new String[] {});
	}

	public <T> T get(URI endpoint, Class<T> klass, String contentType, String[] mediaTypes, String[] headers) {
		HttpRequest request = buildRequest(endpoint, HttpMethod.GET, null, contentType, mediaTypes, headers);
		return execute(request, klass);
	}
	
	public <T> T post(URI endpoint, String body, Class<T> klass) {
		return post(endpoint, body, klass, "application/xml", new String[] {}, new String[] {});
	}
	
	public <T> T post(URI endpoint, String body, Class<T> klass, String contentType, String[] mediaTypes, String[] headers) {
		HttpRequest request = buildRequest(endpoint, HttpMethod.POST, body, contentType, mediaTypes, headers);
		return execute(request, klass);
	}
	
	public <T> T put(URI endpoint, String body, Class<T> klass) {
		return put(endpoint, body, klass, "application/xml", new String[] {}, new String[] {});
	}
	
	public <T> T put(URI endpoint, String body, Class<T> klass, String contentType, String[] mediaTypes, String[] headers) {
		HttpRequest request = buildRequest(endpoint, HttpMethod.PUT, body, contentType, mediaTypes, headers);
		return execute(request, klass);
	}
	
	public <T> T delete(URI endpoint, Class<T> klass) {
		return delete(endpoint, klass, "", new String[] {}, new String[] {});
	}
	
	public <T> T delete(URI endpoint, Class<T> klass, String contentType, String[] mediaTypes, String[] headers) {
		HttpRequest request = buildRequest(endpoint, HttpMethod.DELETE, null, contentType, mediaTypes, headers);
		return execute(request, klass);
	}

	<T> T execute(HttpRequest request, Class<T> clazz) {
		try {
			HttpResponse response = executeRequest(request);
			InputStream content = response.getEntity().getContent();
			
			T object = fromXmlToObject(content, clazz);
				
			return object;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			//return new Result<T>(null, GENERIC_ERROR_CODE, e.getMessage());
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
			return null;
		} catch (JAXBException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T fromXmlToObject(InputStream content, Class<T> clazz) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		
		return (T) unmarshaller.unmarshal(content);
	}
	
	public static <T> String toXmlString(T inst){
        try {
        	return toXmlString(inst, true);
        }
        catch (JAXBException e){
        	e.printStackTrace();
        	return null;
        }
    }

	public static <T> String toXmlString(T inst, boolean formatOutput) throws JAXBException {
		final StringWriter writer = new StringWriter();
		final JAXBContext context = JAXBContext.newInstance(inst.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatOutput);// pretty																	// print
		m.marshal(inst, writer);
		return writer.toString();
	}
	
	HttpResponse executeRequest(HttpRequest request) throws IOException {
		HttpClient client = getHttpClient();
		HttpContext context = getContext();
		HttpHost target = getTarget();
		return client.execute(target, request, context);
	}
	
	private synchronized HttpClient getHttpClient() {
		if (client == null) {
			HttpParams httpParams = new BasicHttpParams();

			DefaultHttpClient defaultClient = new DefaultHttpClient(new PoolingClientConnectionManager(), httpParams);
			defaultClient.getCredentialsProvider().setCredentials(new AuthScope(getTarget()),
					new UsernamePasswordCredentials(credentials.getUsername(), credentials.getPassword()));
			
			client = defaultClient;
		}
		return client;
	}
	
	synchronized Executor setHttpClient(HttpClient httpClient) {
		this.client = httpClient;
		return this;
	}

	private HttpContext getContext() {
		HttpHost targetHost = getTarget();

		// Create AuthCache instance
		AuthCache authCache = new BasicAuthCache();
		// Generate BASIC scheme object and add it to the local
		// auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context
		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		return localcontext;
	}

	HttpHost getTarget() {
		if (target == null) {
			target = new HttpHost(host.getHostName(), host.getPort(), scheme);
		}
		return target;
	}

	void setTarget(HttpHost target) {
		this.target = target;
	}

	HttpRequest buildRequest(URI uri, HttpMethod method, String body, String contentType, String[] mediaTypes, String [] headers) {
		String endpoint = uri.toString();
		HttpRequest request = null;
		switch (method) {
		case POST:
			HttpPost post = new HttpPost(endpoint);
			if (body != null) {
				post.setEntity(new StringEntity(body, DEFAULT_CHARSET));
			}
			request = post;
			break;
		case PUT:
			HttpPut put = new HttpPut(endpoint);
			if (body != null) {
				put.setEntity(new StringEntity(body, DEFAULT_CHARSET));
			}
			request = put;
			break;
		case DELETE:
			HttpDelete delete = new HttpDelete(endpoint);

			request = delete;
			break;
		case GET:
		default:
			HttpGet get = new HttpGet(endpoint);
			request = get;
			break;
		}
		if (contentType != null && (!contentType.equals(""))) {
			request.setHeader("Content-Type", contentType);
		}
		
		if (headers != null){
			request.setHeader("PM-Metrics", StringUtils.join(headers, ","));
		}

		return request;
	}
}
