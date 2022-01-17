package com.xucg.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        int minIndex;
        int minValue;

        for (int i=0;i<arr.length-1;i++) {
            minIndex = i;
            minValue = arr[i];

            for (int j=i+1;j<arr.length;j++) {
                if (minValue > arr[j]) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
