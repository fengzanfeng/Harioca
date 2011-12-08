package com.harioca.client.smartgwt.widget;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.Layout;

public class RowIdLayout extends Layout {

    private final String rowId;

    public RowIdLayout(String rowId) {
        super();
        this.rowId = rowId;

        setDefaultLayoutAlign(Alignment.RIGHT);
        setExtraSpace(10);

        addMember(new RowIdElement(rowId));

        setBorder("1px solid #A7ABB4");
    }

    public String getRowId() {
        return rowId;
    }
}
