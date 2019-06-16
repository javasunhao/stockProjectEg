package com.sunhao.stockprojecteg.model;

public class BaseStockData {
    //日期，开盘，收盘，涨跌，涨幅，最低，最高，成交量，成交额，换手率
    private String data;
    private String openPrice;
    private String closePrice;
    private String risePrice;
    private String amplitude;//涨幅
    private String highPrice;
    private String lowPrice;
    private String volume;//成交量
    private String turnover;//成交额
    private String handTurnoverRate; //换手率
    private String code;
    private String country;
    private String codeName;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getRisePrice() {
        return risePrice;
    }

    public void setRisePrice(String risePrice) {
        this.risePrice = risePrice;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getHandTurnoverRate() {
        return handTurnoverRate;
    }

    public void setHandTurnoverRate(String handTurnoverRate) {
        this.handTurnoverRate = handTurnoverRate;
    }
}
