package com.hongjiaoliu.offer.topic13;

/**
 * Created by liuhj on 2018/1/16.
 * Description : 剑指Offer面试题13：机器人的运动范围
 * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.请问该机器人能够达到多少格子？
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class RobotRangeArea {

    /**
     * 计算在阈值threshold的rows*cols矩阵下可以行走多少步？
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int moveCount(int threshold, int rows, int cols) {
        // 参数检验
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        // 访问轨迹记录数组
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int count = moveCountCore(threshold,rows,cols,0,0,visited);
        return count;
    }

    public int moveCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        // 检查该方块是否可以步入
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            //再查看相邻的方块是否可以步入
            count = 1 + moveCountCore(threshold, rows, cols, row, col - 1, visited)
                    + moveCountCore(threshold, rows, cols, row + 1, col, visited)
                    + moveCountCore(threshold, rows, cols, row - 1, col, visited)
                    + moveCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    /**
     * 检查是否可以步入该方块
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= threshold) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param number
     * @return
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int threshold = 4;
//        int count = new RobotRangeArea().moveCount(threshold, 15, 4);
//        System.out.println(count);

        int digitSum = new RobotRangeArea().getDigitSum(13);
        System.out.println("行："+digitSum);
        int digitSum1 = new RobotRangeArea().getDigitSum(14);
        System.out.println("列："+digitSum1);
    }


}
