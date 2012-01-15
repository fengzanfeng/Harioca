package com.harioca.client.ui.consolepage;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harioca.client.service.HariocaShellService;

public class CodeRunner {

    public static final CodeRunner codeRunner = new CodeRunner();

    private CodeRunner() {}

    public static CodeRunner get() {
        return codeRunner;
    }

    private Console console;
    public void setConsole(Console console) {
        this.console = console;
    }

    private ResultsPanel resultsPanel;
    public void setResultsPanel(ResultsPanel resultsPanel) {
        this.resultsPanel = resultsPanel;
    }

    public void run() {
        HariocaShellService.App.getInstance().run(console.getCode(), new AsyncCallback<String>() {

            @Override
            public void onSuccess(String result) {
                resultsPanel.updateData();
            }

            @Override
            public void onFailure(Throwable caught) {
                // show failure panel with caught
            }

        });
    }
}
