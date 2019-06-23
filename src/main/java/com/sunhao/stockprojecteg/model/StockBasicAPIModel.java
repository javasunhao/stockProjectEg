package com.sunhao.stockprojecteg.model;

public class StockBasicAPIModel {
    private String requestId;
    private int code;
    private String msg;
    private StockBasicDataModel data;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public StockBasicDataModel getData() {
        return data;
    }

    public void setData(StockBasicDataModel data) {
        this.data = data;
    }
}
