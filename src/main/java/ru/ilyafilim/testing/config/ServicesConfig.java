package ru.ilyafilim.testing.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ServicesConfig {

    @Bean
    public MessageSource messagesSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }
}
