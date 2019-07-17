package com.cjh.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "web")
public class WebMenuProperties {
    private Map menu;

    public Map getMenu() {
        return menu;
    }

    public void setMenu(Map menu) {
        this.menu = menu;
    }
}
