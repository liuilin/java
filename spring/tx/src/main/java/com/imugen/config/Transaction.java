package com.imugen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Daniel Liu 2020/3/1 10:21
 */
public class Transaction {
    @Bean
    public DataSourceTransactionManager getTxManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}