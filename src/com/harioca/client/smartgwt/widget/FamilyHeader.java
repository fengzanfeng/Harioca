package com.harioca.client.smartgwt.widget;

import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class FamilyHeader extends Label {

    private Boolean isExpanded = true;

    public FamilyHeader(String familyId) {
        super(familyId);
        setBackgroundColor("#eef6f2");
        setHeight(20);
        setID(FormItemFactory.getItemId(familyId));
//            setWidth("100%");
//        setAlign(Alignment.RIGHT);
        setIcon("icons/opener_opened.png");
        setIconOrientation("right");
        setIconAlign("right");
        setPadding(5);
    }

    public void addExpandClickHandler(final FamilyLayout familyLayout) {
        addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (isExpanded) {
                    setIcon("icons/opener_closed.png");
                    for (Canvas child : familyLayout.getChildren()) {
                        if (!child.getID().equals(getID())) {
                            child.hide();
                        }
                    }
                } else {
                    setIcon("icons/opener_opened.png");
                    for (Canvas child : familyLayout.getChildren()) {
                        if (!child.getID().equals(getID())) {
                            child.show();
                        }
                    }
                }
                familyLayout.setHeight(25);
                familyLayout.setAutoHeight();
                isExpanded = !isExpanded;
            }
        });
    }

    public Boolean isExpanded() {
        return isExpanded;
    }
}
