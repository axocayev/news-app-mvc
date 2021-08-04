package com.atlacademy.newsmvc.app.demo.controller;

import com.atlacademy.newsmvc.app.demo.model.NewsModel;
import com.atlacademy.newsmvc.app.demo.service.NewsService;
import com.atlacademy.newsmvc.app.demo.util.NewsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final NewsService newsService;
    private final NewsValidator newsValidator;
    private String surnam;

    @GetMapping("/news-list")
    public String newsList(Model model) {
        model.addAttribute("newsList", newsService.getAllNews());
        model.addAttribute("newsListActive", "active");
        return "adminpages/news-list";
    }

    @GetMapping("/add-news")
    public String addNes(Model model) {
        model.addAttribute("newsList", newsService.getAllNews());
        model.addAttribute("newsListActive", "active");
        model.addAttribute("news", new NewsModel());
        return "adminpages/news-form";
    }

    @PostMapping(name = "/save-news",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public String saveNews(@RequestPart("news") NewsModel news,
                           @RequestPart("file") MultipartFile file,
                           Model model, BindingResult errors) {
        log.info("file {}",file.getOriginalFilename());
        log.info("news  modwel {}", model);
        newsValidator.validate(news, errors);
        if (errors.hasErrors() ) {
            return "adminpages/news-form";
        }
        model.addAttribute("newsList", newsService.getAllNews());
        model.addAttribute("newsListActive", "active");
        return "redirect:news-list";
    }


    @GetMapping("/edit-news" )
    public String editNews(@RequestParam(value = "newsId") Long newsId, Model model) {
        log.info("newsService.getNewsByID(newsId) {}", newsService.getNewsByID(newsId));
        model.addAttribute("news", newsService.getNewsByID(newsId));
        return "adminpages/news-form";
    }


    private String saveImage(MultipartFile file) {
        // Get the name of the file
        String filename = file.getOriginalFilename();
        // Get the file extension
        String suffix = filename.substring(filename.lastIndexOf("."));
        // upload files on upload file folder under the D drive
        String path = "/Users/anar/Desktop/";
        // prevent duplicate file names random file name
        filename = path + UUID.randomUUID() + suffix;
        File f = new File(filename);
        // If you do not upload a folder under the D drive to create a
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            // File type into the MultipartFile
            file.transferTo(f);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

}
