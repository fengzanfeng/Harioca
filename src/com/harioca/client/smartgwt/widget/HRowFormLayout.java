package com.harioca.client.smartgwt.widget;

import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HRow;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.Layout;

public class HRowFormLayout extends Layout {

    private Boolean inFloatingMode = false;

    public HRowFormLayout() {
        super();

        setVertical(true);
        setHPolicy(LayoutPolicy.NONE);
        setTop(40);
        setLeft("3%");
        setWidth("94%");
    }

    public void loadRow(HRow hRow) {
        final RowIdLayout rowIdLayout = new RowIdLayout(hRow.getRowId());
        addMember(rowIdLayout);
        for (HFamily hFamily : hRow.getHFamilies()) {
            final FamilyLayoutFirstLoad familyLayoutFirstLoad = new FamilyLayoutFirstLoad(hFamily);
            addMember(familyLayoutFirstLoad);
        }
    }

    public void postProcess() {
        for (final Canvas layoutFirstLoad : getMembers()) {
            if (layoutFirstLoad instanceof RowIdLayout) {
                removeMember(layoutFirstLoad);
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
