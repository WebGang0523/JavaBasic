package com.xucg.balance;

import java.util.Random;

/**
 * 加权随机算法 - V2
 * 假设有一组服务器servers=[A，B，C]，对应的权重weights=[5，3，2]，权重总和为10。
 * （1）现在把这些权重平铺在一维坐标上，那么就会有[0，5]区间属于服务器A，[5，8]区间属于服务器B，[8，10]区间属于服务器C。
 * （2）接下来通过随机数生成一个范围在[0，10]之间的随机数，然后计算该随机数落在哪个区间上即可。
 */
public class WeightRandomV2
{
    public static String getServer()
    {
        int totalWeight = 0;
        boolean sameWeight = true;
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
        for (int i=0;i<weights.length;i++) {
            Integer weight = (Integer) weights[i];
            totalWeight += weight;
            if (sameWeight && i > 0 && !weight.equals(weights[i-1])) {
                sameWeight = false;
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(totalWeight);
        if (!sameWeight) {
            for (String ip: ServerIps.WEIGHT_LIST.keySet()) {
                Integer weight = ServerIps.WEIGHT_LIST.get(ip);
                if (randomPos < weight) {
                    return ip;
                }

                randomPos -= weight;
            }
        }

        randomPos = random.nextInt(ServerIps.WEIGHT_LIST.size());
        return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[randomPos];
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            System.out.println(getServer());
        }
    }
}
