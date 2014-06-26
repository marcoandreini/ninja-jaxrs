package conf;

import javax.inject.Singleton;

import ninja.lifecycle.Start;
import ninja.utils.NinjaProperties;

import org.slf4j.bridge.SLF4JBridgeHandler;

import com.google.inject.Inject;

import dao.SetupDao;

@Singleton
public class StartupActions {
    
    @Inject
    SetupDao setupDao;

    private final NinjaProperties ninjaProperties;

    @Inject
    public StartupActions(NinjaProperties ninjaProperties) {
        this.ninjaProperties = ninjaProperties;
        
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
    
    @Start(order=100)
    public void generateDummyDataWhenInTest() {
        
        if (!ninjaProperties.isProd()) {
            
            setupDao.setup();
            
        }
    }

}
