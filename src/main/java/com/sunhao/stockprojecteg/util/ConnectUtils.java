package com.sunhao.stockprojecteg.util;

import org.jsoup.Jsoup;

public class ConnectUtils {
    /**
     * 获取某一天的股票基础数据c
     * @param stockCode 股票代码 eg: cn_600588
     * @param time 数据获取时间 eg: 20181030
     * @return 日期，开盘，收盘，涨跌，涨幅，最低，最高，成交量，成交额，换手率
     */
    public static String getStockJsonData(String stockCode, String time){
        try {
            String urlModel = "http://q.stock.sohu.com/hisHq?code=%s&start=%s&end=%s&stat=1&order=D&period=d&callback=historySearchHandler&rt=jsonp";
            String url = String.format(urlModel, stockCode, time, time);
            String str = Jsoup.connect(url).ignoreContentType(true).execute().body();
            return new String(str.getBytes(), "GB18030");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
