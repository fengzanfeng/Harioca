package com.harioca.client.smartgwt;

import com.harioca.client.smartgwt.widget.HRowFormLayout;
import com.harioca.client.smartgwt.widget.ChangePanel;
import com.harioca.client.smartgwt.widget.PrimaryToolStrip;
import com.harioca.client.smartgwt.widget.PrimaryToolStripButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.Layout;

public class MainLayout extends Layout {

    private final HRowFormLayout hRowFormLayout;
    private final ChangePanel changePanel = new ChangePanel();;

    public MainLayout() {
        super();
        setWidth("99%");
        setVertical(true);

        final PrimaryToolStripButton floatingModeButton = new PrimaryToolStripButton("Floating Mode", "Ctrl+Alt+F");
        floatingModeButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hRowFormLayout.makeFloating(!hRowFormLayout.isInFloatingMode());

                if (hRowFormLayout.isInFloatingMode()) {
                    changePanel.show();
                } else {
                    changePanel.hide();
                }

                floatingModeButton.switchPressed();
            }
        });

        PrimaryToolStrip toolStrip = new PrimaryToolStrip();
        toolStrip.addSeparator();
        toolStrip.addMember(floatingModeButton);
        addMember(toolStrip);

        hRowFormLayout = new HRowFormLayout();
        addChild(hRowFormLayout);

        changePanel.hide();
        addChild(changePanel);
    }

    public HRowFormLayout getCRowFormLayout() {
        return hRowFormLayout;
    }
}
