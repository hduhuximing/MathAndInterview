package com.geely.design.pattern.creational.factorymethod;

import com.geely.design.pattern.creational.factorymethod.ImplFactory.FEVideoFactory;
import com.geely.design.pattern.creational.factorymethod.ImplFactory.JavaVideoFactory;
import com.geely.design.pattern.creational.factorymethod.ImplFactory.PythonVideoFactory;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new PythonVideoFactory();
        VideoFactory videoFactory2 = new JavaVideoFactory();
        VideoFactory videoFactory3 = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();

    }

}
