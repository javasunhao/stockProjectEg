package com.sunhao.stockprojecteg;

import org.junit.Test;
import com.sunhao.stockprojecteg.util.ConnectUtils;

import java.util.UUID;

public class MyTest {
    //测试爬虫
    @Test
    public void test01() {
        String str = ConnectUtils.getStockJsonData("cn_000002", "20190528");
        System.out.println(str);
        //historySearchHandler([{"status":0,"hq":[["2018-10-30","23.95","23.80","-0.16","-0.67%","22.70","24.45","242465","57460.49","1.28%"]],"code":"cn_600588","stat":["锟桔硷拷:","2018-10-30锟斤拷2018-10-30","-0.16","-0.67%",22.7,24.45,242465,57460.49,"1.28%"]}])
        //historySearchHandler([{"status":0,"hq":[["2019-05-28","27.00","27.62","0.62","2.30%","26.84","27.62","409946","111749.39","0.42%"]],"code":"cn_000002","stat":["锟桔硷拷:","2019-05-28锟斤拷2019-05-28","0.62","2.30%",26.84,27.62,409946,111749.39,"0.42%"]}])
    }

    @Test
    public void test02() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}