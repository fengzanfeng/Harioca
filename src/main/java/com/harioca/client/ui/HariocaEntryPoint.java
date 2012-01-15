package com.harioca.client.ui;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.harioca.client.ui.consolepage.Console;
import com.harioca.client.ui.consolepage.ResultsPanel;
import com.harioca.client.ui.consolepage.SettingsPanel;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HariocaEntryPoint implements EntryPoint {

    //todo look for another way
    public static int WIDTH_100 = RootPanel.get().getElement().getClientWidth();

    @Override
    public void onModuleLoad() {
        final VLayout pageConsoleLayout = new VLayout(10);
        pageConsoleLayout.setWidth100();
        pageConsoleLayout.setHeight100();

        pageConsoleLayout.addMember(new UpperToolBar());

        final HLayout centralLayout = new HLayout(5);
        centralLayout.setWidth("99%");
        centralLayout.setHeight("99%");

        final TextArea consoleTextArea = new TextArea();
        consoleTextArea.getElement().setId("code");
        consoleTextArea.setWidth("100%");
        consoleTextArea.setHeight("100%");
        centralLayout.addMember(consoleTextArea);

        centralLayout.addMember(new SettingsPanel());

        pageConsoleLayout.addMember(centralLayout);
        pageConsoleLayout.addMember(new ResultsPanel());

        pageConsoleLayout.draw();

        new Console(consoleTextArea);

//        final HRowBrowser hRowBrowser = new HRowBrowser();
//        RootPanel.get().add(hRowBrowser, -Math.round(WIDTH_100 * 0.03f), consoleViewLayout.getVisibleHeight() + 10);

//        final Button b = new Button("test");
//        b.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                HRowBrowser.init();
//                hRowBrowser.loadRow(1, 0);
//                hRowBrowser.loadRow(2, 1);
//
//                HariocaShellService.App.getInstance().getLog(new AsyncCallback<String>() {
//                    @Override
//                    public void onFailure(Throwable caught) {
//                    }
//
//                    @Override
//                    public void onSuccess(String log) {
//                        logPanel.addLog(log);
//                    }
//                });
//            }
//        });
    }
}
