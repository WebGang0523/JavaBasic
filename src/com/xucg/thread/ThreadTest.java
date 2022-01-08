package com.xucg.thread;

/**
 * 线程的创建：
 * 一、继承Thread类
 * 1、创建一个继承Thread的子类
 * 2、重写run方法
 * 3、创建对象，调用start
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("hello");
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for (int i=0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}


