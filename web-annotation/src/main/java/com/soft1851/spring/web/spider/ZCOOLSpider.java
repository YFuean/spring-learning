package com.soft1851.spring.web.spider;

import com.soft1851.spring.web.entity.Recommend;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZCOOLSpider
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
public class ZCOOLSpider {
    private static final Integer SUCCESS = 200;

    public static List<Recommend> getRecommend() throws Exception{
        List<Recommend> recommends = new ArrayList<>();
        //目标地址
        String url = "https://www.zcool.com.cn/designer";
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
        //System.out.println(response.getStatusLine());


        //如果请求成功则获取网页源码
        if (response.getStatusLine().getStatusCode() == SUCCESS){
            HttpEntity entity = response.getEntity();
            if (entity != null){
                String res = EntityUtils.toString(entity);
                Document document = Jsoup.parse(res);
                Elements elements =document.getElementsByClass("card-designer-list");

                //System.out.println(elements.size());

                for (Element element : elements){
                    //头像
                    Element box1 = element.child(0);
                    Elements select_avatar = box1.select(".avatar img");
                    String avatar =  select_avatar.attr("src");
                    //名字,城市和职业，
                    Element box2 = element.child(1);
                    String userName =  box2.select(".title-content").text();
                    String city_profession = box2.select(".position-info span").text();
                    String contentCount = box2.select(".work a").text();
                    String fansCount = box2.select(".fans a").text();

                    Recommend recommend = Recommend.builder().id("13399074").userName(userName)
                            .avatar(avatar).cityName(city_profession).professionName("设计师")
                            .contentCount(Integer.parseInt(contentCount)).fansCount(Integer.parseInt(fansCount))
                            .popularityCount(100).build();
                    recommends.add(recommend);
                }
            }
        }else {
            System.out.println("请求失败");
        }
        try{
            response.close();
            httpClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return recommends;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getRecommend());
    }
}
