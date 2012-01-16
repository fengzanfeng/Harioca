package com.harioca.shell;


import com.harioca.shell.converter.ResultConverter;
import com.harioca.shell.converter.ValueConverterFactory;
import com.harioca.shell.spring.Configuration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.script.SimpleBindings;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class, loader = AnnotationConfigContextLoader.class)
public class ResultConverterTest {


    private ResultConverter resultConverter;

    @Autowired
    ValueConverterFactory converterFactory;

    @Before
    public void setUp() throws Exception {
        resultConverter = new ResultConverter();
        resultConverter.setConverterFactory(converterFactory);
    }

    @Test
    public void testConvertNull() throws Exception {
        Assert.assertEquals(ResultConverter.EMPTY_JSON_OBJECT, resultConverter.convertResults(null, new SimpleBindings(), Collections.<String, String>emptyMap()));
    }

    @Test
    public void testConvertEmptyResult() throws Exception {
        Assert.assertEquals(ResultConverter.EMPTY_JSON_OBJECT, resultConverter.convertResults(new Result(), new SimpleBindings(), Collections.<String, String>emptyMap()));
    }


    @Test
    public void testConvertSampleResult() throws Exception {
        String row = "row";
        String family = "family";
        String qualifier = "qualifier";
        String value = "qualifier-value";
        Result result = new Result(new KeyValue[]{keyValue(row, family, qualifier, Bytes.toBytes(value))});
        JSONObject jsonObject = resultConverter.convertResults(result, new SimpleBindings(), Collections.<String, String>emptyMap());

        Assert.assertEquals(row, jsonObject.get(ResultConverter.ROW_KEY));
        Assert.assertNotNull(jsonObject.get(family));
        Assert.assertEquals(value, (((JSONObject) jsonObject.get(family))).get(qualifier));
    }

    @Test
    public void testConvertSampleResultWithConverterMap() throws Exception {
        String row = "row";
        String family = "family";
        String genericQualifier = "qualifier";
        Map<String, String> converterMap = new HashMap<>();
        List<KeyValue> keyValues = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            String qualifier = genericQualifier + i;
            converterMap.put(family + "." + qualifier, String.valueOf(i));
            keyValues.add(keyValue(row, family, qualifier, Bytes.toBytes(i)));
        }
        Result result = new Result(keyValues);
        JSONObject jsonObject = resultConverter.convertResults(result, new SimpleBindings(), converterMap);

        Assert.assertEquals(row, jsonObject.get(ResultConverter.ROW_KEY));
        Assert.assertNotNull(jsonObject.get(family));
        for (int i = 1; i < 7; i++) {
            Assert.assertEquals(i, (((JSONObject) jsonObject.get(family))).get(genericQualifier + i));
        }
    }


    @Test
    public void testConvertSampleResultWithCustomConverter() throws Exception {
        String row = "row";
        String family = "family";
        String qualifier = "qualifier";
        Map<String, String> converterMap = new HashMap<>();
        String converter = "Bytes.toLong(value, 0, 8)";
        converterMap.put(family + "." + qualifier, converter);
        Object value = 8L;
        Result result = new Result(new KeyValue[]{keyValue(row, family, qualifier, Bytes.add(Bytes.toBytes((Long) value), Bytes.toBytes(10L)))});
        JSONObject jsonObject = resultConverter.convertResults(result, new SimpleBindings(), converterMap);

        Assert.assertNotNull(jsonObject.get(family));
        Assert.assertEquals(value, (((JSONObject) jsonObject.get(family))).get(qualifier));
    }

    private KeyValue keyValue(String row, String family, String qualifier, byte[] value) {
        return new KeyValue(Bytes.toBytes(row),
                Bytes.toBytes(family),
                Bytes.toBytes(qualifier),
                0L,
                value);
    }


}
