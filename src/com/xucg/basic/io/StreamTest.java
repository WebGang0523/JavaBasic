package com.xucg.basic.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamTest {
    public static void main(String[] args) {
        (new StreamTest()).test1();
    }
    @Test
    public void test1(){
        BufferedReader bufferedReader = null;

        try{
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            String data;
            while (true) {
                System.out.println("请输入您的数据：");
                data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || ("exit").equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
