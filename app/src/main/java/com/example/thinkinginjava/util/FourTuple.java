package com.example.thinkinginjava.util;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;
    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }
    public String toString() {
        return "(" + first + ", " + second + ", " + third + "," + fourth +")";
    }

}
