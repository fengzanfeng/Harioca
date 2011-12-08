package com.harioca.client.bean.form;

import java.util.HashMap;

public class HForm {

    private HashMap<String, HFormItem> keyToFormItemMap = new HashMap<String, HFormItem>();

    public HForm() {}

    public HashMap<String, HFormItem> getKeyToFormItemMap() {
        return keyToFormItemMap;
    }

    public void setKeyToFormItemMap(HashMap<String, HFormItem> keyToFormItemMap) {
        this.keyToFormItemMap = keyToFormItemMap;
    }
}
