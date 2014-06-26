package rest;

import javax.inject.Inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.google.inject.Injector;

public class RestApplication extends ResourceConfig {
	
	@Inject
	public RestApplication(ServiceLocator serviceLocator) {
		packages("rest");
		
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator
        		.getService(GuiceIntoHK2Bridge.class);
        // guiceBridge.bridgeGuiceInjector();		
	}
}
