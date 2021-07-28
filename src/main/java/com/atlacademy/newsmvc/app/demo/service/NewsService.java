package com.atlacademy.newsmvc.app.demo.service;

import com.atlacademy.newsmvc.app.demo.model.NewsModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    public List<NewsModel> getAllNews(){

        List<NewsModel> list=new ArrayList<>();
        list.add(new NewsModel(1l,"title 1","content 1"));
        list.add(new NewsModel(2l,"title 2","content 2"));
        list.add(new NewsModel(3l,"title 3","content 3"));
        list.add(new NewsModel(4l,"title 4","content 4"));

        return list;
    }
    public NewsModel getNewsByID(Long newsId){


        return getAllNews().stream().filter(news->news.getNewsId().equals(newsId)).findFirst().get();
    }
}
