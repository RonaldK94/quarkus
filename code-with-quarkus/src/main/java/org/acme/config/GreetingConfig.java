package org.acme.config;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Optional;

@ConfigProperties(prefix = "greeting")
public class GreetingConfig {
    private String name;

    // ! as default value
    private String suffix = "!";

    //optional parameter
    private Optional<String> prefix;

    public Optional<String> getPrefix() {
        return prefix;
    }

    public void setPrefix(Optional<String> prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
