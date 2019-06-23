package com.sunhao.stockprojecteg.service;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.bussiess.inf.BaseDataBussiess;
import com.sunhao.stockprojecteg.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/baseData")
public class BaseServiceImpl {

    @Autowired
    private BaseDataBussiess baseDataBussiess;

    @RequestMapping("/getDate")
    public String getBaseDate() {
        return JSON.toJSONString(baseDataBussiess.getData());
    }

    @RequestMapping("/saveDateByNet")
    public String saveDateByNet(@RequestParam("stockCode") String stockCode, @RequestParam("startTime") String startTime,
                                @RequestParam("codeName") String codeName) {
        if (StringUtils.isNotEmpty(stockCode)) {
            List<String> stockCodeList = Arrays.asList(stockCode.split(","));
            baseDataBussiess.saveDateByNet(stockCodeList, startTime, codeName);
            return "saveDateByNet is ok";
        }
        return "saveDateByNet is fail";
    }

    @RequestMapping("/saveBaseData")
    public String saveBaseData(){
        baseDataBussiess.saveBaseData();
        return "saveBaseData is OK";
    }

    @RequestMapping("/saveIndexBasicData")
    public String saveIndexBasicData(){
        baseDataBussiess.saveIndexBasicData();
        return "saveIndexBasicData is OK";
    }
}
