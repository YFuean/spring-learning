package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/24
 **/
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("message","Hello Spring Mvc~~~~~");
        Book[] book = {new Book("教父",234.0),
                new Book("社会契约论",54.7),
                new Book("物种起源",65.3)};
        List<Book> bookList = Arrays.asList(book);
        model.addAttribute("bookList",bookList);
        return "home";
    }
}
