package com.harioca.client.bean.hbase.row;

public class HKeyValue {

    private String key;
    private String value;

    public HKeyValue() {}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
