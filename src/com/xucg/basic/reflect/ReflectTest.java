package com.xucg.basic.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom",12);
        Person p = (Person) obj;
        System.out.println(p);

        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance("Hello");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"xucg");
        System.out.println(p1);
    }

    // 获取Class实例的方式, Class实例对应着一个运行时类，加载到内存中的运行时类会缓存一段时间，在此时间内
    // 我们可以用不同的方式获取此运行时类
    @Test
    public void test2() throws ClassNotFoundException {
        // 方式一
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        // 方式二
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三
        Class<?> clazz3 = Class.forName("com.xucg.basic.reflect.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        // 方式四
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.xucg.basic.reflect.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);
    }
}
