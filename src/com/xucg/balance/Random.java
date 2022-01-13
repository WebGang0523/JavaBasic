package com.xucg.balance;

/**
 * 简单随机算法
 * 这个简单随机算法使用与每天机器的性能差不多的时候，实际上，生产中可能某些机器的性能更高一点，它可以处理更多的情况，所以，我们可以对每台服务器设置一个权重。
 */
public class Random {
    public static String getServer(){
        java.util.Random random = new java.util.Random();
        int i = random.nextInt(ServerIps.LIST.size());

        return ServerIps.LIST.get(i);
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            System.out.println(getServer());
        }
    }
}
