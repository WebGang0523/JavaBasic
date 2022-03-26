package com.xucg.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 */
public class ClimbStairs {

    private final Map<Integer,Integer> storeMap = new HashMap<>();

    // 存在重复求解问题,递归
//    public int climb(int n)
//    {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        if (null != storeMap.get(n)) {
//            return storeMap.get(n);
//        }else {
//            int result = climb(n-1) + climb(n-2);
//            storeMap.put(n,result);
//
//            return result;
//        }
//    }

    // 循环解法
    public int climb(int n)
    {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result = 0;
        int pre = 2;
        int prepre = 1;
        for (int i=3;i<=n;i++){
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }

        return result;
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();

        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.climb(30));

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + "(ms)");
    }
}
