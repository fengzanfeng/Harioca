package com.harioca.client.ui.results;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HItem extends DynamicForm {

    public static final String ROW_ID_TITLE = "<b>RowId</b>";
    public static final int ROW_ID_TITLE_WIDTH = 70;

    protected FormItem formItem;

    public HItem(String rowIdType) {
        this(ROW_ID_TITLE, rowIdType);
        setMinColWidth(ROW_ID_TITLE_WIDTH);
    }

    public HItem(String title, String itemType) {
        setWrapItemTitles(false);
        setCanSelectText(true);

        setItems(createFormItem(title, itemType));

        setTitleWidth(title.length() * 5 + 12);
    }

    public void setCommonWidth(int commonWidth) {
        setMinColWidth(commonWidth * 5 + 24);         // todo no hardcoded constatnts
        markForRedraw(); //todo try do not redraw it, do not redraw when item is shorter then def value
    }

    private FormItem createFormItem(String title, String itemType) {
        if ("TextAreaItem".equals(itemType)) {
            formItem = new TextAreaItem();
        } else if ("CheckboxItem".equals(itemType)) {
            CheckboxItem checkboxItem = new CheckboxItem();
            checkboxItem.setLabelAsTitle(true);
            formItem = checkboxItem;
            // todo support timestamp
        } else {
            formItem = new TextItem();
        }
        formItem.setTitle(title);
        formItem.setWidth("100%");

        return formItem;
    }

    public void setValue(String value) {
        formItem.setValue(value);
    }
}
