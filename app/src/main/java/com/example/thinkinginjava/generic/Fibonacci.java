package com.example.thinkinginjava.generic;

import com.example.thinkinginjava.util.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    @Override
    public Integer next() {
        return null;
    }

    private int fib(int n) {
        if(n < 2) return 1;
        return (n-2) +fib(n-1);
    }
}
