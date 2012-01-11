package com.harioca.client.ui.torefactor;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.harioca.client.service.HariocaShellService;
import com.harioca.client.ui.consolepage.ResultsPanel;
import com.harioca.client.ui.consolepage.SettingsPanel;
import com.mastergaurav.codemirror.client.CodeMirror;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class HariocaEntryPoint implements EntryPoint {

    //todo look for another way
    public static int WIDTH_100 = RootPanel.get().getElement().getClientWidth();

    @Override
    public void onModuleLoad() {
//        RootPanel.get().addStyleName("harioca-rootPanel");

        final VLayout pageConsoleLayout = new VLayout(10);
        pageConsoleLayout.setWidth100();
        pageConsoleLayout.setHeight100();
//        pageConsoleLayout.setWidth(WIDTH_100);
//        pageConsoleLayout.setHPolicy(LayoutPolicy.FILL);

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

        final CodeMirror codeMirror = CodeMirror.forJava(consoleTextArea.getElement().<TextAreaElement>cast());
        codeMirror.setWidth(98, Style.Unit.PCT);
        codeMirror.setHeight(98, Style.Unit.PCT);

//        final HRowBrowser hRowBrowser = new HRowBrowser();
//        RootPanel.get().add(hRowBrowser, -Math.round(WIDTH_100 * 0.03f), consoleViewLayout.getVisibleHeight() + 10); // todo put on the same layout


//todo remove
        final Button b = new Button("test");
        b.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
//                HRowBrowser.init();
//                hRowBrowser.loadRow(1, 0);
//                hRowBrowser.loadRow(2, 1);

                HariocaShellService.App.getInstance().getLog(new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught) {
                    }

                    @Override
                    public void onSuccess(String log) {
//                        logPanel.addLog(log);
                    }
                });
            }
        });
//        RootPanel.get().add(b, 400, 400);
    }
}
