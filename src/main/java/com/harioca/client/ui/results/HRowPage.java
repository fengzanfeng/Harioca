package com.harioca.client.ui.results;

import com.harioca.client.ui.torefactor.HariocaEntryPoint;
import com.harioca.client.bean.hbase.HItemDefinition;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.*;

public class HRowPage extends HLayout {

    private final Layout side = new Layout();
    private final VLayout rowLayout = new VLayout();

    private HItem rowIdItem = null;
    private final Map<String, HFamilyPanel> families = new HashMap<String, HFamilyPanel>();
    private final Map<String, HItem> items = new HashMap<String, HItem>();

    public HRowPage() {
        setMembersMargin(20);
        side.setWidth("6%");
        side.setBackgroundColor("#eee"); // todo to css
        rowLayout.setHPolicy(LayoutPolicy.NONE);
        rowLayout.setVPolicy(LayoutPolicy.NONE);
        rowLayout.setLayoutTopMargin(20);
        rowLayout.setMembersMargin(10);

        addMember(side);
        addMember(rowLayout);

        setWidth(HariocaEntryPoint.WIDTH_100);
        setHeight(500);
        setBackgroundColor("#ffffff");
    }

    public void addRowIdItem(String rowIdType) {
        rowIdItem = HRowBuilder.getRowIdItem(rowIdType);
        rowLayout.addMember(rowIdItem);
    }

    public void addHFamilyPanel(String familyId) {
        final HFamilyPanel hFamilyPanel = HRowBuilder.getHFamilyPanel(familyId);
        families.put(familyId, hFamilyPanel);
        rowLayout.addMember(hFamilyPanel);
    }

    public void addHKeyValue(String familyId, HItemDefinition itemDefinition) {
        final HItem hItem = HRowBuilder.getKeyValueItem(itemDefinition.getKey(), itemDefinition.getItemType());
        items.put(itemDefinition.getKey(), hItem);
        families.get(familyId).addHItem(hItem);
    }

    public void setFamilies(Collection<String> familiesToShow) {
        for (String familyId : familiesToShow) {
            if (families.containsKey(familyId)) {
                families.get(familyId).show(); // todo does it needed to check isVisible?
            } else {
                addHFamilyPanel(familyId);
            }
        }
        Set<String> familiesToHide = new HashSet<String>(families.keySet());
        familiesToHide.removeAll(familiesToShow);
        for (String familyToHide : familiesToHide) {
            families.get(familyToHide).hide();
        }
    }

    public void setItems(Map<String, Map<String, String>> itemsToShow) {
        Set<String> itemsToHide = new HashSet<String>(items.keySet());
        int maxLength;
        for (String familyId : itemsToShow.keySet()) {
            maxLength = 0;
            for (String itemToShow : itemsToShow.get(familyId).keySet()) {
                if (items.containsKey(itemToShow)) {
                    items.get(itemToShow).show();
                } else {
                    addHKeyValue(familyId, HRowBuilder.getDefaultItemDefinition(itemToShow));
                }
                setHItemValue(itemToShow, itemsToShow.get(familyId).get(itemToShow));
                if (maxLength < itemsToShow.get(familyId).get(itemToShow).length()) {
                    maxLength = itemsToShow.get(familyId).get(itemToShow).length();
                }
            }
            families.get(familyId).updateItemsWidth(maxLength);
            itemsToHide.removeAll(itemsToShow.get(familyId).keySet());
        }
        for (String itemToHide : itemsToHide) {
            items.get(itemToHide).hide();
        }
    }

    public void setHRowItemValue(String value) {
        rowIdItem.setValue(value);
        rowIdItem.setCommonWidth(value.length());
    }

    public void setHItemValue(String key, String value) {
        items.get(key).setValue(value);
        items.get(key).setCommonWidth(value.length());
    }
}
