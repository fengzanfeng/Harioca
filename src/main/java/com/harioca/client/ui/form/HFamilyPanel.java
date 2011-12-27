package com.harioca.client.ui.form;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HFamilyPanel extends VLayout {

    private final Layout itemsPanel;

    public HFamilyPanel(String familyId) {
        setHeight(20);
        addStyleName("harioca-familyPanel");

        addMember(getHeader(familyId));

        itemsPanel = new Layout();
        itemsPanel.setAutoHeight();
        itemsPanel.setHPolicy(LayoutPolicy.NONE);
        itemsPanel.setVertical(true);
        itemsPanel.setDefaultLayoutAlign(Alignment.RIGHT);
        itemsPanel.setMembersMargin(2);
        itemsPanel.setLayoutLeftMargin(3);
        itemsPanel.setLayoutRightMargin(3);
        itemsPanel.addStyleName("harioca-familyItemsPanel");
        addMember(itemsPanel);
    }

    public void addHItem(HItem hItem) {
        itemsPanel.addMember(hItem);
    }

    public void updateItemsWidth(int valueLength) {
        for (Canvas member : itemsPanel.getMembers()) {
            ((HItem) member).setCommonWidth(valueLength);
        }
    }

    public Label getHeader(String familyId) {
        final Label header = new Label(familyId);
        header.setHeight(20);
        header.setPadding(5);
        header.setWrap(false);

        header.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (itemsPanel.isVisible()) {
                    itemsPanel.hide();
                } else {
                    itemsPanel.show();
                }
            }
        });

        return header;
    }
}
