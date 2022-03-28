package org.acme;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleListener {

    public static Logger LOGGER = Logger.getLogger("Lifecycle");

    public void onStart(@Observes StartupEvent startupEvent) {
        LOGGER.info("onStart executed");
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        LOGGER.info("onStop executed");
    }
}
