package com.atlacademy.newsmvc.app.demo.controller;

import com.atlacademy.newsmvc.app.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final NewsService newsService;

    @GetMapping("/")
    public String indexPage(Model model){


        model.addAttribute("title","Our new project home page");
        model.addAttribute("currdate", LocalDateTime.now());
        model.addAttribute("home","active");
        return "index";
    }

    @GetMapping("/news-list")
    public String newsList(Model model){
        model.addAttribute("newsList",newsService.getAllNews());
        model.addAttribute("newsListActive","active");
        return "news-list";
    }

    @GetMapping("/news-details")
    public String newsList(Model model, @RequestParam(value = "newsId" ) Long newsId){
        model.addAttribute("news",newsService.getNewsByID(newsId));
        model.addAttribute("newsListActive","active");
        return "news-details";
    }

}
