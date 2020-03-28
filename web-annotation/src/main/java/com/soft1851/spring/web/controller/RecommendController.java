package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.RecommendService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/28
 **/
@Controller
@RequestMapping(value = "/")
public class RecommendController {
    @Resource
    private RecommendService recommendService;

    @GetMapping(value = "recommends",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUsers(){
        ResponseObject re = new ResponseObject(1,"success",recommendService.queryAll());
        return JSONObject.toJSONString(re);
    }

    @GetMapping("/recommend")
    public String user(Model model){
        model.addAttribute("recommends",recommendService.queryAll());
        return "recommend";
    }
}
