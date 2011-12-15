package com.harioca.client.form.row.rowid;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.Layout;

public class RowIdLayout extends Layout {

    private final String rowId;

    public RowIdLayout(String rowId) {
        this.rowId = rowId;

        setDefaultLayoutAlign(Alignment.RIGHT);
        setLayoutLeftMargin(3);

        addMember(new RowIdElement(rowId));
    }

    public String getRowId() {
        return rowId;
    }
}
