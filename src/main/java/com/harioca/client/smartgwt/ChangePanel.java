package com.harioca.client.smartgwt;

import com.smartgwt.client.types.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class ChangePanel extends VLayout {

    public ChangePanel() {
        super();

        setLeft(1070);

        setTop(40);

        setHeight(680);
        setWidth(180);

        setBorder("1px solid #bfdfcc");

        setLayoutMargin(10);
        setMembersMargin(10);

//        final FamilyHeader viewHeader = new FamilyHeader("View");
//        viewHeader.setBackgroundColor("eef6f2");
//        viewHeader.setWidth(170);
//        addMember(viewHeader);

        final ImgButton textItemButton = new ImgButton();
        textItemButton.setWidth(150);
        textItemButton.setHeight(34);
        textItemButton.setShowRollOver(false);
        textItemButton.setSrc("icons/TextItem.png");
        textItemButton.setActionType(SelectionType.RADIO);
        textItemButton.setRadioGroup("elementType");
        addMember(textItemButton);

        final ImgButton textAreaItemButton = new ImgButton();
        textAreaItemButton.setWidth(150);
        textAreaItemButton.setHeight(112);
        textAreaItemButton.setShowRollOver(false);
        textAreaItemButton.setSrc("icons/TextAreaItem.png");
        textAreaItemButton.setActionType(SelectionType.RADIO);
        textAreaItemButton.setRadioGroup("elementType");
        addMember(textAreaItemButton);

        final ImgButton checkboxItemButton = new ImgButton();
        checkboxItemButton.setWidth(150);
        checkboxItemButton.setHeight(32);
        checkboxItemButton.setShowRollOver(false);
        checkboxItemButton.setSrc("icons/CheckboxItem.png");
        checkboxItemButton.setActionType(SelectionType.RADIO);
        checkboxItemButton.setRadioGroup("elementType");
        addMember(checkboxItemButton);

        final ImgButton dateTimeItemButton = new ImgButton();
        dateTimeItemButton.setWidth(150);
        dateTimeItemButton.setHeight(34);
        dateTimeItemButton.setShowRollOver(false);
        dateTimeItemButton.setSrc("icons/DateTimeItem.png");
        dateTimeItemButton.setActionType(SelectionType.RADIO);
        dateTimeItemButton.setRadioGroup("elementType");
        addMember(dateTimeItemButton);

        final HLayout splitButtonsPanel = new HLayout(7);
        splitButtonsPanel.setWidth(150);
        splitButtonsPanel.setHeight(24);

        final Button splitConversationButton = new Button("Split");
        splitConversationButton.setBorder("1px solid #bfdfcc");
        splitConversationButton.setWidth(71);
        splitConversationButton.setHeight(24);
        splitButtonsPanel.addMember(splitConversationButton);

        final Button mergeConversationButton = new Button("Merge");
        mergeConversationButton.setBorder("1px solid #bfdfcc");
        mergeConversationButton.setWidth(71);
        mergeConversationButton.setHeight(24);
        splitButtonsPanel.addMember(mergeConversationButton);

        addMember(splitButtonsPanel);

//        final FamilyHeader conversionHeader = new FamilyHeader("Conversion");
//        conversionHeader.setBackgroundColor("eef6f2");
//        conversionHeader.setWidth(170);
//        addMember(conversionHeader);

        final SelectItem selectConversation = new SelectItem();
        selectConversation.setWidth(150);
        selectConversation.setHeight(250);
        selectConversation.setMultipleAppearance(MultipleAppearance.GRID);
        selectConversation.setMultiple(true);
        selectConversation.setShowTitle(false);
        selectConversation.setValueMap(
                "<i>Bytes.toString()</i>",
                "<i>Bytes.toBoolean()</i>",
                "<i>Bytes.toLong()</i>",
                "<i>Bytes.toDouble()</i>",
                "<i>Bytes.toInt()</i>",
                "<i>Bytes.toFloat()</i>",
                "<i>Bytes.toShort()</i>",
                "<i>Bytes.toStringBinary()</i>");

        final DynamicForm form = new DynamicForm();
        form.setFields(selectConversation);
        addMember(form);

        final HLayout conversationControlPanel = new HLayout(7);
        conversationControlPanel.setWidth(150);
        conversationControlPanel.setHeight(32);

        final Button findConversationButton = new Button("");
        findConversationButton.setIcon("icons/find.png");
        findConversationButton.setBorder("1px solid #bfdfcc");
        findConversationButton.setWidth(32);
        findConversationButton.setHeight(32);
        findConversationButton.setAlign(Alignment.RIGHT);
        conversationControlPanel.addMember(findConversationButton);

        final Button addConversationButton = new Button("");
        addConversationButton.setIcon("icons/add.png");
        addConversationButton.setBorder("1px solid #bfdfcc");
        addConversationButton.setWidth(32);
        addConversationButton.setHeight(32);
        addConversationButton.setAlign(Alignment.RIGHT);
        conversationControlPanel.addMember(addConversationButton);

        final Button editConversationButton = new Button("");
        editConversationButton.setIcon("icons/edit.png");
        editConversationButton.setBorder("1px solid #bfdfcc");
        editConversationButton.setWidth(32);
        editConversationButton.setHeight(32);
        editConversationButton.setAlign(Alignment.RIGHT);
        conversationControlPanel.addMember(editConversationButton);

        final Button removeConversationButton = new Button("");
        removeConversationButton.setIcon("icons/remove.png");
        removeConversationButton.setBorder("1px solid #bfdfcc");
        removeConversationButton.setWidth(32);
        removeConversationButton.setHeight(32);
        removeConversationButton.setAlign(Alignment.RIGHT);
        conversationControlPanel.addMember(removeConversationButton);

        addMember(conversationControlPanel);
    }
}

