package com.geely.design.pattern.creational.factorymethod.ImplFactory;

import com.geely.design.pattern.creational.factorymethod.FEVideo;
import com.geely.design.pattern.creational.factorymethod.Video;
import com.geely.design.pattern.creational.factorymethod.VideoFactory;

/**
 * Created by geely
 */
public class FEVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new FEVideo();
    }
}
