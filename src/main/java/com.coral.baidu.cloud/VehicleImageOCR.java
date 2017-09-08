package com.coral.baidu.cloud;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by ccc on 2017/9/8.
 */
public class VehicleImageOCR {

    //设置APPID/AK/SK
    public static final String APP_ID = "10112429";
    public static final String API_KEY = "VCkbQmBBQnR1n7gF2iUNMu29";
    public static final String SECRET_KEY = "p0S1VtOG3FEpnYiHF8Uq7cLp860ldMYt";
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        // 初始化一个OcrClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(5000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("top_num", "5");

        String path = "D:\\projects-coral\\baidu-cloud-sample\\images\\car2.jpg";
        JSONObject res = client.carDetect(path, options);
        System.out.println(res.toString(2));
    }
}
