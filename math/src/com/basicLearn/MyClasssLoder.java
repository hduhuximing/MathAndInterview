package com.basicLearn;

import java.io.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/26 12:28 下午
 */
public class MyClasssLoder extends ClassLoader {
    private String directory;

    public MyClasssLoder(String directory) {
        this.directory = directory;
    }

    public MyClasssLoder(String directory, ClassLoader parent) {
        super(parent);
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String name) {
        try {
            String file = directory + File.separator + name.replace(".", File.separator) + ".class";
            InputStream in = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = in.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            byte[] bytes = outputStream.toByteArray();
            in.close();
            outputStream.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
