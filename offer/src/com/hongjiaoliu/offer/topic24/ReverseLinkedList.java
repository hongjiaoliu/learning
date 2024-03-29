package com.hongjiaoliu.offer.topic24;

/**
 * 反转链表
 *
 * @author liuhongjao
 * @date 2019/7/18 13:18
 */

public class ReverseLinkedList {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// 1 - > 2 - > 3 - > 4
	public Node operate(Node head) {
		if(head == null){
			return head;
		}
		// null
		// 1
		// 2
		// 3
		// 4
		Node pre = null;// 上一个节点
		// 1
		// 2
		// 3
		// 4
		Node cur = head;		// 当前节点

		// 2
		Node next = cur.next; 		// 下一节点
		// 当前节点为null,证明位于尾节点

		// cur = 1
		// cur = 2
		// cur = 3
		// cur = 4
		while ( cur != null){
			// 1-> null
			// 2 -> 1
			// 3 - > 2 - > 1
			// 4 - > 3 - > 2 -> 1
			cur.next = pre;
			// pre = 1
			// pre = 2
			// pre = 3
			// pre = 4
			pre = cur;
			// cur = 2
			// cur = 3
			// cur = 4
			// cur = null
			cur = next;
			if(cur != null){
				// next = 3
				// next = 4
				// next = null
				next = cur.next;
			}
		}
		return pre;
	}


}
