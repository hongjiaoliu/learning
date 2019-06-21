package com.hongjiaoliu.offer;

/**
 * Created by liuhj on 2017/12/28.
 * Description : 字符串, 替换空格，请实现一个函数，把字符串中的空格替换成"%20",
 * 例如：输入“We are Happy.”则输出“We%20are%20happy”
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Q5 {
    public static void main(String[] args) {
//        String s1 = "hello world";
//        String s2 = "hello world";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.length());
//
        String str = "we are happy";
        int length = str.length();
        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                blankCount++;
            }
        }
        System.out.println("原字符串长度为：" + length);
        System.out.println("空格数量为：" + blankCount);
        int targetStrLength = length + blankCount * 2;
        System.out.println("扩展字符串长度为：" + targetStrLength);
        char[] targetChars = new char[targetStrLength];
        char[] sourceChars = str.toCharArray();
        int oldIndex = length - 1;
        int newIndex = targetStrLength - 1;

        while (oldIndex != -1) {
            System.out.println("oldIndex:" + oldIndex + ";newIndex:" + newIndex);
            char sourceChar = sourceChars[oldIndex];
            if (sourceChar != ' ') {
                targetChars[newIndex] = sourceChar;
            } else {
                targetChars[newIndex] = '0';
                targetChars[--newIndex] = '2';
                targetChars[--newIndex] = '%';
            }
            oldIndex--;
            newIndex--;
            System.out.println(String.valueOf(targetChars));
        }

    }
}
