package com.harioca.client.form.row.family;

import com.harioca.client.bean.hbase.row.HKeyValue;
import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class KeyValueElement extends DynamicForm {

    private final HKeyValue hKeyValue;
    private final String elementId;

    public KeyValueElement(HKeyValue hKeyValue, int maxValueLength) {
        this.hKeyValue = hKeyValue;
        elementId = FormItemFactory.getItemId(hKeyValue.getKey());

        setItems(createFormItemFromScratch());

        setID(elementId);
        setWrapItemTitles(false);
        setCanSelectText(true);

        setMinColWidth(maxValueLength * 5 + 24);
    }

    private FormItem createFormItemFromScratch() {
        String itemType = FormItemFactory.guessElement(hKeyValue);
        final FormItem item = FormItemFactory.create(itemType);
        item.setValue(hKeyValue.getValue());
        item.setTitle(hKeyValue.getKey());
        item.setName(elementId);

        item.setWidth("100%");
        setTitleWidth(hKeyValue.getKey().length() * 5 + 12);

        return item;
    }

}
