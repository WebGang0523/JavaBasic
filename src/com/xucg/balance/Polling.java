package com.xucg.balance;

/**
 * 轮询算法
 */
public class Polling {
    private static Integer pos = 0;

    public static String getServer(){
        String ip = null;
        synchronized (pos) {
            if (pos >= ServerIps.LIST.size()) {
                pos = 0;
            }
            ip = ServerIps.LIST.get(pos);
            pos++;
        }

        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0;i<10;i++) {
            System.out.println(getServer());
        }
    }
}
