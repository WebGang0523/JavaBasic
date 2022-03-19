package com.xucg.balance;

import java.util.HashMap;
import java.util.Map;

/**
 * 平滑加权轮询算法
 *
 * 每个服务器对应两个权重，分别为weight和currentWeight。其中weight是固定的，currentWeight会动态调整，初始值为0
 * 当有新的请求进来时，遍历服务器列表，让它的currentWeight加上自身权重，遍历完成后，找到最大的currentWeight。
 * 并将最大的currentWeight减去权重总和，然后返回相应的服务器即可。
 *
 * 次数	当前currentWeight数组 (currentWeight+=weight)	选择结果max(currentWeight)	减去权重总和后的currentWeight数组 (max(currentWeight)-=sum(weight))
 * 1	[5,1,1]	                                                    A	                    [-2,1,1]
 * 2	[3,2,2]	                                                    A	                    [-4,2,2]
 * 3	[1,3,3]	                                                    B	                    [1,-4,3]
 * 4	[6,-3,4]	                                                A	                    [-1,-3,4]
 * 5	[4,-2,5]	                                                C	                    [4,-2,-2]
 * 6	[9,-1,-1]	                                                A	                    [2,-1,-1]
 * 7	[7,0,0]	                                                    A	                    [0,0,0]
 * 8	[5,1,1]	                                                    A	                    [-2,1,1]
 * 如表所示，经过平滑行处理后，得到的服务器序列为[A，A，B，A，C，A，A]，相比之前的序列[A，A，A，A，A，B，C]，
 * 分布性要好一些。初始情况下currentWeight=[0，0，0] ，在第7个请求处理完后，currentWeight再次变回[0，0，0]。
 * 你会惊讶的发现在第8次的时候，当前currentWeight数组又变回了[5,1,1] !!!
 */
public class WeightPollingV2 {

    private static Map<String,Weight> weightMap = new HashMap<>();

    public static String getServer(){
        int totalWeight = 0;
        totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0,(w1,w2) -> w1 + w2);
        if (weightMap.isEmpty()) {
            ServerIps.WEIGHT_LIST.forEach((key,value)->{
                weightMap.put(key,new Weight(key,value,value));
            });
        }

        Weight maxCurrentWeight = null;
        for (Weight weight: weightMap.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }

        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalWeight);

        for (Weight weight: weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0;i<14;i++) {
            System.out.println(getServer());
        }
    }
}
