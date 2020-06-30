package com.ps.routingdatasources.conf;

import com.ps.routingdatasources.BranchList;
import com.ps.routingdatasources.datasource.PsRoutingDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        PsRoutingDataSource psRoutingDataSource = new PsRoutingDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(BranchList.BRANCH_1.name(), branchADataSource());
        targetDataSources.put(BranchList.BRANCH_2.name(), branchBDataSource());
        targetDataSources.put(BranchList.BRANCH_3.name(), branchCDataSource());
        psRoutingDataSource.setTargetDataSources(targetDataSources);
        psRoutingDataSource.setDefaultTargetDataSource(branchADataSource());
        return psRoutingDataSource;
    }

//    @Bean(name = "branchADataSource")
    public DataSource branchADataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/branch1");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789@Asdfghjkl");
        return dataSource;
    }

//    @Bean(name = "branchBDataSource")
    public DataSource branchBDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/branch2");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789@Asdfghjkl");
        return dataSource;
    }

//    @Bean(name = "branchCDataSource")
    public DataSource branchCDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/branch3");
        dataSource.setUsername("root");
        dataSource.setPassword("123456789@Asdfghjkl");
        return dataSource;
    }

}
