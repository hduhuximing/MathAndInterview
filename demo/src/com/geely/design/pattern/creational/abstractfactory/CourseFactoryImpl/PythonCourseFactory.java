package com.geely.design.pattern.creational.abstractfactory.CourseFactoryImpl;

import com.geely.design.pattern.creational.abstractfactory.*;
import com.geely.design.pattern.creational.abstractfactory.ArticleImpl.PythonArticle;
import com.geely.design.pattern.creational.abstractfactory.VideoImpl.PythonVideo;

/**
 * Created by geely
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
