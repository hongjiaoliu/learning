package com.hongjiaoliu.offer;

import java.util.Arrays;

/**
 * Created by liuhj on 2017/12/5.
 * Description : 不修改数组找到重复的数字
 *      在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个数字
 *      是重复的。请找出数组中的任意一个重复的数字，但是不能修改输入的数组。
 *      例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7},那么对应的输出是重复的数字2或者3
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Q3B {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,5,4,3,2,6,7};
        new Q3B().a1(array);
    }

    /**
     * 借助辅助空间，例如第二个数组、或者hash结构，记录数字的出现次数
     * @param array
     */
    private void a1(int[] array){
        int[] referArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            int i2 = referArray[i1];
            if(i2 != 0){
                System.out.println("find repetition number:" + i2);
                continue;
            }
            referArray[i1] = i1;
        }
        System.out.println(Arrays.toString(referArray));
    }

    /**
     * 牺牲时间，换取空间
     * @param array
     */
    private void a2(int[] array){

    }

    private void countRange(int[] array, int value, int begin, int end) {
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            if( (i1 > begin || i1 == begin) && i1 < end ){

            }
        }
    }



}
