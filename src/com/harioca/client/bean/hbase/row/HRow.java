package com.harioca.client.bean.hbase.row;

import java.util.List;

public class HRow {

    private String rowId;
    private List<HFamily> HFamilies;

    public HRow() {
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public List<HFamily> getHFamilies() {
        return HFamilies;
    }

    public void setHFamilies(List<HFamily> HFamilies) {
        this.HFamilies = HFamilies;
    }
}
