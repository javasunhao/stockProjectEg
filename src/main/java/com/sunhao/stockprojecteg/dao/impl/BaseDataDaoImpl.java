package com.sunhao.stockprojecteg.dao.impl;

import com.sunhao.stockprojecteg.constant.Constant;
import com.sunhao.stockprojecteg.dao.inf.BaseDataDao;
import com.sunhao.stockprojecteg.dao.mapper.BaseDataMapper;
import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.model.IndexBasicModel;
import com.sunhao.stockprojecteg.model.IndexWeightModel;
import com.sunhao.stockprojecteg.model.StockBaseInfo;
import com.sunhao.stockprojecteg.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseDataDaoImpl implements BaseDataDao {

    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public List<BaseStockData> getData() {
        return baseDataMapper.getData();
    }

    @Override
    public void saveDateByNet(List<BaseStockData> stockDataList) {
        CollectionUtils.split(stockDataList, Constant.SPLIT_CONSTANT).forEach(list ->{
            baseDataMapper.saveDateByNet(list);
        });
    }

    @Override
    public void saveBaseData(List<StockBaseInfo> stockBaseInfoList) {
        CollectionUtils.split(stockBaseInfoList, Constant.SPLIT_CONSTANT).forEach(list ->{
            baseDataMapper.saveBaseData(list);
        });
    }

    @Override
    public void saveIndexBasicData(List<IndexBasicModel> indexBasicModelList) {
        CollectionUtils.split(indexBasicModelList, Constant.SPLIT_CONSTANT).forEach(list ->{
            baseDataMapper.saveIndexBasicData(list);
        });
    }

    @Override
    public void saveIndexWeightData(List<IndexWeightModel> indexWeightModelList) {
        CollectionUtils.split(indexWeightModelList, Constant.SPLIT_CONSTANT).forEach(list ->{
            baseDataMapper.saveIndexWeightData(list);
        });
    }
}
