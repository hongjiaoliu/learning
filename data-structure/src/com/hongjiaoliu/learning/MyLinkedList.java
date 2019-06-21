package com.hongjiaoliu.learning;

/**
 * Linked List 学习
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * @author liuhongjao
 * @date 2018/11/22 14:29
 */

public class MyLinkedList {

	private Node head = null;

	/**
	 * 查找指定value的节点
	 *
	 * @param value
	 * @return
	 */
	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.data != value) {
			p = p.next;
		}
		return p;
	}

	/**
	 * 查找指定位置的节点
	 *
	 * @param index
	 * @return
	 */
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && index != pos) {
			p = p.next;
			pos++;
		}
		return p;
	}

	//无头结点
	//表头部插入
	//这种操作将于输入的顺序相反，逆序
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		insertToHead(newNode);
	}

	public void insertToHead(Node newNode) {
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
	}

	//顺序插入
	//链表尾部插入
	public void insertTail(int value) {
		Node newTail = new Node(value, null);
		if(head == null){
			head = newTail;
			return;
		}

		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = newTail;
	}

	/**
	 * 在指定节点后插入
	 *
	 * @param p
	 * @param value
	 */
	public void insertAfter(Node p, int value) {
		Node newNode = new Node(value, null);
		insertAfter(p, newNode);
	}

	public void insertAfter(Node p, Node newNode) {
		Node next = p.next;
		newNode.next = next;
		p.next = newNode;
	}

	/**
	 * 在指定节点前插入
	 *
	 * @param p
	 * @param value
	 */
	public void insertBefore(Node p, int value) {
		Node prevNode = findPrevNode(p);
		insertBefore(prevNode, new Node(value, null));
	}

	private Node findPrevNode(Node p) {
		Node prevNode = head;
		while (prevNode.next != p) {
			prevNode = head.next;
		}
		return prevNode;
	}

	public void insertBefore(Node prevNode, Node newNode) {
		Node p = prevNode.next;
		newNode.next = p;
		prevNode.next = newNode;
	}

	/**
	 * 删除指定Node
	 *
	 * @param p
	 */
	public void deleteByNode(Node p) {
		Node prevNode = findPrevNode(p);
		if (prevNode == null) {
			System.out.println("没有找到前节点，证明为头节点");
			head = p.next;
			return;
		}
		prevNode.next = p.next;
	}

	/**
	 * 删除指定value的节点
	 *
	 * @param value
	 */
	public void deleteByValue(int value) {
		Node p = findByValue(value);
		if (p != null) {
			deleteByNode(p);
		}
	}

	/**
	 * 打印整个链表
	 */
	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.println(p.data + "");
			p = p.next;
		}
		System.out.println();
	}

	//判断两个链表是否完全一致
	public boolean TFResult(Node left, Node right) {
		Node l = left;
		Node r = right;
		while (l != null && r != null){
			if(l.data == r.data){
				l = l.next;
				r = r.next;
				continue;
			}else{
				break;
			}
		}
		if(l == null && r == null){
			System.out.println("两个链表一致");
			return true;
		}else{
			System.out.println("两个链表不一致");
			return false;
		}
	}

	//　判断是否为回文
	public boolean palindrome() {
		if (head == null) {
			return false;
		}

		if (head.next == null) {
			System.out.println("就一个节点");
			return true;
		}

		Node p = head;
		Node q = head;

		while (q.next != null && q.next.next != null) {
			p = p.next;
			q = q.next.next;
		}
		System.out.println("找到中间节点：" + p.data);
		Node leftLink = null;//左链
		Node rightLink = null;//右链
		if (q.next == null) {
			// 总节点数量为奇数，且p一定为中间节点
			System.out.println("总节点数量为奇数，且p一定为中间节点");
			rightLink = p.next;
			leftLink = inverseLinkList(p).next;
			System.out.println("左边第一个节点"+leftLink.data);
			System.out.println("右边第一个节点"+rightLink.data);
		} else {
			// p,q 均为中点
			rightLink = p.next;
			leftLink = inverseLinkList(p);
		}
		return TFResult(leftLink,rightLink);
	}

	//无头结点的链表翻转
	public Node inverseLinkList(Node p) {
		Node pre = null;
		Node r = head;
		Node next = null;
		while( r != p){
			next = r.next;
			r.next = pre;
			pre = r;
			r = next;
		}
		r.next = pre;
		return r;
	}

	public static class Node {
		private int data;
		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}
	}

	public static void main(String[] args) {

		MyLinkedList link = new MyLinkedList();
//		int data[] = {1};
		//int data[] = {1,2};
		//int data[] = {1,2,3,1};
		int data[] = {1,2,5};
		//int data[] = {1,2,2,1};
//		 int data[] = {1,2,5,2,1};
//		int data[] = {1, 2, 5, 3, 1};

		for (int i = 0; i < data.length; i++) {
			link.insertTail(data[i]);
		}
		 link.printAll();


		System.out.println("打印原始:");
		link.printAll();
		if (link.palindrome()) {
			System.out.println("回文");
		} else {
			System.out.println("不是回文");
		}
	}
}
