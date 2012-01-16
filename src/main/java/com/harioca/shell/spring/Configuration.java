package com.harioca.shell.spring;

import com.harioca.shell.ImportsFinder;
import com.harioca.shell.ScriptExecutor;
import com.harioca.shell.converter.ValueConverterFactory;
import com.harioca.shell.hbase.HBaseConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//import com.harioca.shell.hbase.HBaseConnectionPool;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:/connection.properties")
public class Configuration {
    public static final String QUORUM_URL = "hadoop.hbase.zookeeper.url";
    public static final String DEFAULT_TABLE = "hadoop.hbase.default.table";
    public static final String TABLE_POOL_SIZE = "hadoop.hbase.tablepool.size";
    @Autowired
    Environment env;

    @Bean
    public HBaseConnectionPool connectionPool() {
        HBaseConnectionPool connectionPool = new HBaseConnectionPool();
        connectionPool.init(env.getProperty(QUORUM_URL), env.getProperty(TABLE_POOL_SIZE, Integer.class));
        return connectionPool;
    }

    @Bean
    public ScriptExecutor scriptExecutor() {
        return new ScriptExecutor();
    }

    @Bean
    public ImportsFinder importsFinder() {
        return new ImportsFinder();
    }

    @Bean
    public ValueConverterFactory converterFactory() {
        return new ValueConverterFactory();
    }

}