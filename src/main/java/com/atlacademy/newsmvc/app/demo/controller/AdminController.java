package com.atlacademy.newsmvc.app.demo.controller;

import com.atlacademy.newsmvc.app.demo.model.NewsModel;
import com.atlacademy.newsmvc.app.demo.service.NewsService;
import com.atlacademy.newsmvc.app.demo.util.NewsValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private  final NewsService newsService;
    private  final NewsValidator newsValidator;
    private String surnam;
    @GetMapping("/news-list")
    public String newsList(Model model){
        model.addAttribute("newsList",newsService.getAllNews());
        model.addAttribute("newsListActive","active");
        return "adminpages/news-list";
    }

    @GetMapping("/add-news")
    public String addNes(Model model){
        model.addAttribute("newsList",newsService.getAllNews());
        model.addAttribute("newsListActive","active");
        model.addAttribute("news",new NewsModel());
        return "adminpages/news-form";
    }

    @PostMapping("/save-news")
    public String saveNews(@ModelAttribute("news") NewsModel news, Model model, BindingResult errors){
        log.info("news  modwel {}", model);
        newsValidator.validate(news,errors);
        if (errors.hasErrors()) {
            return "adminpages/news-form";
        }
        model.addAttribute("newsList",newsService.getAllNews());
        model.addAttribute("newsListActive","active");
        return "redirect:news-list";
    }


    @GetMapping("/edit-news")
    public String editNews(@RequestParam(value = "newsId") Long newsId, Model model){
        log.info("newsService.getNewsByID(newsId) {}",newsService.getNewsByID(newsId));
        model.addAttribute("news",newsService.getNewsByID(newsId));
        return "adminpages/news-form";
    }


}
