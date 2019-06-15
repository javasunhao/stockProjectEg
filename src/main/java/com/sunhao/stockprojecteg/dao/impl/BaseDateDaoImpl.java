package com.sunhao.stockprojecteg.dao.impl;

import com.sunhao.stockprojecteg.dao.inf.BaseDateDao;
import com.sunhao.stockprojecteg.dao.mapper.BaseDataMapper;
import com.sunhao.stockprojecteg.model.BaseStockData;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseDateDaoImpl implements BaseDateDao {

    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public List<BaseStockData> getData() {
        return baseDataMapper.getData();
    }
}
