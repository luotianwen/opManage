package com.op.util;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by yongshi on 2016/9/20.
 */
public class AMap {
    public static String getLogLan(String address) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        // 目标地址
        HttpGet request = new HttpGet(String.valueOf(new URI("http://restapi.amap.com/v3/geocode/geo?address="+address+"&output=JSON&key=2b1d2266cba10e09ffd009ab9381e773")));
        // 执行
        HttpResponse httpresponse = httpclient.execute(request);
        HttpEntity entity = httpresponse.getEntity();
        String body = EntityUtils.toString(entity);
        JSONObject objJson = JSONObject.fromObject(body);

        Object obj = objJson.get("geocodes");
        obj = obj.toString().substring(1);
        obj = obj.toString().substring(0,obj.toString().length()-1);
        JSONObject j = JSONObject.fromObject(obj);
        String location = j.getString("location");

         return location;
    }
    public static void main(String[]agr){
        try {
            getLogLan("北京文化馆");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
