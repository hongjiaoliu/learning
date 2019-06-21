package com.hongjiaoliu.offer;

import com.hunter.offer.entity.Node;

import java.util.Stack;

/**
 * Created by liuhj on 2017/12/28.
 * Description : 链表的反转
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class Q6 {
    public static void main(String[] args) {
        Node node = buildNodes();
//        printListByStack(node);
        printListRecuisively(node);
    }

    private static void printListByStack(Node node){
        Stack stack = new Stack();
        Node targetNode = node;
        do {
            stack.push(targetNode);
            targetNode = targetNode.getNext();
        } while (targetNode != null);

        /*for (int i = 0; i < stack.size(); i++) {
            Object o = stack.pop();
            --i;
            System.out.println(((Node) o).getKey());
        }*/

        while (!stack.isEmpty()){
            Node peek = (Node)stack.peek();
            System.out.println(peek.getKey());
            stack.pop();
        }
    }

    private static void printListRecuisively(Node node){
        Node next = node.getNext();
        if (next != null) {
            printListRecuisively(next);
        }
        System.out.println(node.getKey());
    }

    private static Node buildNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return node1;
    }




}
