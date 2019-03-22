package com.ramon.pereira.albumstore.config;

import com.ramon.pereira.albumstore.business.DiscCatalogBusiness;
import com.ramon.pereira.albumstore.business.impl.DiscCatalogBusinessImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class SpringTestConfiguration {
    @Bean
    public DiscCatalogBusiness discCatalogBusiness() {
        return new DiscCatalogBusinessImpl();
    }
}
