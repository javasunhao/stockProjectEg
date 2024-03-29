package com.sunhao.stockprojecteg;

import com.alibaba.fastjson.JSON;
import com.sunhao.stockprojecteg.model.IndexBasicModel;
import com.sunhao.stockprojecteg.model.IndexWeightModel;
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
        List<IndexWeightModel> aa = TushareDataByNetUtil.getIndexWeightData();
        System.out.println(JSON.toJSON(aa));
    }

    @Test
    public void test03() {
        System.out.println("\u53c2\u6570index_code\u4e0d\u53ef\u7f3a\u5c11");
    }
}
