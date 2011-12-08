package com.harioca.client;

import com.harioca.client.bean.form.HForm;
import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HKeyValue;
import com.harioca.client.bean.hbase.row.HRow;

import java.util.ArrayList;
import java.util.List;

public class TestData___DeleteMe {

    public static HForm getTestForm() {
        return new HForm();
    }

    public static HRow getTestData() {
        HRow hRow = new HRow();
        hRow.setRowId("test_test_test_1");

        List<HFamily> hFamilyList = new ArrayList<HFamily>();

        // family 1
        HFamily hFamily1 = new HFamily();
        hFamily1.setFamilyId("<b>first family</b>");

        List<HKeyValue> hKeyValueList1 = new ArrayList<HKeyValue>();

        HKeyValue hKeyValue1 = new HKeyValue();
        hKeyValue1.setKey("shor t");
        hKeyValue1.setValue("biiiig bigggg vaaaaaluuuuuueeee");
        hKeyValueList1.add(hKeyValue1);

        hKeyValue1 = new HKeyValue();
        hKeyValue1.setKey("Long long key naaaaaaaam e");
        hKeyValue1.setValue("short");
        hKeyValueList1.add(hKeyValue1);

        hKeyValue1 = new HKeyValue();
        hKeyValue1.setKey("shor t 43534 4");
        hKeyValue1.setValue("sdwsgsgrthgr rt gdrtg hrdth rd");
        hKeyValueList1.add(hKeyValue1);

        hKeyValue1 = new HKeyValue();
        hKeyValue1.setKey("fgfgh sdsss");
        hKeyValue1.setValue("sssddfg rhrhrg 433t45");
        hKeyValueList1.add(hKeyValue1);

        hFamily1.setHKeyValues(hKeyValueList1);

        hFamilyList.add(hFamily1);

        // family 2
        HFamily hFamily2 = new HFamily();
        hFamily2.setFamilyId("<b>second family</b>");

        List<HKeyValue> hKeyValueList2 = new ArrayList<HKeyValue>();

        HKeyValue hKeyValue2 = new HKeyValue();
        hKeyValue2.setKey("Qualifier");
        hKeyValue2.setValue("Value");
        hKeyValueList2.add(hKeyValue2);

        hKeyValue2 = new HKeyValue();
        hKeyValue2.setKey("z z x x c c ");
        hKeyValue2.setValue("222214352346");
        hKeyValueList2.add(hKeyValue2);

        hKeyValue2 = new HKeyValue();
        hKeyValue2.setKey("a ffffffffffffffffff a");
        hKeyValue2.setValue("true");
        hKeyValueList2.add(hKeyValue2);

        hFamily2.setHKeyValues(hKeyValueList2);

        hFamilyList.add(hFamily2);

        hRow.setHFamilies(hFamilyList);

        return hRow;
    }
}
