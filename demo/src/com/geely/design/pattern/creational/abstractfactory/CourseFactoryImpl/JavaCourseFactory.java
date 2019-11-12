package com.geely.design.pattern.creational.abstractfactory.CourseFactoryImpl;

import com.geely.design.pattern.creational.abstractfactory.*;
import com.geely.design.pattern.creational.abstractfactory.ArticleImpl.JavaArticle;
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
