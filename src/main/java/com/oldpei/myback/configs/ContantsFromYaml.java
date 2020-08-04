package com.oldpei.myback.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * papyless cunstom Configuration class.
 *
 * @author jixing.pei
 * @version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "oldpei")
@PropertySource(value = {"classpath:application.yml"}, factory = YamlConfigFactory.class)
public class ContantsFromYaml {

    private String filepath;
    private String expiretime;
    private String tokensecret;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }
}
