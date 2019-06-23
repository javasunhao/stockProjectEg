package com.sunhao.stockprojecteg.bussiess.impl;

import com.sunhao.stockprojecteg.bussiess.inf.BaseDataBussiess;
import com.sunhao.stockprojecteg.dao.inf.BaseDataDao;
import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.model.StockBaseInfo;
import com.sunhao.stockprojecteg.util.DataFromNetUtils;
import com.sunhao.stockprojecteg.util.TushareDataByNetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDataBussiessImpl implements BaseDataBussiess {
    @Autowired
    private BaseDataDao baseDataDao;

    @Override
    public List<BaseStockData> getData() {
        return baseDataDao.getData();
    }

    @Override
    public void saveDateByNet(List<String> stockCodeList, String startTime, String codeName) {
        List<BaseStockData> baseStockDataList = DataFromNetUtils.getDataToNowData(stockCodeList, startTime, codeName);
        baseDataDao.saveDateByNet(baseStockDataList);
    }
    @Override
    public void saveBaseData() {
        List<StockBaseInfo> stockBaseInfoList = TushareDataByNetUtil.getStockList();
        baseDataDao.saveBaseData(stockBaseInfoList);
    }
}
