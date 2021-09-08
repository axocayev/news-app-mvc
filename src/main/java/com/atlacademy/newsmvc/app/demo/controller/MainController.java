package com.atlacademy.newsmvc.app.demo.controller;

import com.atlacademy.newsmvc.app.demo.config.Student;
import com.atlacademy.newsmvc.app.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final NewsService newsService;
    private final Student student;

    @GetMapping("/")
    public String indexPage(Model model){
        System.out.println("MainController  : "+student);

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

    //web.xml
    @GetMapping("/singleton/{value}")
    public  String singleton(HttpServletRequest httpRequest,
                             HttpServletResponse response,
                             @RequestParam(value = "name",required = false) String name,
                             @RequestParam("id") String id,
                             Model model, @PathVariable("value") int value){
        student.setValue(value);
        System.out.println(httpRequest.getRemoteHost());
        System.out.println(httpRequest.getRemoteHost());

        model.addAttribute("student",student);
        model.addAttribute("value",student.getValue());
        model.addAttribute("host",httpRequest.getRemoteHost());
        model.addAttribute("port",httpRequest.getLocalPort());
        model.addAttribute("context_path",httpRequest.getContextPath());
        model.addAttribute("path_nfo",httpRequest.getPathInfo());
        model.addAttribute("servlet",httpRequest.getServletPath());
        model.addAttribute("method",httpRequest.getMethod());
        model.addAttribute("query",httpRequest.getQueryString());
        model.addAttribute("name",name);
        model.addAttribute("id",id);

        return "scope";
    }

    @GetMapping("/scope")
    public  String scop(Model model){

        model.addAttribute("student",student);
        model.addAttribute("value",student.getValue());
        return "scope";
    }

}
