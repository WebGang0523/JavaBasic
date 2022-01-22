package com.xucg.algo;

/**
 * 异或的使用
 * 无进位相加
 */
public class XOR {

    public static void main(String[] args)
    {
        int arr2[] = {1,1,2,2,3,3,4,5};
        printOddTimesNum2(arr2);
        int[] arr1 = {1,1,2,2,2,3,3};
        printOddTimesNum1(arr1);
        swap(1,2);
    }

    /**
     * 有两个数出现奇数次
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr)
    {
        int eor = 0,onlyOne = 0;
        for(int cur : arr) {
            eor ^= cur;
        }

        // eor = a ^ b
        // 因为 a 和 b 不一样 eor != 0
        // 取出 eor 最右边为1的位，说明这一位的 a 和 b 不一样
        // 1010 => 0101 => 0110 => 0010
        int rightOne = eor & (~eor + 1);
        for (int cur:arr) {
            if ((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }

        System.out.println("两个数分别是："+onlyOne+","+ (eor^onlyOne));
    }

    /**
     * 有一个数出现奇数次
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr)
    {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        System.out.println("一个数是："+eor);
    }

    /**
     * 交换
     * @param a
     * @param b
     */
    public static void swap(int a,int b)
    {
        System.out.println("交换前：a="+a+",b="+b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("交换后：a="+a+",b="+b);
    }


}
