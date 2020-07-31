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
@ConfigurationProperties(prefix = "sbibits")
@PropertySource(value = {"classpath:application.yml"}, factory = YamlConfigFactory.class)
public class Contants {

    private String filepath;

    private String imgurl;

    private long expiretime;

    private String tokensecret;

    private int pwdfailedcount;

    private int expiredDay;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public long getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(long expiretime) {
        this.expiretime = expiretime;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public int getPwdfailedcount() {
        return pwdfailedcount;
    }

    public void setPwdfailedcount(int pwdfailedcount) {
        this.pwdfailedcount = pwdfailedcount;
    }

    public int getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(int expiredDay) {
        this.expiredDay = expiredDay;
    }

}
