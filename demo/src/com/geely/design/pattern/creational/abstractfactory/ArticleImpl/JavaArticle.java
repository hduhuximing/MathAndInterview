package com.geely.design.pattern.creational.abstractfactory.ArticleImpl;

import com.geely.design.pattern.creational.abstractfactory.Article;

/**
 * Created by geely
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写Java课程手记");
    }
}
