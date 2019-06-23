package com.sunhao.stockprojecteg.util;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.model.IndexBasicModel;
import com.sunhao.stockprojecteg.model.StockBaseInfo;
import com.sunhao.stockprojecteg.model.StockBasicAPIModel;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TushareDataByNetUtil {
    private static final Map<String, Object> STOCK_LIST_POST_PARAMS = new HashMap<>();
    private static final Map<String, Object> INDEX_BASIC_POST_PARAMS = new HashMap<>();

    static {
        STOCK_LIST_POST_PARAMS.put("api_name", "stock_basic");
        Map<String, String> params1 = new HashMap<>();
        params1.put("list_status", "L");
        params1.put("exchange", "SZSE");
        STOCK_LIST_POST_PARAMS.put("params", params1);
        STOCK_LIST_POST_PARAMS.put("fields", "ts_code,symbol,name,area,industry,fullname,enname,market,exchange," +
                "curr_type,list_status,list_date,delist_date,is_hs");

        INDEX_BASIC_POST_PARAMS.put("api_name", "index_basic");
        Map<String, String> params2 = new HashMap<>();
        params2.put("market", "SSE");
        //params2.put("category", "综合指数");
        INDEX_BASIC_POST_PARAMS.put("params", params2);
        INDEX_BASIC_POST_PARAMS.put("fields","ts_code,name,fullname,market,publisher,index_type,category,base_date," +
                "base_point,list_date,weight_rule,desc,exp_date");
    }

    public static List<StockBaseInfo> getStockList(){
        List<StockBaseInfo> stockBaseInfoList = praseStockListTushareStr(getTushareDataByNet(STOCK_LIST_POST_PARAMS));
        Map<String, String> changeParams = new HashMap<>();
        changeParams.put("list_status", "L");
        changeParams.put("exchange", "SSE");
        STOCK_LIST_POST_PARAMS.put("params", changeParams);
        stockBaseInfoList.addAll(praseStockListTushareStr(getTushareDataByNet(STOCK_LIST_POST_PARAMS)));
        return stockBaseInfoList;
    }

    private static List<StockBaseInfo> praseStockListTushareStr(String str){
        StockBasicAPIModel model = JSON.parseObject(str, StockBasicAPIModel.class);
        List<List<String>> items = model.getData().getItems();
        List<StockBaseInfo> stockBaseInfoList = new ArrayList<>();
        items.forEach(info ->{
            int i = 0;
            StockBaseInfo stockBaseInfo = new StockBaseInfo();
            stockBaseInfo.setTsCode(info.get(i++));
            stockBaseInfo.setSymbol(info.get(i++));
            stockBaseInfo.setName(info.get(i++));
            stockBaseInfo.setArea(info.get(i++));
            stockBaseInfo.setIndustry(info.get(i++));
            stockBaseInfo.setFullname(info.get(i++));
            stockBaseInfo.setEnname(info.get(i++));
            stockBaseInfo.setMarket(info.get(i++));
            stockBaseInfo.setExchange(info.get(i++));
            stockBaseInfo.setCurrType(info.get(i++));
            stockBaseInfo.setListStatus(info.get(i++));
            stockBaseInfo.setListDate(info.get(i++));
            stockBaseInfo.setDelistDate(info.get(i++));
            stockBaseInfo.setIsHs(info.get(i));
            stockBaseInfoList.add(stockBaseInfo);
        });
        return stockBaseInfoList;
    }

    public static List<IndexBasicModel> getIndexBasicList(){
        List<IndexBasicModel> indexBasicModelList = praseIndexBasicStr(getTushareDataByNet(INDEX_BASIC_POST_PARAMS));
        Map<String, String> changeParams = new HashMap<>();
        changeParams.put("market", "SZSE");
        INDEX_BASIC_POST_PARAMS.put("params", changeParams);
        indexBasicModelList.addAll(praseIndexBasicStr(getTushareDataByNet(INDEX_BASIC_POST_PARAMS)));
        return indexBasicModelList;
    }

    private static List<IndexBasicModel> praseIndexBasicStr(String str){
        StockBasicAPIModel model = JSON.parseObject(str, StockBasicAPIModel.class);
        List<List<String>> items = model.getData().getItems();
        List<IndexBasicModel> indexBasicList = new ArrayList<>();
        items.forEach(info ->{
            int i = 0;
            IndexBasicModel indexBasicModel = new IndexBasicModel();
            indexBasicModel.setTsCode(info.get(i++));
            indexBasicModel.setName(info.get(i++));
            indexBasicModel.setFullname(info.get(i++));
            indexBasicModel.setMarket(info.get(i++));
            indexBasicModel.setPublisher(info.get(i++));
            indexBasicModel.setIndexType(info.get(i++));
            indexBasicModel.setCategory(info.get(i++));
            indexBasicModel.setBaseDate(info.get(i++));
            indexBasicModel.setBasePoint(info.get(i++));
            indexBasicModel.setListDate(info.get(i++));
            indexBasicModel.setWeightRule(info.get(i++));
            indexBasicModel.setDesc(info.get(i++));
            indexBasicModel.setExpDate(info.get(i));
            indexBasicList.add(indexBasicModel);
        });
        return indexBasicList;
    }

    private static String getTushareDataByNet(Map<String, Object> postParams){
        try {
            postParams.put("token", "65ce6bd54fc395860ff893d1c868018d598f9bab5c984e21fb29bce0");
            String urlStr = "http://api.tushare.pro";
            Connection connection= Jsoup.connect(urlStr)
                    .header("Content-Type", "application/json;charset=gbk")
                    .requestBody(JSON.toJSONString(postParams)).ignoreContentType(true);
            String str = connection.post().body().text();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
