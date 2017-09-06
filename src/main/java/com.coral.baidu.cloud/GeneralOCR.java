package com.coral.baidu.cloud;

import com.baidu.aip.ocr.AipOcr;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ccc on 2017/9/4.
 */
public class GeneralOCR {

    //设置APPID/AK/SK
    public static final String APP_ID = "10082052";
    public static final String API_KEY = "58BYvAoABCE4gTGLxuNwzCsq";
    public static final String SECRET_KEY = "zhtRY6HSPjDkIFNgChvoqE9L2xyV9V0a";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        // 初始化一个OcrClient
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用通用识别接口
        int times = 1;
        List<Long> list = Lists.newArrayList();
        for(int i=0;i<times;i++) {
            long s = System.currentTimeMillis();
            String genFilePath = "D:\\projects-coral\\baidu-cloud-sample\\images\\20170904134829.jpg";
            JSONObject genRes = client.basicGeneral(genFilePath, new HashMap<String, String>());
            long e = System.currentTimeMillis() - s;
            list.add(e);
            String words = genRes.get("words_result").toString();
            List<LinkedTreeMap<String, String>> wordMap = gson.fromJson(words, List.class);
            String data = wordMap.get(0).get("words").replaceAll("\\s*","");
            System.out.println(data+", take time: " + e);
        }
        long sum = 0;
        for(Long l : list) {
            sum = sum + l;
        }
        System.out.println("Average time is : " +  sum/times);
    }
}