package com.harioca.client.form.row;

import com.harioca.client.form.row.family.FamilyHeader;
import com.harioca.client.form.row.family.FamilyLayout;
import com.harioca.client.form.row.family.FamilyLayoutFirstLoad;
import com.harioca.client.form.row.rowid.RowIdLayout;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.Layout;

public class HRowFormLayout extends Layout {

    private Boolean inFloatingMode = false;

    public HRowFormLayout(HRowFormFirstLoadLayout hRowFormFirstLoadLayout) {
        setMembersMargin(10);

        for (final Canvas layoutFirstLoad : hRowFormFirstLoadLayout.getMembers()) {
            if (layoutFirstLoad instanceof RowIdLayout) {
                hRowFormFirstLoadLayout.removeMember(layoutFirstLoad);
                addChild(layoutFirstLoad);
            } else {
                FamilyLayout familyLayout = new FamilyLayout((FamilyLayoutFirstLoad) layoutFirstLoad);

                familyLayout.getFamilyHeader().setWidth(layoutFirstLoad.getVisibleWidth());
                familyLayout.getFamilyHeader().setLeft(0);

                addChild(familyLayout);
                layoutFirstLoad.destroy();
            }
        }
    }

    public void makeFloating(Boolean makeFloat) {
        for (final Canvas childLayout : getChildren()) {
            childLayout.setCanDragReposition(makeFloat);
            if (childLayout instanceof FamilyLayout) {
                FamilyHeader header = ((FamilyLayout) childLayout).getFamilyHeader();
                header.setBackgroundColor(makeFloat ? "#ffeeee" : "#eef6f2");
                for (final Canvas keyValueElement : childLayout.getChildren()) {
                    if (!keyValueElement.getID().equals(header.getID())) {
                        keyValueElement.setCanDragReposition(makeFloat);
                        keyValueElement.setCanDragResize(makeFloat);
                        keyValueElement.setDragAppearance(DragAppearance.TARGET);
                        keyValueElement.setDragOpacity(25);
                        keyValueElement.setBorder(makeFloat ? "1px dotted grey" : "");
                    }
                }
            }
            childLayout.setBorder(makeFloat ? "1px solid #ff8e8e" : "1px solid #bfdfcc");
        }
        inFloatingMode = makeFloat;
    }

    public Boolean isInFloatingMode() {
        return inFloatingMode;
    }
}
