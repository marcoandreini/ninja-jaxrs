package conf;

import ninja.servlet.NinjaServletDispatcher;

import org.glassfish.jersey.servlet.ServletContainer;

import rest.RestApplication;

import com.google.common.collect.ImmutableMap;

/**
 * @author marco
 *
 */
public class ServletModule extends com.google.inject.servlet.ServletModule {
	
    @Override
    protected void configureServlets() {
    	bind(RestApplication.InjectorWrapper.class).asEagerSingleton();
    	bind(ServletContainer.class).asEagerSingleton();
        serve("/rest/*").with(ServletContainer.class, ImmutableMap
    			.of("javax.ws.rs.Application", RestApplication.class.getName(),
    			"jersey.config.server.wadl.disableWadl", "true"));
//        new GuiceResteasyBootstrapServletContextListener();
//    	
//        bind(ResteasyBootstrap.class).asEagerSingleton();
//        serve("/rest/*").with(ResteasyBootstrap.class);
        
        bind(NinjaServletDispatcher.class).asEagerSingleton();
        serve("/*").with(NinjaServletDispatcher.class);
    }
}