package com.hongjiaoliu.offer.topic8;

/**
 * Created by liuhj on 2018/1/10.
 * Description : 剑指Offer面试题8：二叉树的下一个节点
 * 题目：给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 思路如下：
 * 判断该节点是否有右孩子？若有，则下一个节点是右孩子节点的最左边的孩子节点。
 * 反之，判断其是否是其父节点的左孩子？若是，则下一个节点就是其父节点
 * 反之，向上寻找其父节点，直到找到父节点是其父节点的左孩子为此，此时，下一个节点为最后那个父节点。
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class FindBinaryTreeNextNode {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;
        node5.left = node8;
        node5.right = node9;
        node8.parent = node5;
        node9.parent = node5;

        TreeNode treeNode = findTreeNextNode(node7);
        if (treeNode == null) {
            System.out.println("不存在下一个节点!");
            return;
        }
        System.out.println(treeNode.value);
    }

    /**
     * 查找二叉树
     *
     * @param targetTreeNode
     * @return
     */
    private static TreeNode findTreeNextNode(TreeNode targetTreeNode) {
        //如果有右子树，则返回其右子树的最左节点
        if (targetTreeNode.right != null) {
            TreeNode right = targetTreeNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        //如果无右子树，且自己为左子节点，则返回其父节点
        if (targetTreeNode.right == null && targetTreeNode.parent.left == targetTreeNode) {
            return targetTreeNode.parent;
        }

        //如果无右子树，且自己为右子节点
        if (targetTreeNode.right == null && targetTreeNode.parent.right == targetTreeNode) {
            TreeNode parent = targetTreeNode.parent;
            if (parent.parent == null) {//找到了根节点
                return null;
            }
            //如果查找的节点的父节点为右子节点，则继续往上查找,节点为其父节点的左子节点，则该节点的父节点就是查找结果；
            //                                                 节点为其父节点的右子节点，则继续往上找
            while (parent.parent.right == parent) {
                parent = parent.parent;
                if (parent.parent == null) { // 找到了根节点，返回null
                    return null;
                }
                if (parent.parent.left == parent) {
                    return parent.parent;
                }
            }
        }
        return null;
    }

}
