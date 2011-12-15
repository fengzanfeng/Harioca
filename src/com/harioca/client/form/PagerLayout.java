package com.harioca.client.form;

import com.google.gwt.user.client.ui.RootPanel;
import com.harioca.client.bean.hbase.row.HRow;
import com.harioca.client.form.row.HRowFormFirstLoadLayout;
import com.harioca.client.form.row.HRowFormLayout;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;

import java.util.ArrayList;
import java.util.List;

public class PagerLayout extends HLayout {

    public PagerLayout() {
        setMembersMargin(5);
    }

    public PageLayout addPageLayout(HRow hRow) {
//        System.out.println("hRowFormLayout " + (System.currentTimeMillis() - start));
//        start = System.currentTimeMillis();
        final HRowFormFirstLoadLayout hRowFormFirstLoadLayout = new HRowFormFirstLoadLayout();
        hRowFormFirstLoadLayout.loadRow(hRow);

        hRowFormFirstLoadLayout.draw(); // todo is there any recalculate positions method?
        final HRowFormLayout hRowFormLayout = new HRowFormLayout(hRowFormFirstLoadLayout);
        hRowFormFirstLoadLayout.destroy();

        PageLayout pageLayout = new PageLayout(hRowFormLayout);
        addChild(pageLayout);

        return pageLayout;
    }
}
