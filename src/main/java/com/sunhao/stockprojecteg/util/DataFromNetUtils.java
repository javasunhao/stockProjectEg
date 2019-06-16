package com.sunhao.stockprojecteg.util;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.model.BaseStockData;
import com.sunhao.stockprojecteg.model.OrginDataModel;
import org.jsoup.Jsoup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataFromNetUtils {

    public static List<BaseStockData> getCurrentMonthData(List<String> stockCodeList) {
        String resultStr = getStockJsonData(stockCodeList, TimeChangeUtils.getCurrentMonthFirstDate(),
                TimeChangeUtils.getCurrentDayDate());
        return getObjectByStr(resultStr, "");
    }

    public static List<BaseStockData> getDataToNowData(List<String> stockCodeList, String startTime, String codeName) {
        String resultStr = getStockJsonData(stockCodeList, startTime.replace("-", ""),
                TimeChangeUtils.getCurrentDayDate());
        return getObjectByStr(resultStr, codeName);
    }

    /**
     * 获取某一天的股票基础数据c
     *
     * @param stockCodeList 股票代码 eg: cn_600588
     * @param starTime      数据获取时间 eg: 20181030
     * @param endTime       数据获取时间 eg: 20181030
     * @return 日期，开盘，收盘，涨跌，涨幅，最低，最高，成交量，成交额，换手率
     */
    public static String getStockJsonData(List<String> stockCodeList, String starTime, String endTime) {
        try {
            String stockCodeStr = stockCodeList.stream().collect(Collectors.joining(","));
            String urlModel = "http://q.stock.sohu.com/hisHq?code=%s&start=%s&end=%s&stat=1&order=D&period=d";
            String url = String.format(urlModel, stockCodeStr, starTime, endTime);
            //Jsoup.connect(url).ignoreContentType(true).execute().body();
            //[{"status":0,"hq":[["2019-05-28","27.00","27.62","0.62","2.30%","26.84","27.62","409946","111749.39","0.42%"]],"code":"cn_000002","stat":["累计:","2019-05-28至2019-05-28","0.62","2.30%",26.84,27.62,409946,111749.39,"0.42%"]}]
            String str = Jsoup.parse(new URL(url).openStream(), "gbk", url).body().text();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将字符串转化为BaseStockData格式对象
     *
     * @param str
     * @return
     */
    public static List<BaseStockData> getObjectByStr(String str, String name) {
        //TODO 兼容处理股票代码错误的情况
        List<OrginDataModel> orginDataModelList = JSON.parseArray(str, OrginDataModel.class);
        List<BaseStockData> dataList = new ArrayList<>();
        orginDataModelList.forEach(info -> {
            List<String> strList = JSON.parseArray(info.getHq(), String.class);
            for (String json : strList) {
                String[] data = json.substring(1, json.length() - 1).split(",");
                BaseStockData baseStockData = new BaseStockData();
                baseStockData.setData(data[0].substring(1, data[0].length() - 1).replace("-", ""));
                baseStockData.setOpenPrice(data[1].substring(1, data[1].length() - 1));
                baseStockData.setClosePrice(data[2].substring(1, data[2].length() - 1));
                baseStockData.setRisePrice(data[3].substring(1, data[3].length() - 1));
                baseStockData.setAmplitude(data[4].substring(1, data[4].length() - 1));
                baseStockData.setHighPrice(data[5].substring(1, data[5].length() - 1));
                baseStockData.setLowPrice(data[6].substring(1, data[6].length() - 1));
                baseStockData.setVolume(data[7].substring(1, data[7].length() - 1));
                baseStockData.setTurnover(data[8].substring(1, data[8].length() - 1));
                baseStockData.setHandTurnoverRate(data[9].substring(1, data[9].length() - 1));
                baseStockData.setCode(info.getCode().split("_")[1]);
                baseStockData.setCountry(info.getCode().split("_")[0]);
                baseStockData.setCodeName(name);
                dataList.add(baseStockData);
            }
        });
        return dataList;
    }
}
