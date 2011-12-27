package com.harioca.client.bean.hbase;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class HPageDefinition implements Serializable {

    private HItemDefinition rowIdType;
    private Map<String, List<HItemDefinition>> families;

    public HItemDefinition getRowIdType() {
        return rowIdType;
    }

    public void setRowIdType(HItemDefinition rowIdType) {
        this.rowIdType = rowIdType;
    }

    public Map<String, List<HItemDefinition>> getFamilies() {
        return families;
    }

    public void setFamilies(Map<String, List<HItemDefinition>> families) {
        this.families = families;
    }
}
