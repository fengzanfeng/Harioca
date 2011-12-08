package com.harioca.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HariocaShellServiceAsync {
    void run(String msg, AsyncCallback<String> async);
}
