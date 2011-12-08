package com.harioca.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("HariocaShellService")
public interface HariocaShellService extends RemoteService {
    // Sample interface method of remote interface
    String run(String msg);

    /**
     * Utility/Convenience class.
     * Use HariocaShellService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static HariocaShellServiceAsync ourInstance = GWT.create(HariocaShellService.class);

        public static synchronized HariocaShellServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
