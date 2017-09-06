package com.coral.baidu.cloud;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by ccc on 2017/9/5.
 */
public class DriverOCR {

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

        DriverOCR driverOCR = new DriverOCR();
        driverOCR.vehicleLicenseRecognition(client);
    }

    public void vehicleLicenseRecognition(AipOcr client) {
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        String imagePath = "D:\\projects-coral\\baidu-cloud-sample\\images\\driver.jpg";
        JSONObject response = client.vehicleLicense(imagePath, options);
        System.out.println(response.toString());
    }
}
