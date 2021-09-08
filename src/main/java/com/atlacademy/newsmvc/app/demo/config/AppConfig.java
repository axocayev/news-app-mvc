package com.atlacademy.newsmvc.app.demo.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@ApplicationScope
    //  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //@SessionScope
    //@RequestScope
    public Student student(){
        return  new Student(22);
    }

}
