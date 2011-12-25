package com.harioca.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.harioca.client.ui.form.HRowBrowser;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HariocaEntryPoint implements EntryPoint {

    //todo look for another way
    public static int WIDTH_100 = RootPanel.get().getElement().getClientWidth();

    @Override
    public void onModuleLoad() {
        RootPanel.get().addStyleName("harioca-rootPanel");

        final VLayout consoleViewLayout = new VLayout();
        consoleViewLayout.setWidth(WIDTH_100);
        consoleViewLayout.setHPolicy(LayoutPolicy.FILL);

        final HLayout upperToolBar = getUpperToolBar();
        consoleViewLayout.addMember(upperToolBar);

        final TextArea consoleTextArea = getConsole();
        consoleTextArea.setHeight("480px"); // todo use %
        consoleViewLayout.addMember(consoleTextArea);

        final VLayout logPanel = getLogPanel();
        consoleViewLayout.addMember(logPanel);

        RootPanel.get().add(consoleViewLayout, 0, 0); // todo try to use draw

        final HRowBrowser hRowBrowser = new HRowBrowser();
        RootPanel.get().add(hRowBrowser, - Math.round(WIDTH_100 * 0.03f), consoleViewLayout.getVisibleHeight()); // todo put on the same layout

        final CodeMirror cm = CodeMirror.forJava(consoleTextArea.getElement().<TextAreaElement>cast());
        cm.setWidth(97, Style.Unit.PCT);


//todo remove
final Button b = new Button("test");
        b.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                HRowBrowser.init();
                hRowBrowser.loadRow(1, 0);
                hRowBrowser.loadRow(2, 1);
            }
        });
//hRowBrowser.addMember(b);
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

    private com.google.gwt.user.client.ui.TextArea getConsole() {
        TextArea consoleTextArea = new TextArea();
        consoleTextArea.getElement().setId("code");

        return consoleTextArea;
    }
}
