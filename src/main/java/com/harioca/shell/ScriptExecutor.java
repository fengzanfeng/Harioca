package com.harioca.shell;

import com.harioca.shell.converter.ResultConverter;
import com.harioca.shell.converter.ValueConverterFactory;
import com.harioca.shell.hbase.HBaseConnectionPool;
import com.harioca.shell.spring.Configuration;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ScriptExecutor {

    @Autowired
    private Environment env;

    @Autowired
    private ImportsFinder importsFinder;

    @Autowired
    private ValueConverterFactory converterFactory;

    @Autowired
    private HBaseConnectionPool tablePool;

    public JSONObject execute(String script, String hadoopVersion, String hbaseVersion, List<String> libsToUse, Map<String, String> converterMap) throws Exception {
        ShellClassLoader scriptClassLoader = scriptClassLoader(hadoopVersion, hbaseVersion);
        ScriptEngine scriptEngine = getScriptEngine(scriptClassLoader);
        ResultConverter resultConverter = (ResultConverter)scriptClassLoader.loadClass(ResultConverter.class.getName()).newInstance();
        resultConverter.setConverterFactory(converterFactory);

        Bindings bindings = createBindings();
        Object scriptResult = evaluateScript(script, scriptEngine, scriptClassLoader, bindings);
        return resultConverter.convertResults(
                scriptResult,
                bindings,
                converterMap);
    }

    protected Object evaluateScript(String script, ScriptEngine scriptEngine, ShellClassLoader scriptClassLoader, Bindings bindings) throws Exception {
        Collection<String> imports = importsFinder.findMissingImports(script, scriptClassLoader);
        script = "import " + StringUtils.join(imports, "; import ") + ";" + script;
        return scriptEngine.eval(script, bindings);
    }

    public ScriptEngine getScriptEngine(ShellClassLoader scriptClassLoader) throws MalformedURLException {
        ScriptEngineManager engineManager = new ScriptEngineManager(scriptClassLoader);
        return engineManager.getEngineByName("groovy");
    }

    public ShellClassLoader scriptClassLoader(String hadoopVersion, String hbaseVersion) throws MalformedURLException {
        return new ShellClassLoader(hadoopVersion, hbaseVersion);
    }

    public Bindings createBindings() {
        Bindings bindings = new SimpleBindings();
        bindings.put("quorum", env.getProperty(Configuration.QUORUM_URL));
        bindings.put("table", env.getProperty(Configuration.DEFAULT_TABLE));
        bindings.put("tablePool", tablePool);
        return bindings;
    }

}
