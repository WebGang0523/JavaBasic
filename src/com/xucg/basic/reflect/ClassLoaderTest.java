package com.xucg.basic.reflect;

import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        // 路径默认在当前module下
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//        properties.load(fileInputStream);

        // 默认在src目录下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");
        System.out.println(user);
    }

    @Test
    public void test2(){
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);
        System.out.println(String.class.getClassLoader());
    }
}
