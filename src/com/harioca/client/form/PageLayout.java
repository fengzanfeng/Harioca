package com.harioca.client.form;

import com.harioca.client.form.row.HRowFormLayout;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;

public class PageLayout extends HLayout {

    private final HRowFormLayout hRowFormLayout;
    private final Layout leftArrow;

    public PageLayout(HRowFormLayout hRowFormLayout) {
        this.hRowFormLayout = hRowFormLayout;

        setMembersMargin(5);
        setBackgroundColor("#ffffff");

        leftArrow = new Layout();
        leftArrow.setWidth(100);
        leftArrow.setBackgroundColor("#eee");
        addMember(leftArrow);

        addMember(hRowFormLayout);
    }

    public Layout getLeftArrow() {
        return leftArrow;
    }

    public HRowFormLayout getRowFormLayout() {
        return hRowFormLayout;
    }
}

