package com.harioca.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.harioca.client.bean.hbase.row.HRow;
import com.harioca.client.form.FormViewLayout;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HariocaEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        RootPanel.get().addStyleName("harioca-rootPanel");

        final VLayout consoleViewLayout = new VLayout(10);
        consoleViewLayout.setMargin(10);
        consoleViewLayout.setWidth100();

        final HLayout upperToolBar = getUpperToolBar();
        consoleViewLayout.addMember(upperToolBar);

        final TextArea consoleTextArea = getConsole();
        consoleTextArea.setHeight("480px");
        consoleViewLayout.addMember(consoleTextArea);

        final VLayout logPanel = getLogPanel();
        consoleViewLayout.addMember(logPanel);

        final FormViewLayout formViewLayout = getFormLayout();
        consoleViewLayout.addMember(formViewLayout);

        RootPanel.get().add(consoleViewLayout, 0, 0);

        final CodeMirror cm = CodeMirror.forJava(consoleTextArea.getElement().<TextAreaElement>cast());
        cm.setWidth(97, Style.Unit.PCT);
    }

    private HLayout getUpperToolBar() {
        HLayout upperToolBar = new HLayout(16);
        upperToolBar.setStyleName("harioca-upperToolBar");
        upperToolBar.setAlign(Alignment.CENTER);          // todo to css

        Label connectivityItem = new Label("Connectivity");
        connectivityItem.setStyleName("harioca-upperButton-d");
        connectivityItem.setHeight(40);
        upperToolBar.addMember(connectivityItem);

        Label librariesItem = new Label("Libraries");
        librariesItem.setStyleName("harioca-upperButton-d");
        librariesItem.setHeight(40);
        upperToolBar.addMember(librariesItem);

        Label consoleItem = new Label("Console");
        consoleItem.setStyleName("harioca-upperButton");
        consoleItem.setHeight(40);
        upperToolBar.addMember(consoleItem);

        Label bookmarksItem = new Label("Bookmarks");
        bookmarksItem.setStyleName("harioca-upperButton-d");
        bookmarksItem.setHeight(40);
        upperToolBar.addMember(bookmarksItem);

//        Label latestItem = new Label("Latest executed scripts");
//        latestItem.setStyleName("harioca-upperButton-latest");
//        latestItem.setWidth(160);
//        latestItem.setHeight(50);
//        latestItem.setLeft(upperToolBar.getWidth() - 170);
//        upperToolBar.addChild(latestItem);

        return upperToolBar;
    }

    private TextArea getConsole() {
        TextArea consoleTextArea = new TextArea();
        consoleTextArea.getElement().setId("code");

        return consoleTextArea;
    }

    public VLayout getLogPanel() {
        VLayout logPanel = new VLayout(0);
        logPanel.setStyleName("harioca-logPanel");

        HLayout logPanelHeader = new HLayout();
        logPanelHeader.setLayoutLeftMargin(3);
        logPanelHeader.setStyleName("harioca-logPanelHeader");
        logPanelHeader.setHeight(25);

        Label logTitle = new Label("Logs");
        logTitle.setStyleName("harioca-logTitle");
        logPanelHeader.addMember(logTitle);

        logPanel.addMember(logPanelHeader);

        TextArea logArea = new TextArea(); // todo change to smartgwt?
        logArea.setStyleName("harioca-logArea");
        logArea.setHeight("270px");
        logArea.setWidth("100%");
        logPanel.addMember(logArea);

        return logPanel;
    }

    public FormViewLayout getFormLayout() {
        final FormViewLayout formViewLayout = new FormViewLayout();

        return formViewLayout;
    }
}
