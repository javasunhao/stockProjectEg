package com.sunhao.stockprojecteg.bussiess.impl;

import com.sunhao.stockprojecteg.dao.inf.BaseDateDao;
import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.bussiess.inf.BaseDataBussiess;
import com.sunhao.stockprojecteg.util.DataFromNetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseDataBussiessImpl implements BaseDataBussiess {
    @Autowired
    private BaseDateDao baseDateDao;

    @Override
    public List<BaseStockData> getData() {
        return baseDateDao.getData();
    }

    @Override
    public void saveDateByNet(List<String> stockCodeList, String startTime, String codeName) {
        List<BaseStockData> baseStockDataList = DataFromNetUtils.getDataToNowData(stockCodeList, startTime, codeName);
        baseDateDao.saveDateByNet(baseStockDataList);
    }

    /**
     * 通过爬虫获取数据
     *
     * @param stockCode
     * @return
     */
    private List<BaseStockData> getJsonpData(String stockCode) {
        return new ArrayList<>();
    }

    private List<BaseStockData> getTestData(String stockCode) {
        List<BaseStockData> stockDataList = new ArrayList<>();
        BaseStockData stockData = new BaseStockData();
        //{"amplitude":"1","closePrice":"1.0","data":"1","highPrice":"1.0","lowPrice":"1.0","openPrice":"1.0",
        // "risePrice":"1.0","uuid":"1","volume":"1"},
        stockData.setAmplitude("3");
        stockData.setClosePrice("3");
        stockData.setData("3");
        stockData.setHighPrice("3");
        stockData.setLowPrice("3");
        stockData.setOpenPrice("3");
        stockData.setRisePrice("3");
        stockData.setVolume("3");
        stockDataList.add(stockData);
        return stockDataList;
    }
}
