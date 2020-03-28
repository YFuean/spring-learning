package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JueJinSpider
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/28
 **/
public class JueJinSpider {
    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopic(){
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7ec68df265da799947c11e&device_id=1585366669647&token=eyJhY2Nlc3NfdG9rZW4iOiJzdnBqM1FkWFVoWjVYMlNJIiwicmVmcmVzaF90b2tlbiI6IlR6aVp0RXNVQWpOTVI5aEYiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get,context);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //如果请求成功则获取网页源码
        if (response.getStatusLine().getStatusCode() == SUCCESS){
            //获取响应对象实体，并转换成utf-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try{
                res = EntityUtils.toString(entity,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }

            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray content = jsonObject.getJSONObject("d").getJSONArray("list");
            content.forEach(o -> {
                JSONObject json = JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followersCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topics.add(topic);
            });
        }else {
            System.out.println("请求失败");
        }
        try{
            response.close();
            httpClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return topics;
    }

    public static void main(String[] args) {
        System.out.println(getTopic());
    }
}
