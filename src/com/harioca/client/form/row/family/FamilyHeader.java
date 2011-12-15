package com.harioca.client.form.row.family;

import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class FamilyHeader extends Label {

    private Boolean isExpanded = true;

    public FamilyHeader(String familyId) {
        super(familyId);
        setID(FormItemFactory.getItemId(familyId));

        setHeight(20);
        setPadding(5);

        setIcon("icons/opener_opened.png");
        setIconOrientation("right");
        setIconAlign("right");

        setBackgroundColor("#eef6f2");
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
