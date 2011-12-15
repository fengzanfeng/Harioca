package com.harioca.client;

import com.harioca.client.bean.form.HForm;
import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HKeyValue;
import com.harioca.client.bean.hbase.row.HRow;

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

        List<HFamily> hFamilyList = new ArrayList<HFamily>();

        // family 1
        HFamily hFamily1 = new HFamily();
        hFamily1.setFamilyId("<b>first family</b>");
        hFamilyList.add(hFamily1);
        List<HKeyValue> hKeyValueList1 = new ArrayList<HKeyValue>();
        for (String columnName : columnsFamily1.keySet()) {
            if (new Random().nextBoolean()) {
                HKeyValue hKeyValue1 = new HKeyValue();
                hKeyValue1.setKey(columnName);
                hKeyValue1.setValue(columnsFamily1.get(columnName) + number);
                hKeyValueList1.add(hKeyValue1);
            }
        }
        hFamily1.setHKeyValues(hKeyValueList1);

        // family 2
        HFamily hFamily2 = new HFamily();
        hFamily2.setFamilyId("<b>second family</b>");
        hFamilyList.add(hFamily2);
        List<HKeyValue> hKeyValueList2 = new ArrayList<HKeyValue>();
        for (String columnName : columnsFamily2.keySet()) {
            if (new Random().nextBoolean()) {
                HKeyValue hKeyValue2 = new HKeyValue();
                hKeyValue2.setKey(columnName);
                hKeyValue2.setValue(columnsFamily2.get(columnName) + number);
                hKeyValueList2.add(hKeyValue2);
            }
        }
        hFamily2.setHKeyValues(hKeyValueList2);

        hRow.setHFamilies(hFamilyList);

        return hRow;
    }

//    public static HRow getTestData() {
//        HRow hRow = new HRow();
//        hRow.setRowId("test_test_test_1");
//
//        List<HFamily> hFamilyList = new ArrayList<HFamily>();
//
//        // family 1
//        HFamily hFamily1 = new HFamily();
//        hFamily1.setFamilyId("<b>first family</b>");
//
//        List<HKeyValue> hKeyValueList1 = new ArrayList<HKeyValue>();
//
//        HKeyValue hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("shor t");
//        hKeyValue1.setValue("biiiig bigggg vaaaaaluuuuuueeee");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("Long long key naaaaaaaam e");
//        hKeyValue1.setValue("short");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("shor t 43534 4");
//        hKeyValue1.setValue("sdwsgsgrthgr rt gdrtg hrdth rd");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("fgfgh sdsss");
//        hKeyValue1.setValue("sssddfg rhrhrg 433t45");
//        hKeyValueList1.add(hKeyValue1);
//
//        hFamily1.setHKeyValues(hKeyValueList1);
//
//        hFamilyList.add(hFamily1);
//
//        // family 2
//        HFamily hFamily2 = new HFamily();
//        hFamily2.setFamilyId("<b>second family</b>");
//
//        List<HKeyValue> hKeyValueList2 = new ArrayList<HKeyValue>();
//
//        HKeyValue hKeyValue2 = new HKeyValue();
//        hKeyValue2.setKey("Qualifier");
//        hKeyValue2.setValue("Value");
//        hKeyValueList2.add(hKeyValue2);
//
//        hKeyValue2 = new HKeyValue();
//        hKeyValue2.setKey("z z x x c c ");
//        hKeyValue2.setValue("222214352346");
//        hKeyValueList2.add(hKeyValue2);
//
//        hKeyValue2 = new HKeyValue();
//        hKeyValue2.setKey("a ffffffffffffffffff a");
//        hKeyValue2.setValue("true");
//        hKeyValueList2.add(hKeyValue2);
//
//        hFamily2.setHKeyValues(hKeyValueList2);
//
//        hFamilyList.add(hFamily2);
//
//        hRow.setHFamilies(hFamilyList);
//
//        return hRow;
//    }
//
//    public static HRow getTestData2() {
//        HRow hRow = new HRow();
//        hRow.setRowId("2+--=test_test_test_2");
//
//        List<HFamily> hFamilyList = new ArrayList<HFamily>();
//
//        // family 1
//        HFamily hFamily1 = new HFamily();
//        hFamily1.setFamilyId("<b>first family 222</b>");
//
//        List<HKeyValue> hKeyValueList1 = new ArrayList<HKeyValue>();
//
//        HKeyValue hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("22 shor t");
//        hKeyValue1.setValue("22 biiiig bigggg vaaaaaluuuuuueeee");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("222 Long long key naaaaaaaam e");
//        hKeyValue1.setValue("22 short");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("22 shor t 43534 4");
//        hKeyValue1.setValue("222 2 sdwsgsgrthgr rt gdrtg hrdth rd");
//        hKeyValueList1.add(hKeyValue1);
//
//        hKeyValue1 = new HKeyValue();
//        hKeyValue1.setKey("22 2fgfgh sdsss");
//        hKeyValue1.setValue("22 2 sssddfg rhrhrg 433t45");
//        hKeyValueList1.add(hKeyValue1);
//
//        hFamily1.setHKeyValues(hKeyValueList1);
//
//        hFamilyList.add(hFamily1);
//
//        hRow.setHFamilies(hFamilyList);
//
//        return hRow;
//    }
}
