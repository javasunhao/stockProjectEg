package com.sunhao.stockprojecteg.model;

import java.util.List;

public class StockBasicDataModel {
    private List<String> fields;
    private List<List<String>> items;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<List<String>> getItems() {
        return items;
    }

    public void setItems(List<List<String>> items) {
        this.items = items;
    }
}
