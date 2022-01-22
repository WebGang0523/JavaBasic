package com.xucg.sort;

import java.util.Arrays;

public class SimpleInsertSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        simpleInsertSort(arr);
        simpleInsertSort1(arr);
    }

    public static void simpleInsertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i=1;i<arr.length;i++) {
            insertVal = arr[i];
            insertIndex = i-1;

            while (insertIndex>=0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex+1 != i) {
                arr[insertIndex+1] = insertVal;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void simpleInsertSort1(int[] arr){
        for (int i=1;i< arr.length;i++) {
            for(int j=i-1;j>=0 && arr[j] > arr[j+1]; j--) {
                swap(arr,j,j+1);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
