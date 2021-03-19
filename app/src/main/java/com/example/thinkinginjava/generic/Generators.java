package com.example.thinkinginjava.generic;

import com.example.thinkinginjava.util.Generator;

import java.util.Collection;

/**
 * bajie on 2021/3/19 15:39
 */
public class Generators {
    // 定义泛型方法，将泛型参数列表置于返回值之前
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for(int i = 0; i < n; i ++) {
            coll.add(gen.next());
        }
        return coll;
    }

}
