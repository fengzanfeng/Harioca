package com.harioca.server;

import com.harioca.client.HariocaShellService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import groovy.lang.GroovyShell;

public class HariocaShellServiceImpl extends RemoteServiceServlet implements HariocaShellService {
    // Implementation of sample interface method
    public String run(String msg) {
        String result = "";
        try {
            GroovyShell gs = new GroovyShell();
            result = (String) gs.evaluate(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}