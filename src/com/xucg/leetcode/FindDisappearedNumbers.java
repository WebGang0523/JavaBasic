package com.xucg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();

        int n = nums.length;
        int x;
        for(int num:nums){
            x = (num-1) % n;
            nums[x] += n;
        }

        for(int i=0;i<n;i++){
            if (nums[i] <= n) {
                result.add(i+1);
            }
        }

        return result;
    }
}
