package com.harioca.client.smartgwt.widget;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.Layout;

public class FamilyLayout extends Layout {

    private final String familyId;
    private final FamilyHeader familyHeader;

    public FamilyLayout(FamilyLayoutFirstLoad familyLayoutFirstLoad) {
        super();
        familyId = familyLayoutFirstLoad.getFamilyId();
        familyHeader = familyLayoutFirstLoad.getHeader();

        setTop(familyLayoutFirstLoad.getTop());
        setLeft(familyLayoutFirstLoad.getLeft());
        setWidth(familyLayoutFirstLoad.getVisibleWidth());

        setBorder("1px solid #bfdfcc");

        for (Canvas item : familyLayoutFirstLoad.getChildren()) {
            addChild(item);
        }

        familyHeader.addExpandClickHandler(this);
    }

    public String getFamilyId() {
        return familyId;
    }

    public FamilyHeader getFamilyHeader() {
        return familyHeader;
    }

    public Boolean isExpanded() {
        return getFamilyHeader().isExpanded();
    }
}
