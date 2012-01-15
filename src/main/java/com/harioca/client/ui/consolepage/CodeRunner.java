package com.harioca.client.ui.consolepage;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harioca.client.bean.ResultsBean;
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
        HariocaShellService.App.getInstance().run(console.getCode(), new AsyncCallback<ResultsBean>() {

            @Override
            public void onSuccess(ResultsBean result) {
                resultsPanel.updateData(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                // show failure panel with caught
            }

        });
    }
}
