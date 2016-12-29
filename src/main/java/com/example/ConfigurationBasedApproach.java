/*package com.example;

import java.util.Properties;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.gemfire.config.annotation.web.http.EnableGemFireHttpSession;

import com.gemstone.gemfire.cache.RegionShortcut;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.internal.cache.tx.TransactionalOperation.ServerRegionOperation;

@Configuration
@EnableGemFireHttpSession(regionName="SSO",clientRegionShortcut=ClientRegionShortcut.PROXY,serverRegionShortcut=RegionShortcut.PARTITION)
@EnableConfigurationProperties(GemfireProperties.class)
public class ConfigurationBasedApproach {
	
	private Logger LOG = Logger.getLogger("ssss");
	
	@Autowired
	GemfireProperties gemfireProp;
	
	@Bean
	public Pool pool(ClientCache clientCache ){
		Pool pool =  clientCache.getDefaultPool();		
		return pool; 
	}	
   

    @Bean
    ClientCache gemfireCache() { 
            //ClientCacheFactoryBean clientCacheFactory = new ClientCacheFactoryBean();
            Properties config= gemfireProp.getConfig();
            ClientCacheFactory cacheFactory = new ClientCacheFactory();
            
    		String singleHop = config
    				.getProperty(ConnectorConstants.GEMFIRE_CONFIG_PR_SINGLE_HOP_ENABLED);
    		if (singleHop != null) {
    			cacheFactory.setPoolPRSingleHopEnabled(Boolean
    					.parseBoolean(singleHop));
    		}
    		String bufferSize = config
    				.getProperty(ConnectorConstants.GEMFIRE_CONFIG_SOCKET_BUFFER_SIZE);
    		if (bufferSize != null) {
    			cacheFactory.setPoolSocketBufferSize(Integer
    					.parseInt(bufferSize));
    		}
    		String[] locators = getLocator();
    		for (String locator : locators) {
    			String[] tokens = locator.split(":", 100);
    			cacheFactory.addPoolLocator(tokens[0],
    					Integer.parseInt(tokens[1]));
    		}
    		if (Boolean.TRUE.equals(Boolean.parseBoolean(config
    				.getProperty(ConnectorConstants.APP_CONFIG_CUSTOMSERIALIZE,"true")))) {
    			String pdxClassPattern = config.getProperty(ConnectorConstants.GEMFIRE_PDX_CLASS_PATTERN,ConnectorConstants.DEFAULT_PDX_CLASS_PATTERN);
    			cacheFactory
    					.setPdxSerializer(new CustomReflectionBasedAutoSerializer(
    							false, pdxClassPattern));
    		}
    		if (Boolean.TRUE
    				.equals(Boolean.parseBoolean(config
    						.getProperty(ConnectorConstants.GEMFIRE_CONFIG_READ_SERIALIZED)))) {
    			cacheFactory.setPdxReadSerialized(true);
    		}
    		if (Boolean.TRUE
    				.equals(Boolean.parseBoolean(config
    						.getProperty(ConnectorConstants.GEMFIRE_CONFIG_POOL_SUBSCRIPTION_ENABLED)))) {
    			cacheFactory.setPoolSubscriptionEnabled(true);
    		}	
    		
    		String trustStrPwdKey = config.containsKey("gemfire.properties.server-ssl-truststore-password")?"gemfire.properties.server-ssl-truststore-password":config.containsKey("gemfire.properties.cluster-ssl-truststore-password")?"gemfire.properties.cluster-ssl-truststore-password":null;
    		String keyStrPwdKey = config.containsKey("gemfire.properties.server-ssl-keystore-password")?"gemfire.properties.server-ssl-keystore-password":config.containsKey("gemfire.properties.cluster-ssl-keystore-password")?"gemfire.properties.cluster-ssl-keystore-password":null;
    		 //Passwords are set to System property to avoid being printed in logs
    		if(trustStrPwdKey != null){
    			String trustStrPwd = (String) config.remove(trustStrPwdKey);
    			if(System.getProperty("javax.net.ssl.trustStorePassword")!=null){
    				if(LOG.isDebugEnabled()){
    					LOG.debug("javax.net.ssl.trustStorePassword is already present, overriding it with Gemfire configuration. Current value is "+System.getProperty("javax.net.ssl.trustStorePassword"));
    				} else if(LOG.isWarnEnabled()){
    					LOG.warn("javax.net.ssl.trustStorePassword is already present, overriding it with Gemfire configuration");
    				}				
    			}
    			System.setProperty("javax.net.ssl.trustStorePassword", (String) trustStrPwd);
    		}
    		if(keyStrPwdKey != null){
    			String keyStrPwd = (String) config.remove(keyStrPwdKey);
    			if(System.getProperty("javax.net.ssl.keyStorePassword")!=null){
    				if(LOG.isDebugEnabled()){
    					LOG.debug("javax.net.ssl.keyStorePassword is already present, overriding it with Gemfire configuration. Current value is "+System.getProperty("javax.net.ssl.keyStorePassword"));
    				} else if(LOG.isWarnEnabled()){
    					LOG.warn("javax.net.ssl.keyStorePassword is already present, overriding it with Gemfire configuration");
    				}				
    			}
    			System.setProperty("javax.net.ssl.keyStorePassword", (String) keyStrPwd);
    		}
    		
    		for(Entry<Object, Object> entry : config.entrySet()) {
    			String propertyName = (String)entry.getKey();
    			if(propertyName.startsWith("gemfire.properties.")) {
    				cacheFactory.set(propertyName.replaceFirst("gemfire.properties.", ""), (String) entry.getValue());
    			}
    		}	
    		return cacheFactory.create();

            clientCacheFactory.setClose(true);
            clientCacheFactory.setProperties(gemfireProperties());

            return clientCacheFactory;
    }
    
    private String[] getLocator() {
		String locators = gemfireProp.getConfig().
				getProperty(ConnectorConstants.GEMFIRE_CONFIG_LOCATORS);
		locators = locators.replace("[", ":").replace("]", "");
		return locators.split(",", 100);
	}


	
}
*/