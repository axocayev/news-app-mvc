package com.atlacademy.newsmvc.app.demo.util;


import com.atlacademy.newsmvc.app.demo.model.NewsModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewsValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return NewsModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewsModel newsModel = (NewsModel) o;


        if (newsModel.getTitle().length() < 6 ) {
            errors.rejectValue("title", "title.error");
        }

    }
}