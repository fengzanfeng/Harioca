package com.harioca.server;

import com.harioca.client.HariocaShellService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.harioca.client.TestData___DeleteMe;
import com.harioca.client.bean.hbase.HPageDefinition;
import com.harioca.client.bean.hbase.HRow;
import groovy.lang.GroovyShell;

public class HariocaShellServiceImpl extends RemoteServiceServlet implements HariocaShellService {

    public HRow getHRow(Integer rowN) {
        return TestData___DeleteMe.getTestHRow(rowN);
    }

    public HPageDefinition getHPageDefinition() {
        return TestData___DeleteMe.getHPageDefinition();
    }


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