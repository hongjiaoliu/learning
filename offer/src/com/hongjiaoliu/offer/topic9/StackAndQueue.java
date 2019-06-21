package com.hongjiaoliu.offer.topic9;

import java.util.Stack;

/**
 * Created by liuhj on 2018/1/10.
 * Description : 面试题9: 用两个栈实现队列
 * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在对尾部插入节点和在队列头部删除节点功能。
 * Version: V1.0
 * Copyright ©2013-2017 为明学信 京ICP备11027463号
 */
public class StackAndQueue<T> {
    /**
     * 复习  stack的api
     *   empty() : 判断stack是否为空；返回boolean
     *   peek() : 返回在栈顶的元素，但不删除
     *   pop() : 返回在栈顶的元素，并将其在栈中删除
     *   push() : 将一个元素压入栈顶
     *   search(Object o) :  查找某元素在栈中的位置，从1开始
     */

    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public StackAndQueue(Stack stack1, Stack stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    /**
     * 添加新元素到队尾
     * @param item
     */
    public void appendTail(T item){
        this.stack1.push(item);
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T deleteHead(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new RuntimeException("Empty stack!");
        }
        return stack2.pop();
    }

}
