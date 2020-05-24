package com.example.lab06.config;


import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;

@ConfigurationProperties("lab01.features")
@Validated
public class Lab01Properties {


    private boolean panicEnabled;

    public boolean isPanicEnabled() {
        return panicEnabled;
    }

    public void setPanicEnabled(boolean panicEnabled) {
        this.panicEnabled = panicEnabled;
    }

    @NotNull(message = "ctaCteApi not null")
    private Api ctaCteApi;

    @NotNull(message = "ctaAhoApi not null")
    private Api ctaAhoApi;


    public Api getCtaCteApi() {
        return ctaCteApi;
    }

    public void setCtaCteApi(Api ctaCteApi) {
        this.ctaCteApi = ctaCteApi;
    }

    public Api getCtaAhoApi() {
        return ctaAhoApi;
    }

    public void setCtaAhoApi(Api ctaAhoApi) {
        this.ctaAhoApi = ctaAhoApi;
    }

    public static class Api{
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
