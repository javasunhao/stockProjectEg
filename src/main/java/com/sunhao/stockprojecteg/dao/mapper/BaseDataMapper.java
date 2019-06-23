package com.sunhao.stockprojecteg.dao.mapper;

import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.model.IndexBasicModel;
import com.sunhao.stockprojecteg.model.StockBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDataMapper {

    List<BaseStockData> getData();

    void saveDateByNet(@Param("stockDataList") List<BaseStockData> stockDataList);

    void saveBaseData(@Param("stockBaseInfoList") List<StockBaseInfo> stockBaseInfoList);

    void saveIndexBasicData(@Param("indexBasicList") List<IndexBasicModel> indexBasicModelList);
}
