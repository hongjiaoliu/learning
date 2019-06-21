package com.hongjiaoliu.learning.lesson20;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap测试类
 *
 * @author liuhongjao
 * @date 2019/3/7 15:04
 */

public class TestLinkedHashMap {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(10, 0.75F, true);
		map.put(3, 11);
		map.put(1, 12);
		map.put(5, 23);
		map.put(2, 22);

		map.put(3, 26);
		map.get(5);

		for (Map.Entry entry : map.entrySet()) {
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
	}
}
