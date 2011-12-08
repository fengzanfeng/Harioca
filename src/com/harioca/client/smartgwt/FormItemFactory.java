package com.harioca.client.smartgwt;

import com.harioca.client.ViewBuildingException;
import com.harioca.client.bean.hbase.row.HKeyValue;
import com.smartgwt.client.widgets.form.fields.*;

import java.util.Random;

public class FormItemFactory {

    public static FormItem create(String formItemType) {
        FormItem formItem;
        if ("TextItem".equals(formItemType)) {
            formItem = new TextItem();
        } else if ("TextAreaItem".equals(formItemType)) {
            formItem = new TextAreaItem();
        } else if ("CheckboxItem".equals(formItemType)) {
            formItem = new CheckboxItem();
        } else if ("DateTimeItem".equals(formItemType)) {
            formItem = new DateTimeItem();
            // todo add file image support
        } else {
            throw new ViewBuildingException("Unknown component class " + formItemType);
        }

        return formItem;
    }

    // todo try to find out item type
    public static String guessElement(HKeyValue hKeyValue) {
        if (new Random().nextBoolean()) {
            return "DateTimeItem";
        } else {
            if (new Random().nextBoolean()) {
                return "TextAreaItem";
            } else {
                if (new Random().nextBoolean()) {
                    return "CheckboxItem";
                } else {
                    return "TextItem";
                }
            }
        }
    }

    public static String getItemId(Object key) {
        return "kv" + Math.abs(key != null ? key.hashCode() : 0);   // todo better algorithm?
    }

}
