package com.atlacademy.newsmvc.app.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsModel {
    private Long newsId;
    private String title;
    private String content;

}
