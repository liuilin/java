package com.imugen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Daniel Liu 2020/3/1 9:58
 */
@Configuration
@ComponentScan("com.imugen")
@Import({DsConfig.class, Transaction.class})
@EnableTransactionManagement
@PropertySource("dataSource.properties")
public class SpringConfig {
}