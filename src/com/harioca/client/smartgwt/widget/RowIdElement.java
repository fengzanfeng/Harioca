package com.harioca.client.smartgwt.widget;

import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class RowIdElement extends DynamicForm {

    private final String rowId;
    private final String elementId;

    private final FormItem item;

    public RowIdElement(String rowId) {
        this.rowId = rowId;
        elementId = FormItemFactory.getItemId(rowId);
        setID(elementId);
        setWrapItemTitles(false);
        setCanSelectText(true);
        setNumCols(2);

        setColWidths(300, 0);

        item = createFormItemFromScratch();

        setItems(item);

//        setBorder("1px solid #ff4040");
    }

    private FormItem createFormItemFromScratch() {
//        String itemType = FormItemFactory.guessElement(cKeyValue);
        final FormItem item = FormItemFactory.create("TextItem");
        item.setValue(rowId);
        item.setShowTitle(false);
        item.setName(elementId);
        item.setWidth("100%");
//        formItem.setHeight("100%");

        return item;
    }

}
