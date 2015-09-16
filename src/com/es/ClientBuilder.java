package com.es;

import java.net.InetSocketAddress;

import static com.es.util.Utils.*;

/**
 * Helper class for creating new client to connect to portfolio manager.
 * 
 * @author Josh Keeler
 *
 */
public class ClientBuilder {

	private Credentials credentials;
	private InetSocketAddress host;
	private String scheme;

	private static final InetSocketAddress DEFAULT_HOST = new InetSocketAddress("portfoliomanager.energystar.gov", 443);
	private static final String DEFAULT_SCHEME = "https";

	/**
	 * Base constructor.
	 * 
	 * @since 1.0.0
	 */
	public ClientBuilder() {
		this.credentials = null;
		this.host = DEFAULT_HOST;
		this.scheme = DEFAULT_SCHEME;
	}

	/**
	 * Sets the credentials to use for the specified database. This is required.
	 * 
	 * @param credentials
	 *            Database credentials
	 * @since 1.0.0
	 */
	public ClientBuilder credentials(Credentials credentials) {
		this.credentials = throwIfNull(credentials);
		return this;
	}

	/**
	 * Sets the host to connect to. Defaults to <tt>api.tempo-db.com:443</tt>
	 * 
	 * @param host
	 *            Host to connect to.
	 * @since 1.0.0
	 */
	public ClientBuilder host(InetSocketAddress host) {
		this.host = throwIfNull(host);
		return this;
	}

	/**
	 * Sets the scheme. Valid values are "http" and "https". Defaults to
	 * "https".
	 * 
	 * @param scheme
	 *            The scheme.
	 * @since 1.0.0
	 */
	public ClientBuilder scheme(String scheme) {
		this.scheme = throwIfNull(scheme);
		return this;
	}
	
	/**
	 * Creates the client object using the specified parameters.
	 * 
	 * @return The build client
	 * @since 1.0.0
	 */
	public Client build() {
		validate();
		Client client = new Client(credentials, host, scheme);
		return client;
	}

	private void validate() {
		throwIfNull(credentials, "Credentials must not be null.");
	}
}
