package com.atlacademy.newsmvc.app.demo.service;

import com.atlacademy.newsmvc.app.demo.config.Student;
import com.atlacademy.newsmvc.app.demo.model.NewsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class NewsService {
    Logger LOGGER = Logger.getLogger(NewsService.class.getName());
   // private final Student student;


    public List<NewsModel> getAllNews() {
        LOGGER.info("get all news");
        List<NewsModel> list = new ArrayList<>();

        //student.setValue(12);
       // System.out.println("getAllNews  "+student);
        //System.out.println("getAllNews  "+student.getValue());

        list.add(new NewsModel(1l, "title 1", "content 1", "koton.pdf", "news.jpeg"));
        list.add(new NewsModel(2l, "title 2", "content 2", "Test.java", "news.jpeg"));
        list.add(new NewsModel(3l, "title 3", "content 3", "nohup.out", "news.jpeg"));
        LOGGER.info(String.format("all news  %s", list));
        return list;
    }

    public NewsModel getNewsByID(Long newsId) {
     //   System.out.println("get news by id "+student);
       // System.out.println("get news by id "+student.getValue());
        return getAllNews().stream().filter(news -> news.getNewsId().equals(newsId)).findFirst().get();
    }
}
