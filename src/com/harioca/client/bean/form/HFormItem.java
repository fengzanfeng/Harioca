package com.harioca.client.bean.form;

public class HFormItem {

    private String formItemType;
    private Integer top;
    private Integer left;
    private Integer width;
    private Integer height;

    public HFormItem() {}

    public String getFormItemType() {
        return formItemType;
    }

    public void setFormItemType(String formItemType) {
        this.formItemType = formItemType;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
