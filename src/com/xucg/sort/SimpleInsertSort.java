package com.xucg.sort;

import java.util.Arrays;

public class SimpleInsertSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        simpleInsertSort(arr);
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
}
