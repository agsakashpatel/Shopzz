package com.app.shopzz.models;

public class CategoriesModel {

    private String string;
    private boolean isSelected;

    public CategoriesModel(String string, boolean isSelected) {
        this.string = string;
        this.isSelected = isSelected;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
