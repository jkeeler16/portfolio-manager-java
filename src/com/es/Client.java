package com.es;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

import com.es.manager.account.AccountType;
import com.es.manager.account.CustomerType;
import com.es.manager.association.MeterPropertyAssociationListType;
import com.es.manager.association.MeterPropertyUseAssociationListType;
import com.es.manager.common.AlertsType;
import com.es.manager.common.FederalAgencies;
import com.es.manager.common.ResponseType;
import com.es.manager.meter.MeterType;
import com.es.manager.meter.data.MeterConsumptionType;
import com.es.manager.meter.data.MeterDataType;
import com.es.manager.property.BuildingType;
import com.es.manager.property.PropertyType;
import com.es.manager.property.design.BasePropertyUseType;
import com.es.manager.property.design.DesignBaseType;
import com.es.manager.property.design.PropertyUse;
import com.es.manager.property.egrid.EGridSubregionList;
import com.es.manager.property.metrics.BaselineAndTargetType;
import com.es.manager.property.metrics.EnergyPerformanceProjectType;
import com.es.manager.property.metrics.MeasurementSystem;
import com.es.manager.property.metrics.PropertyMetricsType;
import com.es.manager.property.edu.EduList;
import com.es.manager.property.pgp.PgpList;
import com.es.manager.property.use.UseAttributeBase;

public class Client {

	private Executor runner;
	private static final String TEST_HOST = "wstest";
	private static final String PRODUCTION_HOST = "ws";
	private Long accountId;

	private boolean isTestEnv = false;

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	private long getAccountId() {
		if (accountId == null) {
			accountId = getAccount().getId();
		}

		return accountId;
	}

	public void toggleTestEnv(boolean toggle) {
		this.isTestEnv = toggle;
	}

	private String getServletString() {
		return isTestEnv ? TEST_HOST : PRODUCTION_HOST;
	}

	/**
	 * Base constructor for a Client object.
	 *
	 * @param credentials
	 *            Api credentials
	 * @param host
	 *            Api server host address
	 * @param scheme
	 *            Scheme for requests. "http" and "https" are supported.
	 */
	public Client(Credentials credentials, InetSocketAddress host, String scheme) {
		this.runner = new Executor(credentials, host, scheme);
	}
	
	/* *******************************
	 * *******************************
	 * ***** BEGIN ACCOUNT APIs ******
	 * *******************************
	 * *******************************/
	
	/**
	 * Retrieve the account associated with the currnet users
	 * 
	 * @return
	 */
	public AccountType getAccount() {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/account", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /account");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, AccountType.class);
	}
	
	/**
	 * Creates an account for the purposes of offering data exchange web
	 * services. An account is created based on the information provided in the
	 * XML request.
	 * 
	 * @param account
	 * @return
	 */
	public AccountType createAccount(AccountType account) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/account", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /account");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(account);
		return runner.post(uri, body, AccountType.class);
	}

	/**
	 * Updates your account based on the information provided in the XML
	 * request.
	 * 
	 * @param account
	 * @return
	 */
	public ResponseType updateAccount(AccountType account) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/account", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /account");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(account);
		return runner.put(uri, body, ResponseType.class);
	}
	
	/**
	 * Creates an account for a customer based on the information provided in
	 * the XML request and establishes a connection to your account.
	 * 
	 * @param account
	 * @return
	 */
	public AccountType createCustomer(AccountType account) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/customer", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /customer");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(account);
		return runner.post(uri, body, AccountType.class);
	}

	/**
	 * Updates an account for your customer that you are already connected to.
	 * Currently you can only change whether they are allowed to share meter
	 * data with others.
	 * 
	 * @param account
	 * @return
	 */
	public ResponseType updateCustomer(AccountType account) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/customer", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /customer");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(account);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Returns a list of customers that you are connected to.
	 * 
	 * @return
	 */
	public ResponseType getCustomerList() {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/customer/list", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /customer");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, ResponseType.class);
	}

	/**
	 * Retrieves account information for a specific customer that you are
	 * connected to.
	 * 
	 * @return
	 */
	public CustomerType getCustomerList(long customerId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/customer/%d", getServletString(), customerId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /customer/{customerId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, CustomerType.class);
	}

	/* *******************************
	 * *******************************
	 * ***** BEGIN PROPERTY APIs *****
	 * *******************************
	 * *******************************/
	
	/**
	 * Retrieve the list of properties this account has access to
	 * 
	 * @return
	 */
	public ResponseType getPropertyList() {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/account/%d/property/list", getServletString(), getAccountId()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /{accountId}/property/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, ResponseType.class);
	}

	/**
	 * Get a property with given propertyId
	 * 
	 * @param propertyId
	 * @return
	 */
	public PropertyType getProperty(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}");
			throw new IllegalArgumentException(message, e);
		}
		
		return runner.get(uri, PropertyType.class);
	}

	/**
	 * Delete a property with given propertyId
	 * 
	 * @param propertyId
	 * @return
	 */
	public ResponseType deleteProperty(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}

	/**
	 * Add a new property for current account
	 * 
	 * @param property
	 * @return
	 */
	public ResponseType addProperty(PropertyType property) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/account/%d/property", getServletString(), getAccountId()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: account/{accountId}/property");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(property);
		return runner.post(uri, body, ResponseType.class);
	}

	/**
	 * Update a property with given propertyId
	 * 
	 * @param property
	 * @return
	 */
	public ResponseType updateProperty(long propertyId, PropertyType property) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(property);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Get design characteristics for a specified property
	 * 
	 * @param i
	 * @return
	 */
	public DesignBaseType getPropertyDesign(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/design", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/design");
			throw new IllegalArgumentException(message, e);
		}

		try {
			return runner.get(uri, DesignBaseType.class);
		}

		catch (Exception e) {
			e.printStackTrace();
			// System.out.println(Executor.toXmlString(runner.get(uri,
			// ResponseType.class)));
			return null;
		}
	}

	/**
	 * Updates the design characteristics based on the information provided in
	 * the XML request for a specified property that already exists. It
	 * overwrites all previously existing design characteristics
	 * 
	 * @param propertyId
	 * @param design
	 * @return
	 */
	public ResponseType updatePropertyDesign(long propertyId, DesignBaseType design) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/design", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/design");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(design);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Returns a list of electric distribution utilities (EDU) that identifies
	 * the regional power grid for a specific property.
	 * 
	 * @param propertyId
	 * @return
	 */
	public EduList getEduList(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/edu/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/edu/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, EduList.class);
	}

	/**
	 * Sets a specified electric distribution utility (EDU) for a given
	 * property.
	 * 
	 * @param propertyId
	 * @param eduId
	 * @return
	 */
	public ResponseType updateEduForProperty(long propertyId, long eduId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/edu/%d", getServletString(), propertyId, eduId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/edu/{eduId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.put(uri, "", ResponseType.class);
	}

	/**
	 * Returns a list of power generation plants (PGP) that are within the
	 * vicinity of a specific property.
	 * 
	 * @param propertyId
	 * @return
	 */
	public PgpList getPgpList(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/pgp/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/pgp/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, PgpList.class);
	}

	/**
	 * Sets a specified power generation plant (PGP) for a given property.
	 * 
	 * @param propertyId
	 * @param eduId
	 * @return
	 */
	public ResponseType updatePgpForProperty(long propertyId, long pgpId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/pgp/%d", getServletString(), propertyId, pgpId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/pgp/{pgpId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.put(uri, "", ResponseType.class);
	}

	/**
	 * Removes the currently assigned power generation plant (PGP) from the
	 * specified property.
	 * 
	 * @param propertyId
	 * @param eduId
	 * @return
	 */
	public ResponseType deletePgpForProperty(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d/pgp", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/pgp");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}

	/**
	 * Retrieves a list of all of the federal agencies that a federal property
	 * can be associated to.
	 * 
	 * @return
	 */
	public FederalAgencies getFederalAgencyList() {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/federalAgency/list", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/federalAgency/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, FederalAgencies.class);
	}

	/**
	 * Returns a list of eGrid subregions that can be referenced when managing
	 * green power data.
	 * 
	 * @return
	 */
	public EGridSubregionList getEGridSubregionList() {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/eGridSubregion/list", getServletString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/eGridSubregion/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, EGridSubregionList.class);
	}

	/**
	 * Retrieves the energy and water baseline dates and the performance target
	 * settings for a specific property.
	 * 
	 * @param propertyId
	 * @return
	 */
	public BaselineAndTargetType getBaselineAndTarget(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/baselineAndTarget", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/baselineAndTarget");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, BaselineAndTargetType.class);
	}

	/**
	 * Updates the energy and water baseline dates and performance target
	 * settings for a specific property based on the information provided in the
	 * XML request.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType updateBaselineAndTarget(long propertyId, BaselineAndTargetType baselineAndTarget) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/baselineAndTarget", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/baselineAndTarget");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(baselineAndTarget);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Retrieves a list of all the energy performance projects for a specific
	 * property.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType getEnergyPerformanceProjectList(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/energyPerformanceProject/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/energyPerformanceProject/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, ResponseType.class);
	}

	/**
	 * Creates an energy performance project for a specific property based on
	 * the information provided in the XML request.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType addEnergyPerformanceProject(long propertyId, EnergyPerformanceProjectType energyProject) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/energyPerformanceProject", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/energyPerformanceProject/list");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(energyProject);
		return runner.post(uri, body, ResponseType.class);
	}

	/**
	 * Creates an energy performance project for a specific property based on
	 * the information provided in the XML request.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public EnergyPerformanceProjectType getEnergyPerformanceProject(long energyProjectId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/energyPerformanceProject/%d", getServletString(), energyProjectId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /energyPerformanceProject/{energyProjectId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, EnergyPerformanceProjectType.class);
	}

	/**
	 * Updates an energy performance project based on the information provided
	 * in the XML request.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType updateEnergyPerformanceProject(long energyProjectId,
			EnergyPerformanceProjectType energyProject) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/energyPerformanceProject/%d", getServletString(), energyProjectId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /energyPerformanceProject/{energyProjectId}");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(energyProject);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Deletes a specified energy project project.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType deleteEnergyPerformanceProject(long energyProjectId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/energyPerformanceProject/%d", getServletString(), energyProjectId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /energyPerformanceProject/{energyProjectId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/* *******************************
	 * *******************************
	 * ****** BEGIN METRIC APIs ******
	 * *******************************
	 * *******************************/
	
	/**
	 * Returns a list of metric values for a specific property design based on a
	 * specified measurement system.
	 * 
	 * @param propertyId
	 * @return
	 */
	public PropertyMetricsType getPropertyDesignMetrics(long propertyId, MeasurementSystem.Type measurementSystem) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/design/metrics?measurementSystem=%s", getServletString(), propertyId, measurementSystem.toString()));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/design/metrics");
			throw new IllegalArgumentException(message, e);
		}
		
		try {
			return runner.get(uri, PropertyMetricsType.class);
		}
		catch (Exception e){
			return null;
		}
	}

	/**
	 * Returns a list of metric values for a specific property and period ending
	 * date based on the specified set of metrics and measurement system.
	 * 
	 * @param propertyId
	 * @return
	 */
	public PropertyMetricsType getPropertyMetrics(long propertyId, MeasurementSystem.Type measurementSystem,
			Integer month, Integer year, String [] metrics) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/metrics?measurementSystem=%s&month=%d&year=%d", getServletString(),
							propertyId, measurementSystem.toString(), month, year));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/metrics");
			throw new IllegalArgumentException(message, e);
		}

		try {
			return runner.get(uri, PropertyMetricsType.class, "", new String[] {}, metrics);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns a list of reasons that explain why the specific property cannot
	 * receive an ENERGY STAR score for a certain period ending date. If both
	 * the year and month are not provided then the property's current period
	 * ending date is used.
	 * 
	 * @param propertyId
	 * @return
	 */
	public AlertsType getReasonsForNoScore(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/reasonsForNoScore", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/reasonsForNoScore");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, AlertsType.class);
	}
	
	/**
	 * Returns a list of time-weighted use detail values for a specific
	 * property, period ending date, and measurement system.
	 * 
	 * @param propertyId
	 * @return
	 */
	public PropertyMetricsType getPropertyUseDetailsMetrics(long propertyId, MeasurementSystem.Type measurementSystem, Integer month, Integer year) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/useDetails/metrics?measurementSystem=%s&month=%d&year=%d",
							getServletString(), propertyId, measurementSystem.toString(), month, year));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/useDetails/metrics");
			throw new IllegalArgumentException(message, e);
		}
		try {
			return runner.get(uri, PropertyMetricsType.class);
		}
		catch (Exception e) {
			//e.printStackTrace();
//			 System.out.println(Executor.toXmlString(runner.get(uri,
//			 ResponseType.class)));
			return null;
		}
	}
	
	/* *******************************
	 * *******************************
	 * ****** BEGIN METER APIs *******
	 * *******************************
	 * *******************************/
	
	/**
	 * Retrieves a list of all the meters for a specific
	 * property.
	 * 
	 * @param propertyId
	 * @return
	 */
	public ResponseType getMeterList(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/meter/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/meter/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, ResponseType.class);
	}

	/**
	 * Creates a meter for a specific property based on
	 * the information provided in the XML request.
	 * 
	 * @param propertyId
	 * @param meter
	 * @return
	 */
	public ResponseType addMeter(long propertyId, MeterType meter) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/meter", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/meter");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meter);
		return runner.post(uri, body, ResponseType.class);
	}

	/**
	 * Retrieves information for a specific meter.
	 * @param meterId
	 * @return
	 */
	public MeterType getMeter(long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d", getServletString(), meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterType.class);
	}

	/**
	 * Updates a specified meter based on the information provided in the XML request.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType updateMeter(long meterId,
			MeterType meter) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d", getServletString(), meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meter);
		return runner.put(uri, body, ResponseType.class);
	}

	/**
	 * Deletes a specified meter.
	 * 
	 * @param propertyId
	 * @param baselineAndTarget
	 * @return
	 */
	public ResponseType deleteMeter(long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d", getServletString(), meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Returns a list of meters that are associated to a specific property.
	 * @param propertyId
	 * @return
	 */
	public MeterPropertyAssociationListType getPropertyMeterAssociations(long propertyId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/meter", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/meter");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterPropertyAssociationListType.class);
	}
	
	/**
	 * Associates a set of meters to a property based on the set of meters
	 * provided in the XML request. If a set of energy meters is only provided
	 * then the association is only performed using that set of energy meters
	 * and any existing water meter associations are not affected. Similarly, if
	 * a set of water meters is only provided then the association is only
	 * performed using that set of water meters and any existing energy meter
	 * associations are not affected.
	 * 
	 * @param propertyId
	 * @return
	 */
	public ResponseType addPropertyMeterAssociations(long propertyId, MeterPropertyAssociationListType meterList) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/meter", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/meter");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meterList);
		return runner.post(uri, body, ResponseType.class);
	}
	
	/**
	 * Associates a single meter to a property.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType addPropertyMeterAssociation(long propertyId, long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/meter/%d", getServletString(), propertyId, meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.post(uri, "", ResponseType.class);
	}
	
	/**
	 * Disassociates a specific meter from a given property.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType deletePropertyMeterAssociation(long propertyId, long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/meter/%d", getServletString(), propertyId, meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Associates a single building to a property.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType addPropertyBuildingAssociation(long propertyId, long buildingId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/building/%d", getServletString(), propertyId, buildingId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/building/{buildingId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.post(uri, "", ResponseType.class);
	}
	
	/**
	 * Disassociates a specific building from a given property.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType deletePropertyBuildingAssociation(long propertyId, long buildingId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/property/%d/building/%d", getServletString(), propertyId, buildingId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/property/{propertyId}/building/{buildingId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Returns a list of meters that are associated to a specific property use.
	 * @param propertyId
	 * @return
	 */
	public MeterPropertyUseAssociationListType getPropertyUseMeterAssociations(long propertyUseId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/propertyUse/%d/meter", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/propertyUse/{propertyUseId}/meter");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterPropertyUseAssociationListType.class);
	}
	
	/**
	 * Associates a set of meters to a property use based on the set of meters provided in the XML request. All submissions overwrite/replace previous settings.
	 * 
	 * @param propertyId
	 * @return
	 */
	public ResponseType addPropertyMeterAssociations(long propertyUseId, MeterPropertyUseAssociationListType meterList) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/propertyUse/%d/meter", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/propertyUse/{propertyUseId}/meter");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meterList);
		return runner.post(uri, body, ResponseType.class);
	}
	
	/**
	 * Associates a single meter to a property use.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType addPropertyUseMeterAssociation(long propertyUseId, long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/propertyUse/%d/meter/%d", getServletString(), propertyUseId, meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/propertyUse/{propertyUseId}/meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.post(uri, "", ResponseType.class);
	}
	
	/**
	 * Disassociates a specific meter from a given property use.
	 * @param propertyId
	 * @param meterId
	 * @return
	 */
	public ResponseType deletePropertyUseMeterAssociation(long propertyUseId, long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/association/propertyUse/%d/meter/%d", getServletString(), propertyUseId, meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /association/propertyUse/{propertyUseId}/meter/{meterId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Adds consumption data to a specific meter based on the information
	 * provided in the XML request. It returns the unique identifier to each
	 * consumption data entry and a link to the corresponding web service to
	 * retrieve it.
	 * 
	 * @param meterId
	 * @param meterData
	 * @return
	 */
	public MeterDataType addMeterData(long meterId, MeterDataType meterData) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d/consumptionData", getServletString(), meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}/consumptionData");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meterData);
		return runner.post(uri, body, MeterDataType.class);
	}
	
	/**
	 * Updates a specific meter consumption data record based on the information
	 * provided in the XML request.
	 * 
	 * @param meterId
	 * @param meterData
	 * @return
	 */
	public ResponseType updateMeterData(long consumptionDataId, MeterConsumptionType meterData) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/consumptionData/%d", getServletString(), consumptionDataId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /consumptionData/{consumptionDataId}");
			throw new IllegalArgumentException(message, e);
		}

		String body = null;
		body = Executor.toXmlString(meterData);
		return runner.put(uri, body, ResponseType.class);
	}
	
	/**
	 * Deletes a specific consumption data.
	 * 
	 * @param meterId
	 * @return
	 */
	public ResponseType deleteMeterData(long consumptionDataId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/consumptionData/%d", getServletString(), consumptionDataId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /consumptionData/{consumptionDataId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Retrieves consumption data for a specific meter. The meter must already
	 * be shared with you. The consumption data is returned in sets of 20.
	 * 
	 * @param meterId
	 * @return
	 */
	public MeterDataType getMeterData(long meterId) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d/consumptionData", getServletString(), meterId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}/consumptionData");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterDataType.class);
	}
	
	/**
	 * Retrieves consumption data for a specific meter. The meter must already
	 * be shared with you. The consumption data is returned in sets of 20.
	 * 
	 * @param meterId
	 * @param page
	 * @return
	 */
	public MeterDataType getMeterData(long meterId, Integer page) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d/consumptionData?page=%d", getServletString(), meterId, page));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}/consumptionData");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterDataType.class);
	}
	
	/**
	 * Retrieves consumption data for a specific meter. The meter must already
	 * be shared with you. The consumption data is returned in sets of 20.
	 * 
	 * @param meterId
	 * @param startDate YYYY-MM-DD
	 * @param endDate YYYY-MM-DD
	 * @return
	 */
	public MeterDataType getMeterDataBetweenDateTimes(long meterId, String startDate, String endDate) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d/consumptionData?startDate=%s&endDate=%s", getServletString(), meterId, startDate, endDate));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}/consumptionData");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterDataType.class);
	}
	
	/**
	 * Retrieves consumption data for a specific meter. The meter must already
	 * be shared with you. The consumption data is returned in sets of 20.
	 * 
	 * @param meterId
	 * @param startDate YYYY-MM-DD
	 * @param endDate YYYY-MM-DD
	 * @return
	 */
	public MeterDataType getMeterDataBetweenDateTimes(long meterId, String startDate, String endDate, Integer page) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/meter/%d/consumptionData?startDate=%s&endDate=%s&page=%d", getServletString(), meterId, startDate, endDate, page));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /meter/{meterId}/consumptionData");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, MeterDataType.class);
	}
	
	/* *******************************
	 * *******************************
	 * *** BEGIN PROPERTY USE APIs ***
	 * *******************************
	 * *******************************/
	
	/**
	 * Returns the list of property uses for a specific property.
	 * @param propertyId
	 * @return
	 */
	public ResponseType getPropertyUseList(long propertyId){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/propertyUse/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/propertyUse/list");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, ResponseType.class);
	}
	
	/**
	 * Creates a property use under a specified property based on the information provided in the XML request. It returns the unique identifier to the newly created property use and a link to the corresponding web service to retrieve it.
	 * @param propertyId
	 * @param propertyUse
	 * @return
	 */
	public ResponseType addPropertyUse(long propertyId, BasePropertyUseType propertyUse){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(
					String.format("/%s/property/%d/propertyUse", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/propertyUse");
			throw new IllegalArgumentException(message, e);
		}
		
		String body = null;
		body = Executor.toXmlString(propertyUse);
		return runner.post(uri, body, ResponseType.class);
	}
	
	/**
	 * Returns information for a specific property use. The information includes
	 * general data about the property use itself and its most current operating
	 * characteristics information.
	 * 
	 * @param propertyUseId
	 * @param clazz
	 * @return
	 */
	public <T> T getPropertyUse(long propertyUseId, Class<T> clazz) {
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/propertyUse/%d", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /propertyUse/{propertyUseId}");
			throw new IllegalArgumentException(message, e);
		}

		return runner.get(uri, clazz);
	}
	
	/**
	 * Updates a specific property use under a given property based on the information provided in the XML request. Only the name of the property use can be updated with this web service
	 * @param propertyUseId
	 * @param use
	 * @return
	 */
	public ResponseType updatePropertyUseName(long propertyUseId, PropertyUse propertyUse){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/propertyUse/%d", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /propertyUse/{propertyUseId}");
			throw new IllegalArgumentException(message, e);
		}
		
		String body = null;
		body = Executor.toXmlString(propertyUse);
		return runner.put(uri, body, ResponseType.class);
	}
	
	/**
	 * Deletes a specific property use.
	 * @param propertyUseId
	 * @return
	 */
	public ResponseType deletePropertyUse(long propertyUseId){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/propertyUse/%d", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /propertyUse/{propertyUseId}");
			throw new IllegalArgumentException(message, e);
		}
		
		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Add a revision to the property use characteristics for the given property use ID.
	 * @param propertyUseId
	 * @param characteristic
	 * @return
	 */
	public ResponseType addPropertyUseDetail(long propertyUseId, UseAttributeBase characteristic){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/propertyUse/%d/useDetails", getServletString(), propertyUseId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /propertyUse/{propertyUseId}/useDetails");
			throw new IllegalArgumentException(message, e);
		}
		
		String body = null;
		body = Executor.toXmlString(characteristic);
		return runner.post(uri, body, ResponseType.class);
	}
	
	/* *******************************
	 * *******************************
	 * *** BEGIN BUILDING USE APIs ***
	 * *******************************
	 * *******************************/
	/**
	 * Retrieves information for a specific building.
	 * @param buildingId
	 * @return
	 */
	public BuildingType getBuilding(long buildingId){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/building/%d", getServletString(), buildingId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /building/{buildingId}");
			throw new IllegalArgumentException(message, e);
		}
		
		return runner.delete(uri, BuildingType.class);
	}
	
	/**
	 * Creates a building under a specified property based on the information provided in the XML request.
	 * @param propertyId
	 * @param building
	 * @return
	 */
	public ResponseType addBuilding(long propertyId, BuildingType building){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d/building", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}");
			throw new IllegalArgumentException(message, e);
		}
		
		String body = null;
		body = Executor.toXmlString(building);
		return runner.post(uri, body, ResponseType.class);
	}
	
	/**
	 * Updates a building based on the information provided in the XML request.
	 * @param buildingId
	 * @param building
	 * @return
	 */
	public ResponseType updateBuilding(long buildingId, BuildingType building){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/building/%d", getServletString(), buildingId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /building/{buildingId}");
			throw new IllegalArgumentException(message, e);
		}
		
		String body = null;
		body = Executor.toXmlString(building);
		return runner.put(uri, body, ResponseType.class);
	}
	
	/**
	 * Deletes a specified property.
	 * @param buildingId
	 * @return
	 */
	public ResponseType deleteBuilding(long buildingId){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/building/%d", getServletString(), buildingId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /building/{buildingId}");
			throw new IllegalArgumentException(message, e);
		}
		
		return runner.delete(uri, ResponseType.class);
	}
	
	/**
	 * Returns a list of buildings for a specific property that is shared with you.
	 * @param propertyId
	 * @return
	 */
	public ResponseType getBuildingList(long propertyId){
		URI uri = null;
		try {
			URIBuilder builder = new URIBuilder(String.format("/%s/property/%d/building/list", getServletString(), propertyId));
			uri = builder.build();
		} catch (URISyntaxException e) {
			String message = String.format("Could not build URI: /property/{propertyId}/building/list");
			throw new IllegalArgumentException(message, e);
		}
		
		return runner.get(uri, ResponseType.class);
	}

}
