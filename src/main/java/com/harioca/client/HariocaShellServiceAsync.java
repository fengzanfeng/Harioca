package com.harioca.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.harioca.client.bean.hbase.HPageDefinition;
import com.harioca.client.bean.hbase.HRow;

public interface HariocaShellServiceAsync {
    void run(String msg, AsyncCallback<String> async);
    void getHRow(Integer rowN, AsyncCallback<HRow> async);
    void getHPageDefinition(AsyncCallback<HPageDefinition> async);
}
