package com.harioca.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.harioca.client.bean.ResultsBean;
import com.harioca.client.bean.hbase.HPageDefinition;
import com.harioca.client.bean.hbase.HRow;
import com.harioca.client.service.HariocaShellService;

public class HariocaShellServiceImpl extends RemoteServiceServlet implements HariocaShellService {

    public HRow getHRow(Integer rowN) {
        return TestData___DeleteMe.getTestHRow(rowN);
    }

    public HPageDefinition getHPageDefinition() {
        return TestData___DeleteMe.getHPageDefinition();
    }

    public String getLog() {
        return TestData___DeleteMe.getLog();
    }

    // Implementation of sample interface method
    public ResultsBean run(String code) {
//        String result = "";
//        try {
//            GroovyShell gs = new GroovyShell();
//            result = (String) gs.evaluate(msg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//

        ResultsBean results = new ResultsBean();
        results.setRowsSelected("100");
        results.setRowsInserted("0");
        results.setRowsDeleted("0");
        results.setTimingTotal("1200");
        results.setTimingMeanRequest("1");
        results.setTimingCompilation("18");
        results.setPerformanceRequests("10");
        results.setPerformanceVolume("1422 bytes");
        results.setPerformanceCPU("");
        results.setPerformanceMemory("");
        results.setPerformanceCached("100 rows");
        results.setLogsWarns("0");
        results.setLogsErrors("0");
        results.setAdvices(
                new String[]{
                        " - You got a lot of requests to the server. Try to increase cache volume."
                });

        return results;
    }
}