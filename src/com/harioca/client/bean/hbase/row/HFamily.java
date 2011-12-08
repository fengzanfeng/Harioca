package com.harioca.client.bean.hbase.row;

import java.util.List;

public class HFamily {

    private String familyId;
    private List<HKeyValue> HKeyValues;

    public HFamily() {}

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public List<HKeyValue> getHKeyValues() {
        return HKeyValues;
    }

    public void setHKeyValues(List<HKeyValue> HKeyValues) {
        this.HKeyValues = HKeyValues;
    }
}
