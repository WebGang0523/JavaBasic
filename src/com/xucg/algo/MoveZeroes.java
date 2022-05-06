package com.xucg.algo;

import java.util.Arrays;

/**
 * 移动0
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {4,0,1,0,3,12,0};
        MoveZeroes.solution(arr);
    }

    public static void solution(int[] nums)
    {
        int j = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) continue;
            if (i == j) {
                j++;
                continue;
            }
            nums[j++] = nums[i];
        }

        for (int i=j;i< nums.length;i++){
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
