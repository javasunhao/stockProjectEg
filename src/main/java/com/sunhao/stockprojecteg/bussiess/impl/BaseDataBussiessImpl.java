package com.sunhao.stockprojecteg.bussiess.impl;

import com.sunhao.stockprojecteg.dao.inf.BaseDateDao;
import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.bussiess.inf.BaseDataBussiess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDataBussiessImpl implements BaseDataBussiess {
    @Autowired
    private BaseDateDao baseDateDao;
    @Override
    public List<BaseStockData> getData() {
        return baseDateDao.getData();
    }
}
