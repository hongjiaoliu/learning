package com.hongjiaoliu.offer;

/**
 * Created by liuhj on 2017/12/28.
 * Description : 二维数组中的查找
 * 1   2   8   9
 * 2   4   9   12
 * 4   7   10  13
 * 6   8   11  15
 * 中查找7
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Q4 {

    public static void main(String[] args) {

        int[][] array = new int[4][4];
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{2, 4, 9, 12};
        array[2] = new int[]{4, 7, 10, 13};
        array[3] = new int[]{6, 8, 11, 15};

        int row = array.length;
        int column = array[0].length;

        int targetNum = 70;
        int rowIndex = 0;
        boolean isFind = false;
        while (column >= 0 && rowIndex < row) {
            System.out.println("行：rowIndex = " + rowIndex);
            System.out.println("列：column = " + column);
            int val = array[rowIndex][column - 1];
            if (val == targetNum) {
                isFind = true;
                System.out.println("!!!find targetNum in rowIndex=" + rowIndex + ";column=" + (column - 1));
                break;
            } else if (val > targetNum) {
                --column;
                System.out.println("本元素为" + val + ",比目标数字大，则排除本列，column左移1");
            } else if (val < targetNum) {
                ++rowIndex;
                System.out.println("本元素为" + val + ",比目标数字小，则排除本行，rowIdex下移1");
            }
        }
        if(!isFind){
            System.out.println("Can't find targetNum.");
        }

    }
}
