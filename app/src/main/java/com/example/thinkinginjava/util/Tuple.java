package com.example.thinkinginjava.util;

public class Tuple {
    public static <A, B>TwoTuple<A, B> tuple(A first, B second) {
        return new TwoTuple<>(first, second);
    }
    public static <A, B, C>ThreeTuple<A, B, C> tuple(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }
    public static <A, B, C, D>FourTuple<A, B, C, D> tuple(A first, B second, C third, D forth) {
        return new FourTuple<>(first, second, third, forth);
    }
}
