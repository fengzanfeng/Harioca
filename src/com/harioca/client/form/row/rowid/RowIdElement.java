package com.harioca.client.form.row.rowid;

import com.harioca.client.smartgwt.FormItemFactory;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;

public class RowIdElement extends DynamicForm {

    private final String rowId;
    private final String elementId;

    public RowIdElement(String rowId) {
        this.rowId = rowId;
        elementId = FormItemFactory.getItemId(rowId);

        setItems(createFormItemFromScratch());

        setID(elementId);
        setWrapItemTitles(false);
        setCanSelectText(true);

        setMinColWidth(rowId.length() * 5 + 24);
    }

    private FormItem createFormItemFromScratch() {
//        String itemType = FormItemFactory.guessElement(cKeyValue);
        final FormItem item = FormItemFactory.create("TextItem");
        item.setValue(rowId);
        item.setTitle("<b>RowId</b>");
        item.setName(elementId);

        item.setWidth("100%");
        setTitleWidth(40);

        return item;
    }

}
