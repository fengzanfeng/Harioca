package com.harioca.client.ui.consolepage;

import com.google.gwt.core.client.GWT;
import com.harioca.client.ui.UIContents;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ResultsPanel extends HLayout {

    private UIContents contents = (UIContents) GWT.create(UIContents.class);

    private final StaticTextItem rowsSelected = new StaticTextItem(contents.resultsSelected(), contents.resultsSelected());
    private final StaticTextItem rowsInserted = new StaticTextItem(contents.resultsInserted(), contents.resultsInserted());
    private final StaticTextItem rowsDeleted = new StaticTextItem(contents.resultsDeleted(), contents.resultsDeleted());
    private final StaticTextItem rowsSeeResults = new StaticTextItem();

    public ResultsPanel() {
        setMargin(10);
        setHeight(200);

        final Label rowsTitle = new Label("Rows");
        rowsTitle.addStyleName("console-results-label");
        rowsTitle.setHeight(20);
        rowsTitle.setWidth(80);
        addMember(rowsTitle);

        final DynamicForm rowsForm = new DynamicForm();
        rowsForm.addStyleName("console-results-form");
        rowsForm.setWidth(120);
//        rowsForm.setMinColWidth(120);
        rowsForm.setTitleAlign(Alignment.LEFT);
//        rowsForm.setAlign(Alignment.CENTER);
        rowsSeeResults.setShowTitle(false);
        rowsSeeResults.setValue("<font color='blue' size=3>" + contents.seeResults() + "</font>");
        rowsForm.setItems(rowsSelected, rowsInserted, rowsDeleted);

        addMember(rowsForm);


        final Label timingTitle = new Label("Timing (ms) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        timingTitle.addStyleName("console-results-label");
        timingTitle.setAlign(Alignment.CENTER);
        timingTitle.setHeight(20);
        timingTitle.setWidth(150);
        addMember(timingTitle);

        final VLayout timingPanel = new VLayout();
        timingPanel.addStyleName("console-results-form");
        timingPanel.setWidth(130);

        final Label timingTotal = new Label("Total: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 12");
        timingTotal.setHeight(20);
        timingPanel.addMember(timingTotal);

        final Label timingMeanRequest = new Label("Mean per Request:");
        timingMeanRequest.setHeight(20);
        timingPanel.addMember(timingMeanRequest);

        final Label rowsCompilation = new Label("Compilation: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4");
        rowsCompilation.setHeight(20);
        timingPanel.addMember(rowsCompilation);

        addMember(timingPanel);


        final Label performanceTitle = new Label("Performance &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        performanceTitle.addStyleName("console-results-label");
        performanceTitle.setAlign(Alignment.CENTER);
        performanceTitle.setHeight(20);
        performanceTitle.setWidth(160);
        addMember(performanceTitle);

        final VLayout performancePanel = new VLayout();
        performancePanel.addStyleName("console-results-form");
        performancePanel.setWidth(130);

        final Label performanceRequests = new Label("Requests: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 10");
        performanceRequests.setHeight(20);
        performancePanel.addMember(performanceRequests);

        final Label performanceVolume = new Label("Volume: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1422 bytes");
        performanceVolume.setHeight(20);
        performancePanel.addMember(performanceVolume);

        final Label performanceCPU = new Label("CPU:");
        performanceCPU.setHeight(20);
        performancePanel.addMember(performanceCPU);

        final Label performanceMemory = new Label("Memory:");
        performanceMemory.setHeight(20);
        performancePanel.addMember(performanceMemory);

        final Label performanceCached = new Label("Cached: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 100 rows");
        performanceCached.setHeight(20);
        performancePanel.addMember(performanceCached);

        addMember(performancePanel);


        final Label logsTitle = new Label("Logs &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        logsTitle.addStyleName("console-results-label");
        logsTitle.setAlign(Alignment.CENTER);
        logsTitle.setHeight(20);
        logsTitle.setWidth(100);
        addMember(logsTitle);

        final VLayout logsPanel = new VLayout();
        logsPanel.addStyleName("console-results-form");
        logsPanel.setWidth(120);

        final Label logsWarns = new Label("Warns: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 0");
        logsWarns.setHeight(20);
        logsPanel.addMember(logsWarns);

        final Label logsErrors = new Label("Errors: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 0");
        logsErrors.setHeight(20);
        logsPanel.addMember(logsErrors);

        final Label logsFullLog = new Label("<font color='blue' size=3><u>See Full Log...</u></font>");
        logsFullLog.setHeight(20);
        logsPanel.addMember(logsFullLog);

        addMember(logsPanel);


        final Label advicesTitle = new Label("Advices &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        advicesTitle.addStyleName("console-results-label");
        advicesTitle.setAlign(Alignment.CENTER);
        advicesTitle.setHeight(20);
        advicesTitle.setWidth(120);
        addMember(advicesTitle);

        final VLayout advicesPanel = new VLayout();
        advicesPanel.addStyleName("console-advices-form");
        advicesPanel.setWidth("*");
        advicesPanel.setPadding(10);
        advicesPanel.setMembersMargin(5);

        final Label advicesFirst = new Label("<font size=3> - You got a lot of requests to the server. Try to increase cache volume. </font>");
        advicesFirst.setHeight(20);
        advicesPanel.addMember(advicesFirst);

        final Label advicesSecond = new Label("<font size=3> - Hadoop 1.0.0 is released. </font>");
        advicesSecond.setHeight(20);
        advicesPanel.addMember(advicesSecond);

        final Label advicesThird = new Label("<font size=3> - You can use hot-key Alt-E to execute your code. </font>");
        advicesThird.setHeight(20);
        advicesPanel.addMember(advicesThird);

        addMember(advicesPanel);

        CodeRunner.get().setResultsPanel(this);
    }

    public void updateData() {
        rowsSelected.setValue(100);
        rowsInserted.setValue(0);
        rowsDeleted.setValue(0);
    }

}
