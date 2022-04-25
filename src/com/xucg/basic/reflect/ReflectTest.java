package com.xucg.basic.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
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
}
