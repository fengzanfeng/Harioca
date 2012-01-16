package com.harioca.shell.converter;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.script.Bindings;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Converts {@link Scan}, {@link Get}, {@link Result}, Result[] to {@link org.codehaus.jettison.json.JSONObject}
 * In case of Scan and Get converts connectionpool is used to retrieve table
 */
public class ResultConverter {

    public static final int MAX_QUERIED_ROWS = 100000;
    public static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    public static final String ROW_KEY = "row";
    public static final JSONObject EMPTY_JSON_OBJECT = new JSONObject();

    private ValueConverterFactory converterFactory;

    public void setConverterFactory(ValueConverterFactory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public JSONObject convertResults(Object object, Bindings bindings, Map<String, String> converterMap) throws Exception {
        Result[] results = EMPTY_RESULT_ARRAY;
        if (object != null) {
            if (object instanceof Get) {
                results = new Result[]{resultsFromGet((Get) object, (HTablePool) bindings.get("tablePool"), (String) bindings.get("table"))};
            } else if (object instanceof Scan) {
                results = resultsFromScan((Scan) object, (HTablePool) bindings.get("tablePool"), (String) bindings.get("table"));
            } else if (object instanceof Result) {
                results = new Result[]{(Result) object};
            }
        }
        return convertResults(results, converterMap);
    }

    private JSONObject convertResults(Result[] results, Map<String, String> converterMap) throws Exception {
        JSONObject converted = EMPTY_JSON_OBJECT;
        for (Object object : results) {
            Result result = (Result) object;
            converted.put(ROW_KEY, Bytes.toString(result.getRow()));
            for (Map.Entry<byte[], NavigableMap<byte[], byte[]>> entry : result.getNoVersionMap().entrySet()) {
                String family = Bytes.toString(entry.getKey());
                JSONObject familyData = new JSONObject();
                for (Map.Entry<byte[], byte[]> data : entry.getValue().entrySet()) {
                    String qualifier = Bytes.toString(data.getKey());
                    String convertKey = family + "." + qualifier;
                    Object value = data.getValue();
                    if (converterMap.containsKey(convertKey)) {
                        value = converterFactory.convertValue((byte[]) value, converterMap.get(convertKey));
                    } else {
                        value = Bytes.toString((byte[]) value);
                    }
                    familyData.put(qualifier, value);
                }
                converted.put(family, familyData);
            }
        }
        return converted;
    }

    private Result[] resultsFromScan(Scan scan, HTablePool connectionPool, String tableName) throws JSONException, IOException {
        HTableInterface table = null;
        try {
            table = connectionPool.getTable(tableName);
            ResultScanner scanner = table.getScanner(scan);
            //todo: do not use next(...) better convert every each result
            return scanner.next(MAX_QUERIED_ROWS);
        } finally {
            connectionPool.putTable(table);
        }
    }

    private Result resultsFromGet(Get get, HTablePool connectionPool, String tableName) throws JSONException, IOException {
        HTableInterface table = null;
        try {
            table = connectionPool.getTable(tableName);
            return table.get(get);
        } finally {
            connectionPool.putTable(table);
        }
    }

}
