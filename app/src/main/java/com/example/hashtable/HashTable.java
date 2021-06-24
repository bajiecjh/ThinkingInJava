package com.example.hashtable;

import java.util.Map;

/**
 * bajie on 2021/6/24 18:13
 */
class HashTable {



    private int hash(Object key) {
        int h;
        return (key == null) ? 0: ((h = key.hashCode()) ^ (h >>> 16)) %
    }
}
