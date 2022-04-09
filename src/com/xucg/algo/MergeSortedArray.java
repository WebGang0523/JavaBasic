package com.xucg.algo;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int[] res = MergeSortedArray.merge(num1,3,num2,3);
        System.out.println(Arrays.toString(res));
    }

//    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
//        for (int i=0;i<n;i++) {
//            nums1[m+i] = nums2[i];
//        }
//        Arrays.sort(nums1);
//
//        return nums1;
//    }

//    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
//        int k = m + n;
//        int[] temp = new int[k];
//
//        for(int index=0,nums1Index=0,nums2Index=0;index<k;index++) {
//            if (nums1Index >= m) {
//                temp[index] = nums2[nums2Index++];
//            } else if (nums2Index >= n){
//                temp[index] = nums1[nums1Index++];
//            }else if (nums1[nums1Index] < nums2[nums2Index]) {
//                temp[index] = nums1[nums1Index++];
//            }else{
//                temp[index] = nums2[nums2Index++];
//            }
//        }
//
//        for (int i = 0;i<k;i++) {
//            nums1[i] = temp[i];
//        }
//
//        return nums1;
//    }

    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        int k = m + n;
        for(int index=k-1,nums1Index=m-1,nums2Index=n-1;index>=0;index--) {
            if (nums2Index < 0) {
                break;
            }else if (nums1Index < 0){
                nums1[index] = nums2[nums2Index--];
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index--];
            }else{
                nums1[index] = nums2[nums2Index--];
            }
        }

        return nums1;
    }
}
