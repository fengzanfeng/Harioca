package com.harioca.client.ui.consolepage;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harioca.client.service.HariocaShellService;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
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

        final ListGrid librariesGrid = new ListGrid();
        librariesGrid.addStyleName("console-connection-form");
        librariesGrid.setWidth100();
        librariesGrid.setHeight100();
        librariesGrid.setShowHeader(false);
        librariesGrid.setShowAllRecords(true);
        librariesGrid.setShowAllColumns(true);
        librariesGrid.setFields(new ListGridField("libName", 180), new ListGridField("libVersion", 58));
        librariesGrid.setData(LibTestValues.getTestLibList());
        addMember(librariesGrid);
        
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

       executeBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                CodeRunner.get().run();
            }
        });
    }
}

class LibraryRecord extends ListGridRecord {

    public LibraryRecord() {}

    public LibraryRecord(String libName, String libVersion) {
        setLibName(libName);
        setLibVersion(libVersion);
    }

    public void setLibName(String libName) {
        setAttribute("libName", libName);
    }

    public String getLibName() {
        return getAttributeAsString("libName");
    }

    public void setLibVersion(String libVersion) {
        setAttribute("libVersion", libVersion);
    }

    public String getLibVersion() {
        return getAttributeAsString("libVersion");
    }

    public String getFieldValue(String field) {
        return getAttributeAsString(field);
    }
}

class LibTestValues {

    public static LibraryRecord[] getTestLibList () {
        return new LibraryRecord[] {
                new LibraryRecord("hadoop-core-0.20.205.0.jar", "0.20.205.0"),
                new LibraryRecord("hbase-0.90.5.jar", "0.90.5"),
                new LibraryRecord("zookeeper-3.3.2.jar", "3.3.2"),
                new LibraryRecord("groovy-all-1.8.4.jar", "1.8.4"),
                new LibraryRecord("commons-collections-3.2.1.jar", "3.2.1"),
                new LibraryRecord("mycompany-hbase.jar", "1.0")
        };
    }
}