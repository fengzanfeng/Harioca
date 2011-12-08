package com.harioca.client.smartgwt.widget;

import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HKeyValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.layout.VLayout;

public class FamilyLayoutFirstLoad extends VLayout {

    private final String familyId;

    private final FamilyHeader header;

    public FamilyLayoutFirstLoad(HFamily hFamily) {
        this(hFamily.getFamilyId());
        for (HKeyValue hKeyValue : hFamily.getHKeyValues()) {
            addMember(new KeyValueElement(hKeyValue));
        }
    }

    public FamilyLayoutFirstLoad(String familyId) {
        super();
        this.familyId = familyId;
        setDefaultLayoutAlign(Alignment.RIGHT);
        setExtraSpace(10);
        setMembersMargin(5);

//        setLayoutTopMargin(3);
        setLayoutLeftMargin(3);
        setLayoutRightMargin(3);

        header = new FamilyHeader(familyId);
        addMember(header);
    }

    public String getFamilyId() {
        return familyId;
    }

    public FamilyHeader getHeader() {
        return header;
    }
}
