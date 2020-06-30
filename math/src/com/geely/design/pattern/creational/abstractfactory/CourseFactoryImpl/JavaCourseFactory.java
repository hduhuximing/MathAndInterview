package com.geely.design.pattern.creational.abstractfactory.CourseFactoryImpl;

import com.geely.design.pattern.creational.abstractfactory.Article;
import com.geely.design.pattern.creational.abstractfactory.ArticleImpl.JavaArticle;
import com.geely.design.pattern.creational.abstractfactory.CourseFactory;
import com.geely.design.pattern.creational.abstractfactory.Video;
import com.geely.design.pattern.creational.abstractfactory.VideoImpl.JavaVideo;

/**
 * Created by geely
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
