package com.xucg.balance;

public class Sequence {
    private static Integer num = 0;

    public static Integer getAndIncrement()
    {
        return ++num;
    }
}
