package com.sunhao.stockprojecteg;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.model.IndexBasicModel;
import com.sunhao.stockprojecteg.model.StockBaseInfo;
import com.sunhao.stockprojecteg.util.DataFromNetUtils;
import com.sunhao.stockprojecteg.util.TushareDataByNetUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    //测试爬虫
    @Test
    public void test01() {
        List<String> stockCodeList = new ArrayList<>();
        stockCodeList.add("cn_000001");
        String str = DataFromNetUtils.getStockJsonData(stockCodeList, "20190604", "20190604");
        System.out.println(str);
        DataFromNetUtils.getObjectByStr(str,"codeName");
        //historySearchHandler([{"status":0,"hq":[["2018-10-30","23.95","23.80","-0.16","-0.67%","22.70","24.45","242465","57460.49","1.28%"]],"code":"cn_600588","stat":["锟桔硷拷:","2018-10-30锟斤拷2018-10-30","-0.16","-0.67%",22.7,24.45,242465,57460.49,"1.28%"]}])
        //historySearchHandler([{"status":0,"hq":[["2019-05-28","27.00","27.62","0.62","2.30%","26.84","27.62","409946","111749.39","0.42%"]],"code":"cn_000002","stat":["锟桔硷拷:","2019-05-28锟斤拷2019-05-28","0.62","2.30%",26.84,27.62,409946,111749.39,"0.42%"]}])
    }

    @Test
    public void testTushare(){
        List<IndexBasicModel> aa = TushareDataByNetUtil.getIndexBasicList();
        System.out.println(JSON.toJSON(aa));
    }

    @Test
    public void test02() {
        List<StockBaseInfo> aa = TushareDataByNetUtil.getStockList();
        System.out.println(JSON.toJSON(aa));

    }

    @Test
    public void test03() {

        System.out.println("\u6982\u8981:\u4e2d\u56fd\u6218\u7565\u65b0\u5174\u4ea7\u4e1a\u6210\u4efd\u6307\u6570\u9009\u53d6\u8282\u80fd\u73af\u4fdd\u3001\u65b0\u4e00\u4ee3\u4fe1\u606f\u6280\u672f\u4ea7\u4e1a\u3001\u751f\u7269\u4ea7\u4e1a\u3001\u9ad8\u7aef\u88c5\u5907\u5236\u9020\u3001\u65b0\u80fd\u6e90\u4ea7\u4e1a\u3001\u65b0\u6750\u6599\u4ea7\u4e1a\u3001\u65b0\u80fd\u6e90\u6c7d\u8f66\u3001\u6570\u5b57\u521b\u610f\u4ea7\u4e1a\u3001\u9ad8\u6280\u672f\u670d\u52a1\u4e1a\u7b49\u9886\u57df\u5177\u6709\u4ee3\u8868\u6027\u7684100\u5bb6\u4e0a\u5e02\u516c\u53f8\uff0c\u91c7\u7528\u81ea\u7531\u6d41\u901a\u80a1\u672c\u52a0\u6743\u65b9\u5f0f\uff0c\u4ee5\u53cd\u6620\u4e2d\u56fd\u6218\u7565\u65b0\u5174\u4ea7\u4e1a\u4e0a\u5e02\u516c\u53f8\u7684\u8d70\u52bf\u3002");

    }
}
