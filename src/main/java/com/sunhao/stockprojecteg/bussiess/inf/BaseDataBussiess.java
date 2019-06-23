package com.sunhao.stockprojecteg.bussiess.inf;

import com.sunhao.stockprojecteg.model.BaseStockData;

import java.util.List;

public interface BaseDataBussiess {
    List<BaseStockData> getData();

    void saveDateByNet(List<String> stockCode, String startTime, String codeName);

    void saveBaseData();

    void saveIndexBasicData();
}
