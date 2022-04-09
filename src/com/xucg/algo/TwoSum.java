package com.xucg.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//    public static int[] twoSum(int[] nums, int target)
//    {
//        int[] result = new int[2];
//        for (int i=0;i<nums.length-1;i++) {
//            for (int j=i+1;j< nums.length;j++) {
//                if (target == nums[i] + nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
//
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    public static int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer> storeNums = new HashMap<>(nums.length,1);
        int[] result = new int[2];
        int another;
        Integer anotherIndex;
        for (int i=0;i<nums.length;i++) {
            another = target - nums[i];
            anotherIndex = storeNums.get(another);
            if (anotherIndex != null) {
                result[0] = i;
                result[1] = anotherIndex;

                return result;
            }else{
                storeNums.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,5};
        int[] result = TwoSum.twoSum(nums,9);
        System.out.println(Arrays.toString(result));
    }
}
