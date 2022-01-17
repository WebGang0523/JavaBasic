package com.xucg.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        int tmp;
        boolean flag;
        for (int i=0;i<arr.length-1;i++) {
            flag = true;
            for (int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }

            if (flag) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}
