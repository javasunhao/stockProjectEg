package com.sunhao.stockprojecteg.service;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.bussiess.inf.BaseDataBussiess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/baseData")
public class BaseServiceImpl {

    @Autowired
    private BaseDataBussiess baseDataBussiess;

    @RequestMapping("/getDate")
    public String getBaseDate(){
        return JSON.toJSONString(baseDataBussiess.getData());
    }

}
