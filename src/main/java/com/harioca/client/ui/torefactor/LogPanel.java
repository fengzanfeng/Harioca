package com.harioca.client.ui.torefactor;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class LogPanel extends VLayout {

    private final TextAreaItem logArea;

    public LogPanel() {
        setStyleName("harioca-logPanel");

        final HLayout logPanelHeader = new HLayout();
        logPanelHeader.setLayoutLeftMargin(3);
        logPanelHeader.setStyleName("harioca-logPanelHeader");
        logPanelHeader.setHeight(25);

        final Label logTitle = new Label("Logs");
        logTitle.setStyleName("harioca-logTitle");
        logPanelHeader.addMember(logTitle);

        addMember(logPanelHeader);

        logArea = new TextAreaItem();
        logArea.setShowTitle(false);
        logArea.setWidth(HariocaEntryPoint.WIDTH_100);
        logArea.setHeight("100%");
        logArea.setFetchMissingValues(true);
        DynamicForm logAreaForm = new DynamicForm();
        logAreaForm.setHeight("270px");
        logAreaForm.setItems(logArea);
        addMember(logAreaForm);
    }

    public void addLog(String log) {
        logArea.setValue(log);
    }
}
