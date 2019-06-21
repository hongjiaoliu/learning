package com.hongjiaoliu.offer;

/**
 * Created by liuhj on 2017/12/28.
 * Description : 重建二叉树
 * 前序遍历：1,2,4,7,3,5，6,8
 * 中序遍历：4,7,2,1,5,3,8,6
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class BinaryTree {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] minOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        int ps = 0;
        int pe = preOrder.length - 1;
        int is = 0;
        int ie = minOrder.length - 1;
        TreeNode node = loop(preOrder, ps, pe, minOrder, is, ie);
        System.out.println(node.value);
    }

    private static TreeNode loop(int[] preOrder, int ps, int pe, int[] minOrder, int is, int ie) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        int currentRootNodeValue = preOrder[ps];
        //构建当前的根节点，并赋值
        TreeNode root = new TreeNode();
        root.value = currentRootNodeValue;
        //在中序遍历中查找当前根节点的位置
        int index = is;
        while (index <= ie && minOrder[index] != currentRootNodeValue) {
            index++;
            //值匹配后，需要跳出循环
            if(minOrder[index] == currentRootNodeValue){
                break;
            }
        }
        if (index > ie) {
            throw new RuntimeException("Can't find number.");
        }
        root.left = loop(preOrder, ps + 1, ps + index - is, minOrder, is, index - 1);
        root.right = loop(preOrder, ps + index - is + 1, pe, minOrder, index + 1, ie);
        return root;
    }
}
