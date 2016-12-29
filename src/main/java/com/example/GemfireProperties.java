/*package com.example;

import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="ccp.gemfire")
public class GemfireProperties {

	private String singleHopEnabled;
	private String readSerialized;
	private String locators;
	private String socketBufferSize;
	private String poolSubscriptionEnabled;
	private String disableShutdownHook;
	private String customSerialize;
	private String pdxClassPattern;
	private Properties properties = new Properties();
	private Log LOG = LogFactory.getLog(GemfireProperties.class.getName());
	private Properties config;

	public String getSingleHopEnabled() {
		return singleHopEnabled;
	}

	public void setSingleHopEnabled(String singleHopEnabled) {
		this.singleHopEnabled = singleHopEnabled;
	}

	public String getReadSerialized() {
		return readSerialized;
	}

	public void setReadSerialized(String readSerialized) {
		this.readSerialized = readSerialized;
	}

	public String getLocators() {
		return locators;
	}

	public void setLocators(String locators) {
		this.locators = locators;
	}

	public String getSocketBufferSize() {
		return socketBufferSize;
	}

	public void setSocketBufferSize(String socketBufferSize) {
		this.socketBufferSize = socketBufferSize;
	}

	public String getPoolSubscriptionEnabled() {
		return poolSubscriptionEnabled;
	}

	public void setPoolSubscriptionEnabled(String poolSubscriptionEnabled) {
		this.poolSubscriptionEnabled = poolSubscriptionEnabled;
	}

	public String getDisableShutdownHook() {
		return disableShutdownHook;
	}

	public void setDisableShutdownHook(String disableShutdownHook) {
		this.disableShutdownHook = disableShutdownHook;
	}

	public String getCustomSerialize() {
		return customSerialize;
	}

	public void setCustomSerialize(String customSerialize) {
		this.customSerialize = customSerialize;
	}
	
	public String getPdxClassPattern() {
		return pdxClassPattern;
	}

	public void setPdxClassPattern(String pdxClassPattern) {
		this.pdxClassPattern = pdxClassPattern;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Properties getConfig() {
		if(config == null){
			config = new Properties();
			for(Entry<Object, Object> entry : properties.entrySet()) {
				config.setProperty("gemfire.properties."+entry.getKey(), (String) entry.getValue());
			}
			if(this.locators != null)
				config.setProperty("locators", this.locators);
			if(this.readSerialized != null)
				config.setProperty("readSerialized", this.readSerialized);
			if(this.singleHopEnabled != null)
				config.setProperty("singleHopEnabled", this.singleHopEnabled);
			if(this.socketBufferSize != null)
				config.setProperty("socketBufferSize", this.socketBufferSize);
			if(this.poolSubscriptionEnabled != null)
				config.setProperty("poolSubscriptionEnabled", this.poolSubscriptionEnabled);
			if(this.customSerialize != null)
				config.setProperty("customSerialize", this.customSerialize);
			if(this.pdxClassPattern != null)
				config.setProperty("pdxClassPattern", this.pdxClassPattern);
			if(this.disableShutdownHook != null)
				config.setProperty("disableShutdownHook", this.disableShutdownHook);
			if(LOG.isDebugEnabled())
				LOG.debug("Properties from application.properties "+config);			
			return config;
		}else{
			return config;
		}		
	}

}
*/