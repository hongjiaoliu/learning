package com.hongjiaoliu.offer.topic12;

/**
 * Created by liuhj on 2018/1/11.
 * Description : 剑指Offer面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中间向左、右、上、下移动一格。如果一* 条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class MatrixPath {
    public static void main(String[] args) {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] findChars = "bcced".toCharArray();
        boolean exists = new MatrixPath().isExists(matrix, findChars, 3, 4);
        System.out.println(exists);
    }
    /**
     * 举例分析
     * 　　例如在下面的3*4的矩阵中包含一条字符串”bcced”的路径。但矩阵中不包含字符串“abcb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二格子之后，路径不能再次进入这个格子。
     * a b c e
     * s f c s
     * a d e e
     */

    private boolean isExists(char[] matrix, char[] findChars, int rows, int cols) {
        // 辅助矩阵，判断是否查找过
        // 变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // 记录结果的数组，
        int[] pathLength = {0};
        // 以每一个点为起始进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, findChars, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前处理的行号
     * @param col        当前处理的列号
     * @param pathLength 已经处理的str中字符个数
     * @return 是否找到 true是，false否
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, boolean[] visited,
                                       int row, int col, int[] pathLength) {

        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hasPath = false;

        // 判断位置是否合法
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0]++;

            // 按左上右下进行回溯
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hasPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        return hasPath;
    }

}
