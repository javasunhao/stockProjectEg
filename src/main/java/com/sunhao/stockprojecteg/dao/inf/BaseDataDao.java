package com.sunhao.stockprojecteg.dao.inf;

import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.model.StockBaseInfo;

import java.util.List;

public interface BaseDataDao {
    List<BaseStockData> getData();

    void saveDateByNet(List<BaseStockData> stockDataList);

    void saveBaseData(List<StockBaseInfo> stockBaseInfoList);
}
