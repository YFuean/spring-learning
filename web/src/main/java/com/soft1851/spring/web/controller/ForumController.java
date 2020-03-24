package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

/**
 * @ClassName ForumController
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/21
 **/
//@RestController
//@RequestMapping(value = "forum")
public class ForumController {
//    @Autowired
//    private ForumService forumService;
//
//    @RequestMapping(value = "/insert",produces = "application/json; charset=utf-8")
//    public String insert(Forum forum){
//        ResponseObject ro = new ResponseObject(1,"成功",forumService.insert(forum));
//        return JSON.toJSONString(ro);
//    }
//
//    @RequestMapping(value = "/getById={forumId}",produces = "application/json; charset=utf-8")
//    public String getById(@PathVariable("forumId") int forumId){
//        ResponseObject ro = new ResponseObject(1,"成功",forumService.getById(forumId));
//        return JSON.toJSONString(ro);
//    }
//
//    @RequestMapping(value = "/list",produces = "application/json; charset=utf-8")
//    public String getForums(){
//        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectAll());
//        return JSON.toJSONString(ro);
//    }
}
