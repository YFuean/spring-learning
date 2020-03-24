package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Recommend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName RecommendController
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/24
 **/
@Controller
@RequestMapping("/")
public class RecommendController {
    @GetMapping("recommend")
    public String recommend(Model model){
        Recommend[] recommend = {
                new Recommend("「你我猫狗」河北","插画-商业插画",1211,9,64,"木木王木木19","1天前",
                        "https://img.zcool.cn/community/01aa645e7821cda8012165188a996b.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/03112a05da018d9a80121b722c4b2b1.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("iOS与Android设计规范解析（二）之常用控件","文章-观点-UI",1648,4,47,"UX设计笔记","6小时前",
                        "https://img.zcool.cn/community/0172cd5e786f1fa8012165183e7408.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/01763f5e69e81ba8012165189883d7.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("修理台","插画-概念设定",1410,10,111,"migaloo2341","1天前",
                        "https://img.zcool.cn/community/012c675e780de4a801216518619ca5.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/01ddeb5cb71ad0a801208f8bf42152.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("Cos钢铁侠 Mark 1 ——可穿戴钢铁侠战甲制作花絮","手工艺-其他手工",5298,6,67,"光澤作用工作室","1天前",
                        "https://img.zcool.cn/community/01d5d65e77722fa8012165189228f7.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/04fac358fa6626a8012160f7181c50.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("《来自喵星系列》-糖糖的甜品店第三弹6只猫","插画-商业插画",1523,44,118,"Jolbilin焦杨","1天前",
                        "https://img.zcool.cn/community/0140775e77ddf0a8012165186fd851.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/045df256663730000001e053d995db.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("简笔插画2020.3月-2","插画-儿童插画",2780,13,96,"巴颜简笔插画","1天前",
                        "https://img.zcool.cn/community/0125f25e776322a801216518f5db36.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/0124825e439597a80120a895a000c9.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("IQOO【移动设备模块化试验】","平面-海报",2897,37,347,"小田","1天前",
                        "https://img.zcool.cn/community/01d0ca5e78a4aca801216518043c33.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/03137015d31549ba8012187f47cb621.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("《加泰罗尼亚地图集》","平面-书籍",1697,1,40,"天佑书房","20小时前",
                        "https://img.zcool.cn/community/01a3b45e7893baa80120a8950d4811.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/0426f757c59f790000018c1b6d10ad.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("梨花笑 之 人生若只如初见梦鱼","摄影-人像",11000,38,568,"腰果虾仁","1天前",
                        "https://img.zcool.cn/community/0186145e786c16a80120a895b388f4.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/004cd35950bfc8a8012193a37f8fbc.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("鼠年抗毒","动漫-其他动漫",4863,37,637,"约翰强尼","20小时前",
                        "https://img.zcool.cn/community/01e58c5e76f42ba80120a895d84e03.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/0469d6566118e000000155954e1681.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("时光流沙","摄影-风光",7093,19,190,"列马革","1天前",
                        "https://img.zcool.cn/community/01d3045e77262aa80121651859851a.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/0319c545ab2b0a3a801218207374bbf.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("王者荣耀 【抢鲲大作战】","插画-商业插画",5931,34,299,"YOUNGIKE","2天前",
                        "https://img.zcool.cn/community/012f3a5e75e2caa80120a895a95ee4.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/016f245e73688ba80120a8950cbfe8.jpg@80w_80h_1c_1e_1o_100sh.jpg"),
                new Recommend("楚歌《虞歌》","插画-游戏原画",7480,28,452,"徐子晖cicman","2天前",
                        "https://img.zcool.cn/community/0315e765e7607e8a801216518cc7274.jpg@520w_390h_1c_1e_1o_100sh.jpg","https://img.zcool.cn/community/000a3f5b139765a801202e6062d531.jpg@80w_80h_1c_1e_1o_100sh.jpg")
        };

        List<Recommend> recommendList = Arrays.asList(recommend);
        model.addAttribute("recommendList",recommendList);
        return "recommend";
    }
}
