package com.geely.design.pattern.creational.factorymethod.ImplFactory;

import com.geely.design.pattern.creational.factorymethod.JavaVideo;
import com.geely.design.pattern.creational.factorymethod.Video;
import com.geely.design.pattern.creational.factorymethod.VideoFactory;

/**
 * Created by geely
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
