package com.geely.design.pattern.creational.abstractfactory.VideoImpl;

import com.geely.design.pattern.creational.abstractfactory.Video;

/**
 * Created by geely
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
