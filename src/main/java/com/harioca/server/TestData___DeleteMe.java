package com.harioca.server;

import com.harioca.client.bean.hbase.*;

import java.util.*;

public class TestData___DeleteMe {

    public static Map<String, String> columnsFamily1 = new HashMap<String, String>() {{
            put("aaa", "aaaaaaaaaaaaaaaaa");
            put("bbb", "bbbbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbbbbbb bbbbb");
            put("ccccc cc", "true");
            put("d dddddddd, dd", "dddd d ddd\n dddd d dddd dd ddd\n d dddddddd\n dd dddd");
            put("eeeeeeeeeeeeeeeeeeeeee", "eeeee eee eeeeeeee ee");
            put("f", "1234124241243");
    }};

    public static Map<String, String> columnsFamily2 = new HashMap<String, String>() {{
            put("zzz zzz zzz zzz", "1");
            put("y y y y", "yes");
            put("xxxxxx xxxx", "true");
            put("d dddddddd, dd", "111\n 222\n 333\n 44");
            put("eeeee eee", "12.31.2011 7:22:41.00");
            put("www w ww", "html://www.google.com");
    }};

    public static List<HRow> getTestDataList() {
        List<HRow> results = new ArrayList<HRow>();
        for (int i = 0; i < 100; i++) {
            HRow result = getTestHRow(i);
            results.add(result);
        }

        return results;
    }

    public static HRow getTestHRow(int number) {
        HRow hRow = new HRow();
        hRow.setRowId("this is rowId #" + number);

        Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();

        // family 1
        Map<String, String> hKeyValueMap1 = new HashMap<String, String>();
        for (String columnName : columnsFamily1.keySet()) {
            if (new Random().nextBoolean()) {
                hKeyValueMap1.put(columnName, columnsFamily1.get(columnName) + number);
            }
        }
        data.put("<b>first family</b>", hKeyValueMap1);

        // family 2
        Map<String, String> hKeyValueMap2 = new HashMap<String, String>();
        for (String columnName : columnsFamily2.keySet()) {
            if (new Random().nextBoolean()) {
                hKeyValueMap2.put(columnName, columnsFamily2.get(columnName) + number);
            }
        }
        data.put("<b>second family</b>", hKeyValueMap2);

        hRow.setData(data);

        return hRow;
    }

    public static HPageDefinition getHPageDefinition() {
        HPageDefinition hPageDefinition = new HPageDefinition();
        hPageDefinition.setRowIdType(new HItemDefinition());
        Map<String, List<HItemDefinition>> families = new HashMap<String, List<HItemDefinition>>();
        hPageDefinition.setFamilies(families);
        return hPageDefinition;
    }

    public static String getLog() {
        return  " test log";
    }
}
