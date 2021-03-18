package com.example.thinkinginjava.generic.coffee;

import androidx.annotation.NonNull;

import com.example.thinkinginjava.util.Generator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee>{

    private int size = 0;

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random random = new Random(47);

    public CoffeeGenerator() {}

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Coffee next() {
            size --;
            return CoffeeGenerator.this.next();
        }
    }
}
