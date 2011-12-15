package com.harioca.client.form.row;

import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HRow;
import com.harioca.client.form.row.family.FamilyLayoutFirstLoad;
import com.harioca.client.form.row.rowid.RowIdLayout;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.layout.VLayout;

public class HRowFormFirstLoadLayout extends VLayout {

    public HRowFormFirstLoadLayout() {
        setHPolicy(LayoutPolicy.NONE);
        setMembersMargin(10);
    }

    public void loadRow(HRow hRow) {
        final RowIdLayout rowIdLayout = new RowIdLayout(hRow.getRowId());
        addMember(rowIdLayout);
        for (HFamily hFamily : hRow.getHFamilies()) {
            final FamilyLayoutFirstLoad familyLayoutFirstLoad = new FamilyLayoutFirstLoad(hFamily);
            addMember(familyLayoutFirstLoad);
        }
    }

}
