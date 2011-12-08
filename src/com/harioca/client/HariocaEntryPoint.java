package com.harioca.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.*;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;


public class HariocaEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        addUpperToolBar();

        addConsole();





//        final MainLayout mainLayout = new MainLayout();
//            HRow cRow = TestData___DeleteMe.getTestData();
//        mainLayout.getCRowFormLayout().loadRow(cRow);
//
//        RootPanel.get().add(mainLayout);
//
//        mainLayout.getCRowFormLayout().postProcess();
    }

    private void addConsole() {
        TextArea textArea = new TextArea();
        textArea.getElement().setId("code");

        RootPanel.get().add(textArea);
        CodeMirror cm = CodeMirror.forJava(textArea.getElement().<TextAreaElement>cast());
        cm.setWidth(97, Style.Unit.PCT);
    }

    private void addUpperToolBar() {
        HLayout upperToolBar = new HLayout(16);
        upperToolBar.setStyleName("carioca-upperToolBar");
        upperToolBar.setAlign(Alignment.CENTER);          // todo to css
        upperToolBar.setWidth("98%"); // todo remove
        upperToolBar.setHeight(50); // todo remove to css

        Label connectivityItem = new Label("Connectivity");
        connectivityItem.setStyleName("harioca-upperButton-d");
        connectivityItem.setHeight(50);
        upperToolBar.addMember(connectivityItem);

        Label librariesItem = new Label("Libraries");
        librariesItem.setStyleName("harioca-upperButton-d");
        librariesItem.setHeight(50);
        upperToolBar.addMember(librariesItem);

        Label consoleItem = new Label("Console");
        consoleItem.setStyleName("harioca-upperButton");
        consoleItem.setHeight(50);
        upperToolBar.addMember(consoleItem);

        Label bookmarksItem = new Label("Bookmarks");
        bookmarksItem.setStyleName("harioca-upperButton-d");
        bookmarksItem.setHeight(50);
        upperToolBar.addMember(bookmarksItem);

        RootPanel.get().add(upperToolBar);

        Label latestItem = new Label("Latest executed scripts");
        latestItem.setStyleName("harioca-upperButton-latest");
        latestItem.setWidth(160);
        latestItem.setHeight(50);
        latestItem.setLeft(upperToolBar.getWidth() - 170);
        upperToolBar.addChild(latestItem);
    }

}
