package com.coral.baidu.cloud;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by ccc on 2017/9/5.
 */
public class IdOCR {

    //设置APPID/AK/SK
    public static final String APP_ID = "10082052";
    public static final String API_KEY = "58BYvAoABCE4gTGLxuNwzCsq";
    public static final String SECRET_KEY = "zhtRY6HSPjDkIFNgChvoqE9L2xyV9V0a";

    public static void main(String[] args) {
        // 初始化一个OcrClient
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        IdOCR idOCR = new IdOCR();
        idOCR.idcardRecognition(client);
        idOCR.idcardBack(client);
    }

    public void idcardRecognition(AipOcr client) {
        // 设置识别身份证正面参数
        boolean isFront = true;
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        String imagePath = "D:\\projects-coral\\baidu-cloud-sample\\images\\id_front.jpg";
        JSONObject response = client.idcard(imagePath, isFront, options);
        System.out.println(response.toString());
    }

    public void idcardBack(AipOcr client) {
        // 设置识别身份证正面参数
        boolean isFront = false;
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        String imagePath = "D:\\projects-coral\\baidu-cloud-sample\\images\\id_back.jpg";
        JSONObject response = client.idcard(imagePath, isFront, options);
        System.out.println(response.toString());
    }
}
