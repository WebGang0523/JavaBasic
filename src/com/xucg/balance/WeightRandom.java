package com.xucg.balance;

import java.util.ArrayList;
import java.util.Random;

/**
 * 加权随机算法
 */
public class WeightRandom
{
    public static String getServer()
    {
        ArrayList<String> ips = new ArrayList<>();

        for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            for (int i=0;i<weight;i++) {
                ips.add(ip);
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(ips.size());

        return ips.get(randomPos);
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++) {
            System.out.println(getServer());
        }
    }
}
