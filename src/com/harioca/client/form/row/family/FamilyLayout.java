package com.harioca.client.form.row.family;

import com.harioca.client.form.row.family.FamilyHeader;
import com.harioca.client.form.row.family.FamilyLayoutFirstLoad;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.Layout;

public class FamilyLayout extends Layout {

    private final FamilyHeader familyHeader;

    public FamilyLayout(FamilyLayoutFirstLoad familyLayoutFirstLoad) {
        setTop(familyLayoutFirstLoad.getTop());
        setLeft(familyLayoutFirstLoad.getLeft());
        setWidth(familyLayoutFirstLoad.getVisibleWidth());

        setBorder("1px solid #bfdfcc");

        for (Canvas item : familyLayoutFirstLoad.getChildren()) {
            addChild(item);
        }

        familyHeader = familyLayoutFirstLoad.getHeader();
        familyHeader.addExpandClickHandler(this);
    }

    public FamilyHeader getFamilyHeader() {
        return familyHeader;
    }
}
