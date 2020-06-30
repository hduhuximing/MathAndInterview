package com.geely.design.pattern.creational.factorymethod.ImplFactory;

import com.geely.design.pattern.creational.factorymethod.PythonVideo;
import com.geely.design.pattern.creational.factorymethod.Video;
import com.geely.design.pattern.creational.factorymethod.VideoFactory;

/**
 * Created by geely
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
