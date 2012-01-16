package com.harioca.shell.converter;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.commons.collections.Transformer;
import org.apache.hadoop.hbase.util.Bytes;
//import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.Map;

public class ValueConverterFactory {
    public static final String DEFAULT_IMPORTS = "import org.apache.hadoop.hbase.util.Bytes;";

    private final Map<Integer, Transformer> converters = new HashMap<>();

    public Object convertValue(byte[] value, String converterType) throws Exception {
        switch (converterType.hashCode()) {
            case 1:
                return Bytes.toString(value);
            case 2:
                return Bytes.toLong(value);
            case 3:
                return Bytes.toInt(value);
            case 4:
                return Bytes.toDouble(value);
            case 5:
                return Bytes.toFloat(value);
            case 6:
                return Bytes.toShort(value);
            default: {
                if (!converters.containsKey(converterType.hashCode())) {
                    registerConverter(converterType);
                }
                return converters.get(converterType.hashCode()).transform(value);
            }
        }
    }


    public void registerConverter(Integer converterId, Transformer transformer) {
        if (converters.containsKey(converterId)) {
            throw new IllegalArgumentException("Converter for id = " + converterId + "is already registered");
        }
        converters.put(converterId, transformer);
    }

    public void registerConverter(final String converterText) {
        this.registerConverter(converterText.hashCode(), new Transformer() {
            private String converter = converterText;

            @Override
            public Object transform(Object input) {
                //todo: use imports finder
                Binding binding = new Binding();
                binding.setVariable("value", input);
                GroovyShell groovyShell = new GroovyShell(binding);
                converter = DEFAULT_IMPORTS + converter;
                return groovyShell.evaluate(converter);
            }
        });
    }


}
