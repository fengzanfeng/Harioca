package com.harioca.shell;


import com.harioca.shell.converter.ResultConverter;
import com.harioca.shell.spring.Configuration;
import org.apache.hadoop.hbase.util.Bytes;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class, loader = AnnotationConfigContextLoader.class)
public class ScriptExecutorTest {

    @Autowired
    private ScriptExecutor scriptExecutor;


    @Test
    public void testCompileScript() throws Exception {
        String script = "String a = Bytes.toString(Bytes.toBytes(\"abc\"));";
        ShellClassLoader classLoader = scriptExecutor.scriptClassLoader("0.20.203.0", "0.90.3");
        String result = scriptExecutor.evaluateScript(
                script,
                scriptExecutor.getScriptEngine(classLoader),
                classLoader, scriptExecutor.createBindings()).toString();
        assertEquals("abc", result);
    }


    @Test
    public void testExecuteScript() throws Exception {
        String expectedRowKey =
                Bytes.toString(Bytes.add(Bytes.toBytes(75187L), Bytes.toBytes(0L), Bytes.toBytes(7975234476184556737L)));

        String script = "table = \"Meta\";" +
                "Get get = new Get(Bytes.add(Bytes.toBytes(75187L), Bytes.toBytes(0L), Bytes.toBytes(7975234476184556737L)));";
        Object result = scriptExecutor.execute(
                script,
                "0.20.2", "0.91.0-SNAPSHOT",
                Collections.<String>emptyList(),
                Collections.<String, String>emptyMap());
        assertTrue(result instanceof JSONObject);
        Object rowKey = ((JSONObject) result).get(ResultConverter.ROW_KEY);
        assertEquals(expectedRowKey, rowKey);
    }


//    public void testExecuteNoHBaseScript(){
//        scriptExecutor.execute();
//    }

}
