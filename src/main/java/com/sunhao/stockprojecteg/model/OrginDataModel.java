package com.sunhao.stockprojecteg.model;

public class OrginDataModel {
    //[{"status":0,"hq":[["2019-05-28","27.00","27.62","0.62","2.30%","26.84","27.62","409946","111749.39","0.42%"]],"code":"cn_000002","stat":["累计:","2019-05-28至2019-05-28","0.62","2.30%",26.84,27.62,409946,111749.39,"0.42%"]}]
    String status;
    String hq;
    String code;
    String stat;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
