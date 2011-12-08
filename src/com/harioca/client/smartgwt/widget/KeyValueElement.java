package com.harioca.client.smartgwt.widget;

import com.harioca.client.bean.hbase.row.HKeyValue;
import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class KeyValueElement extends DynamicForm {

    private final HKeyValue hKeyValue;
    private final String elementId;

    private final FormItem item;

    public KeyValueElement(HKeyValue hKeyValue) {
        this.hKeyValue = hKeyValue;
        elementId = FormItemFactory.getItemId(hKeyValue.getKey());

        item = createFormItemFromScratch();
        setItems(item);

        setID(elementId);
        setWrapItemTitles(false);
        setCanSelectText(true);

        setColWidths(0, 300);

//        setBorder("1px solid #ff4040");
    }

    private FormItem createFormItemFromScratch() {
        String itemType = FormItemFactory.guessElement(hKeyValue);
        final FormItem item = FormItemFactory.create(itemType);
        item.setValue(hKeyValue.getValue());
        item.setTitle(hKeyValue.getKey());
        item.setName(elementId);
        item.setWidth("100%");
//        formItem.setHeight("100%");

        return item;
    }

}
