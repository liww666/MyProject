package com.sunyard.myproject.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/25.
 */
public class TestLRUCache {
    public static void main(String[] args){
        final int cacheSize=5;
        Map<Integer,String> cache=new LinkedHashMap<Integer, String>((int) Math.ceil(cacheSize / 0.75f) + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>cacheSize;
            }
//            @Override
//            public String toString() {
//                StringBuilder sb = new StringBuilder();
//                for (Map.Entry<Integer,String> entry:entrySet()) {
//                    sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
//                }
//                return sb.toString();
//            }
        };
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        cache.put(4,"d");
        cache.put(5,"e");
        System.out.println(cache.toString());
        cache.put(6, "66");
        cache.get(2);
        cache.put(7, "77");
        cache.get(4);
        System.out.println(cache.toString());

        System.out.println();
        System.out.println("===========================LRU 链表实现===========================");
        LRUCache1<Integer, String> lru = new LRUCache1(5);
        lru.put(1, "11");
        lru.put(2, "11");
        lru.put(3, "11");
        lru.put(4, "11");
        lru.put(5, "11");
        System.out.println(lru.toString());
        lru.put(6, "66");
        lru.get(2);
        lru.put(7, "77");
        lru.get(4);
        System.out.println(lru.toString());
        System.out.println();
    }
}
