package com.harioca.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.harioca.client.bean.ResultsBean;
import com.harioca.client.bean.hbase.HPageDefinition;
import com.harioca.client.bean.hbase.HRow;

@RemoteServiceRelativePath("HariocaShellService")
public interface HariocaShellService extends RemoteService {

    ResultsBean run(String code);

    HRow getHRow(Integer rowN);

    HPageDefinition getHPageDefinition();
    
    String getLog();

    public static class App {
        private static HariocaShellServiceAsync ourInstance = GWT.create(HariocaShellService.class);

        public static synchronized HariocaShellServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
