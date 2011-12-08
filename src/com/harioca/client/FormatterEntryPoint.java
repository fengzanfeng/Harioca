package com.harioca.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.harioca.client.bean.hbase.row.HRow;
import com.harioca.client.smartgwt.MainLayout;


public class FormatterEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        final MainLayout mainLayout = new MainLayout();
            HRow hRow = TestData___DeleteMe.getTestData();
        mainLayout.getCRowFormLayout().loadRow(hRow);

        RootPanel.get().add(mainLayout);

        mainLayout.getCRowFormLayout().postProcess();
    }
}