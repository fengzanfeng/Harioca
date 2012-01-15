package com.harioca.client.bean;

import java.io.Serializable;

public class ResultsBean implements Serializable {

    private String rowsSelected;
    private String rowsInserted;
    private String rowsDeleted;

    private String timingTotal;
    private String timingMeanRequest;
    private String timingCompilation;

    private String performanceRequests;
    private String performanceVolume;
    private String performanceCPU;
    private String performanceMemory;
    private String performanceCached;

    private String logsWarns;
    private String logsErrors;

    private String[] advices;

    public String getRowsSelected() {
        return rowsSelected;
    }

    public void setRowsSelected(String rowsSelected) {
        this.rowsSelected = rowsSelected;
    }

    public String getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(String rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public String getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(String rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

    public String getTimingTotal() {
        return timingTotal;
    }

    public void setTimingTotal(String timingTotal) {
        this.timingTotal = timingTotal;
    }

    public String getTimingMeanRequest() {
        return timingMeanRequest;
    }

    public void setTimingMeanRequest(String timingMeanRequest) {
        this.timingMeanRequest = timingMeanRequest;
    }

    public String getTimingCompilation() {
        return timingCompilation;
    }

    public void setTimingCompilation(String timingCompilation) {
        this.timingCompilation = timingCompilation;
    }

    public String getPerformanceRequests() {
        return performanceRequests;
    }

    public void setPerformanceRequests(String performanceRequests) {
        this.performanceRequests = performanceRequests;
    }

    public String getPerformanceVolume() {
        return performanceVolume;
    }

    public void setPerformanceVolume(String performanceVolume) {
        this.performanceVolume = performanceVolume;
    }

    public String getPerformanceCPU() {
        return performanceCPU;
    }

    public void setPerformanceCPU(String performanceCPU) {
        this.performanceCPU = performanceCPU;
    }

    public String getPerformanceMemory() {
        return performanceMemory;
    }

    public void setPerformanceMemory(String performanceMemory) {
        this.performanceMemory = performanceMemory;
    }

    public String getPerformanceCached() {
        return performanceCached;
    }

    public void setPerformanceCached(String performanceCached) {
        this.performanceCached = performanceCached;
    }

    public String getLogsWarns() {
        return logsWarns;
    }

    public void setLogsWarns(String logsWarns) {
        this.logsWarns = logsWarns;
    }

    public String getLogsErrors() {
        return logsErrors;
    }

    public void setLogsErrors(String logsErrors) {
        this.logsErrors = logsErrors;
    }

    public String[] getAdvices() {
        return advices;
    }

    public void setAdvices(String[] advices) {
        this.advices = advices;
    }
}
