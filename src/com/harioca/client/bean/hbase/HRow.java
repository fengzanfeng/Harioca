package com.harioca.client.bean.hbase;

import java.io.Serializable;
import java.util.Map;

public class HRow implements Serializable {        // todo rename to HResult

    private String rowId;
    private Map<String, Map<String, String>> data;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }
}
