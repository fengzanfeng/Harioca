package com.harioca.client.ui.form;


import com.harioca.client.bean.hbase.*;

import java.util.HashMap;
import java.util.Map;

public class HRowBuilder {

    private static final HRowPage[] PAGES = new HRowPage[]{new HRowPage(), new HRowPage(), new HRowPage()};

    public static HRowPage getHRowPage(int pageNum) {
        return PAGES[pageNum];
    }

    public static void shiftPages(boolean forward) {
        HRowPage tmp = PAGES[2];
        if (forward) {
            PAGES[2] = PAGES[0];
            PAGES[0] = PAGES[1];
            PAGES[1] = tmp;
        } else {
            PAGES[2] = PAGES[1];
            PAGES[1] = PAGES[0];
            PAGES[0] = tmp;
        }
    }

    public static void init(HPageDefinition hPageDefinition) {
        for (int i = 0; i < 3; i++) {
            PAGES[i].addRowIdItem(hPageDefinition.getRowIdType().getItemType());
            for (String familyId : hPageDefinition.getFamilies().keySet()) {
                PAGES[i].addHFamilyPanel(familyId);
                for (HItemDefinition itemDefinition : hPageDefinition.getFamilies().get(familyId)) {
                    PAGES[i].addHKeyValue(familyId, itemDefinition);
                }
            }
        }
    }

    public static void updateHRowPage(int hRowPageN, HRow hRow) {
        PAGES[hRowPageN].setHRowItemValue(hRow.getRowId());
        PAGES[hRowPageN].setFamilies(hRow.getData().keySet());
        PAGES[hRowPageN].setItems(hRow.getData());
    }

    public static HItem getRowIdItem(String rowIdType) {
        HItem rowIdItem = new HItem(rowIdType);
        return rowIdItem;
    }

    public static HFamilyPanel getHFamilyPanel(String familyId) {
        HFamilyPanel hFamilyPanel = new HFamilyPanel(familyId);
        return hFamilyPanel;
    }

    public static HItem getKeyValueItem(String key, String rowIdType) {
        HItem keyValueItem = new HItem(key, rowIdType);
        return keyValueItem;
    }

    public static HItemDefinition getDefaultItemDefinition(String key) {
        HItemDefinition hItemDefinition = new HItemDefinition();
        hItemDefinition.setKey(key);
        return hItemDefinition;
    }
}
