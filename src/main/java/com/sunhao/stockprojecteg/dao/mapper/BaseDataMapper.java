package com.sunhao.stockprojecteg.dao.mapper;

import com.sunhao.stockprojecteg.model.BaseStockData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDataMapper {

    List<BaseStockData> getData();

    void saveDateByNet(@Param("stockDataList") List<BaseStockData> stockDataList);
}
