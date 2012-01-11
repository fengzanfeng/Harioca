package com.harioca.client.ui.consolepage;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.VLayout;

public class SettingsPanel extends VLayout {

    public SettingsPanel() {
        setMargin(10);
        setMembersMargin(10);
        setWidth(260);

        final Label connectionLabel = new Label("Connection TestDB 1");
        connectionLabel.addStyleName("console-connection-label");
        connectionLabel.setHeight(20);
        addMember(connectionLabel);

        final StaticTextItem hBaseVer = new StaticTextItem();
        hBaseVer.setTitle("<b>HBase ver.</b>");
        hBaseVer.setValue("0.90.5");

        final StaticTextItem hadoopVer = new StaticTextItem();
        hadoopVer.setTitle("<b>Hadoop ver.</b>");
        hadoopVer.setValue("0.20.205.0");

        final StaticTextItem zooKeeper = new StaticTextItem();
        zooKeeper.setTitle("<b>hbase.zookeeper.quorum</b>");
        zooKeeper.setValue("localhost");

        final StaticTextItem coreSiteLink = new StaticTextItem();
        coreSiteLink.setShowTitle(false);
        coreSiteLink.setValue("<font color='blue'><u><b>core-site.xml</b></u></font>");

        final StaticTextItem coreDefaultLink = new StaticTextItem();
        coreDefaultLink.setShowTitle(false);
        coreDefaultLink.setValue("<font color='blue'><u><b>core-default.xml</b></u></font>");

        final DynamicForm connectionShortInfoForm = new DynamicForm();
        connectionShortInfoForm.addStyleName("console-connection-form");
        connectionShortInfoForm.setCellPadding(5);
        connectionShortInfoForm.setNumCols(1);
        connectionShortInfoForm.setWidth100();
        connectionShortInfoForm.setTitleAlign(Alignment.LEFT);
        connectionShortInfoForm.setItems(hBaseVer, hadoopVer, zooKeeper, coreSiteLink, coreDefaultLink);
        addMember(connectionShortInfoForm);

        final Label librariesLabel = new Label("Libraries");
        librariesLabel.addStyleName("console-libraries-label");
        librariesLabel.setHeight(20);
        addMember(librariesLabel);

        final DynamicForm librariesShortInfoForm = new DynamicForm();
        librariesShortInfoForm.addStyleName("console-connection-form");
        librariesShortInfoForm.setCellPadding(5);
        librariesShortInfoForm.setNumCols(1);
        librariesShortInfoForm.setWidth100();
        librariesShortInfoForm.setHeight100();
        librariesShortInfoForm.setTitleAlign(Alignment.LEFT);
//        connectionShortInfoForm.setItems(zooKeeper, coreSiteLink, coreDefaultLink);
        addMember(librariesShortInfoForm);
        
        final Button bookmarkBtn = new Button("<font size=3>Bookmark</font>");
        bookmarkBtn.setPadding(20);
        bookmarkBtn.setAlign(Alignment.LEFT);
        bookmarkBtn.setWidth100();
        bookmarkBtn.setHeight(40);
        addMember(bookmarkBtn);

        final Button executeBtn = new Button("<font size=3>Execute</font>");
        executeBtn.setPadding(20);
        executeBtn.setAlign(Alignment.LEFT);
        executeBtn.setWidth100();
        executeBtn.setHeight(40);
        addMember(executeBtn);
    }

}
