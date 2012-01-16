package com.harioca.shell.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;

public class HBaseConnectionPool extends HTablePool {
    private HTablePool htablePool;

    public HBaseConnectionPool() {
    }

    public void init(String connectionUrl, int poolSize) {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", connectionUrl);
        htablePool = new HTablePool(config, poolSize);
    }

    @Override
    public HTableInterface getTable(byte[] tableName) {
        return htablePool.getTable(tableName);
    }

    @Override
    public HTableInterface getTable(String tableName) {
        return htablePool.getTable(tableName);
    }

    @Override
    public void putTable(HTableInterface table) {
        htablePool.putTable(table);
    }

    @Override
    public void closeTablePool(String tableName) {
        htablePool.closeTablePool(tableName);
    }

    @Override
    public void closeTablePool(byte[] tableName) {
        htablePool.closeTablePool(tableName);
    }

}
