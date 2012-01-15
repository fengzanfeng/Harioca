package com.harioca.client.ui.consolepage;

import com.google.gwt.core.client.GWT;
import com.harioca.client.bean.ResultsBean;
import com.harioca.client.ui.UIContents;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ResultsPanel extends HLayout {

    private UIContents contents = (UIContents) GWT.create(UIContents.class);

    private final StaticTextItem rowsSelected = new StaticTextItem();
    private final StaticTextItem rowsInserted = new StaticTextItem();
    private final StaticTextItem rowsDeleted = new StaticTextItem();
    private final StaticTextItem rowsSeeResults = new StaticTextItem();

    private final StaticTextItem timingTotal = new StaticTextItem();
    private final StaticTextItem timingMeanRequest = new StaticTextItem();
    private final StaticTextItem timingCompilation = new StaticTextItem();

    private final StaticTextItem performanceRequests = new StaticTextItem();
    private final StaticTextItem performanceVolume = new StaticTextItem();
    private final StaticTextItem performanceCPU = new StaticTextItem();
    private final StaticTextItem performanceMemory = new StaticTextItem();
    private final StaticTextItem performanceCached = new StaticTextItem();

    private final StaticTextItem logsWarns = new StaticTextItem();
    private final StaticTextItem logsErrors = new StaticTextItem();
    private final StaticTextItem logsFullLog = new StaticTextItem();

    private final VLayout advicesPanel = new VLayout();

    public ResultsPanel() {
        setMargin(10);
        setHeight(200);

        final Label rowsTitle = new Label(contents.rows());
        rowsTitle.setStyleName("console-results-label");
        rowsTitle.setHeight(20);
        rowsTitle.setWidth(80);
        addMember(rowsTitle);

        final DynamicForm rowsForm = new DynamicForm();
        rowsForm.setStyleName("console-results-form");
        rowsForm.setWidth(140);
        rowsForm.setTitleAlign(Alignment.LEFT);
        rowsForm.setColWidths(105, 35);
        rowsSelected.setTitle(contents.selected());
        rowsInserted.setTitle(contents.inserted());
        rowsDeleted.setTitle(contents.deleted());
        rowsSeeResults.setShowTitle(false);
        rowsSeeResults.setColSpan(2);
        rowsSeeResults.setValue("<font color='blue' size=3><u>" + contents.seeResults() + "</u></font>");
        rowsForm.setItems(rowsSelected, rowsInserted, rowsDeleted, rowsSeeResults);
        addMember(rowsForm);

        final Label timingTitle = new Label(contents.timing());
        timingTitle.setStyleName("console-results-label");
        timingTitle.setAlign(Alignment.CENTER);
        timingTitle.setHeight(20);
        timingTitle.setWidth(150);
        addMember(timingTitle);

        final DynamicForm timingForm = new DynamicForm();
        timingForm.setStyleName("console-results-form");
        timingForm.setTitleAlign(Alignment.LEFT);
        timingForm.setWidth(140);
        timingForm.setColWidths(105, 35);
        timingTotal.setTitle(contents.total());
        timingMeanRequest.setTitle(contents.meanRequest());
        timingCompilation.setTitle(contents.compilation());
        timingForm.setItems(timingTotal, timingMeanRequest, timingCompilation);
        addMember(timingForm);

        final Label performanceTitle = new Label(contents.performance());
        performanceTitle.setStyleName("console-results-label");
        performanceTitle.setAlign(Alignment.CENTER);
        performanceTitle.setHeight(20);
        performanceTitle.setWidth(160);
        addMember(performanceTitle);

        final DynamicForm performanceForm = new DynamicForm();
        performanceForm.setStyleName("console-results-form");
        performanceForm.setTitleAlign(Alignment.LEFT);
        performanceForm.setWidth(170);
        performanceForm.setColWidths(105, 65);
        performanceRequests.setTitle(contents.requests());
        performanceVolume.setTitle(contents.volume());
        performanceCPU.setTitle(contents.CPU());
        performanceMemory.setTitle(contents.memory());
        performanceCached.setTitle(contents.cached());
        performanceForm.setItems(performanceRequests, performanceVolume, performanceCPU, performanceMemory, performanceCached);
        addMember(performanceForm);

        final Label logsTitle = new Label(contents.logs());
        logsTitle.setStyleName("console-results-label");
        logsTitle.setAlign(Alignment.CENTER);
        logsTitle.setHeight(20);
        logsTitle.setWidth(100);
        addMember(logsTitle);

        final DynamicForm logsForm = new DynamicForm();
        logsForm.setStyleName("console-results-form");
        logsForm.setTitleAlign(Alignment.LEFT);
        logsForm.setWidth(140);
        logsForm.setColWidths(105, 35);
        logsWarns.setTitle(contents.warns());
        logsErrors.setTitle(contents.errors());
        logsFullLog.setShowTitle(false);
        logsFullLog.setColSpan(2);
        logsFullLog.setValue("<font color='blue' size=3><u>" + contents.fullLog() + "</u></font>");
        logsForm.setItems(logsWarns, logsErrors, logsFullLog);
        addMember(logsForm);

        final Label advicesTitle = new Label(contents.advices());
        advicesTitle.setStyleName("console-results-label");
        advicesTitle.setAlign(Alignment.CENTER);
        advicesTitle.setHeight(20);
        advicesTitle.setWidth(120);
        addMember(advicesTitle);

        advicesPanel.setStyleName("console-advices-form");
        advicesPanel.setWidth("*");
        advicesPanel.setPadding(10);
        advicesPanel.setMembersMargin(5);
        final String[] advices = new String[] {
                contents.advice1(),
                contents.advice2()
        };
        for (String advice : advices) {
            final Label adviceLabel = new Label("<font size=3>" + advice + "</font>");
            adviceLabel.setHeight(20);
            advicesPanel.addMember(adviceLabel);
        }
        addMember(advicesPanel);

        CodeRunner.get().setResultsPanel(this);
    }

    public void updateData(ResultsBean results) {
        rowsSelected.setValue(results.getRowsSelected());
        rowsInserted.setValue(results.getRowsInserted());
        rowsDeleted.setValue(results.getRowsDeleted());
        
        timingTotal.setValue(results.getTimingTotal());
        timingMeanRequest.setValue(results.getTimingMeanRequest());
        timingCompilation.setValue(results.getTimingCompilation());

        performanceRequests.setValue(results.getPerformanceRequests());
        performanceVolume.setValue(results.getPerformanceVolume());
//        performanceCPU.setValue();
//        performanceMemory.setValue();
        performanceCached.setValue(results.getPerformanceCached());

        logsWarns.setValue(results.getLogsWarns());
        logsErrors.setValue(results.getLogsErrors());
        
        for (String advice : results.getAdvices()) {
            final Label adviceLabel = new Label("<font size=3>" + advice + "</font>");
            adviceLabel.setHeight(20);
            advicesPanel.addMember(adviceLabel);
        }
    }

}
