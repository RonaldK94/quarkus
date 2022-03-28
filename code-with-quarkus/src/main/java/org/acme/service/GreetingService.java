package org.acme.service;

import org.acme.config.GreetingConfig;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    @Inject
    GreetingConfig greetingConfig;

    @ConfigProperty(name = "greeting.name")
    String name;

    public String sayHello() {
        return name;
    }

    public String sayHello(String name) {
        return String.format("Hello %s, your id is %s", greetingConfig.getName(), UUID.randomUUID().toString());
    }
}