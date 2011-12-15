package com.harioca.client.form.row.family;

import com.harioca.client.bean.hbase.row.HFamily;
import com.harioca.client.bean.hbase.row.HKeyValue;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.widgets.layout.VLayout;

public class FamilyLayoutFirstLoad extends VLayout {

    private final String familyId;

    private final FamilyHeader header;

    public FamilyLayoutFirstLoad(HFamily hFamily) {
        this(hFamily.getFamilyId());

        int maxValueLength = getMaxValueLength(hFamily);
        for (HKeyValue hKeyValue : hFamily.getHKeyValues()) {
            addMember(new KeyValueElement(hKeyValue, maxValueLength));
        }
    }

    public FamilyLayoutFirstLoad(String familyId) {
        setHPolicy(LayoutPolicy.NONE);

        this.familyId = familyId;
        setDefaultLayoutAlign(Alignment.RIGHT);
        setMembersMargin(2);
        setLayoutLeftMargin(3);
        setLayoutRightMargin(3);

        header = new FamilyHeader(familyId);
        addMember(header);
    }

    private int getMaxValueLength(HFamily hFamily) {
        int maxValueLength = 0;
        for (HKeyValue hKeyValue : hFamily.getHKeyValues()) {
            if (maxValueLength < hKeyValue.getValue().length()) {
                maxValueLength = hKeyValue.getValue().length();
            }
        }
        return maxValueLength;
    }

    public String getFamilyId() {
        return familyId;
    }

    public FamilyHeader getHeader() {
        return header;
    }
}
