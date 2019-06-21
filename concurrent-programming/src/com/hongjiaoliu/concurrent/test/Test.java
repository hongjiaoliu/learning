package com.hongjiaoliu.concurrent.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liuhj
 * @date : 2018/8/8
 * @email : liuhongjiao@weimingedu.com
 */
public class Test {
    public static void main(String[] args) {
        /*DemoHashMap t0 = new DemoHashMap();
        DemoHashMap t1 = new DemoHashMap();
        DemoHashMap t2 = new DemoHashMap();
        DemoHashMap t3 = new DemoHashMap();
        DemoHashMap t4 = new DemoHashMap();
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/

       /* int sshift = 0;
        int ssize = 1;
        int concurrencyLevel = (1<<16)-1;
        System.out.println("concurrencyLevel="+concurrencyLevel);
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
        System.out.println("sshift="+sshift+"-----ssize="+ssize);*/
        /*int cap = 2;
        while (cap < 4){
            cap <<= 1;
            System.out.println("cap:"+cap);
        }
*/
//        testRetry();
        testMap();
    }

//    public static void testRetry(){
////        retry2:
//        for (int i = 0; i < 2; i++) {
//            retry1:
//            for (int j = 0; j < 10; j++) {
//                if(j == 5){
//                    continue retry1;
//                }
//                System.out.println("j:"+j);
//            }
//        }
//    }

    public static void testMap(){
        Map map = new HashMap();
        map.put("abc", "1");
        boolean flag = false;
        if(flag){
            System.out.println(map.size());
        }else{
            System.out.println("2");
        }
    }


}
