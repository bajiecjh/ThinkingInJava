package com.example.thinkinginjava.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    public static <T>List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for(T item: args) {
            result.add(item);
        }
        return result;
    }
}
