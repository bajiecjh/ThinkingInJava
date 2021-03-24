package com.example.thinkinginjava.generic;

import android.graphics.Color;

interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;
    Colored(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
    T item;
    ColoredDimension(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    Color colored() {
        return item.getColor();
    }
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
    T item;
    Solid(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
    Color colored() {
        return item.getColor();
    }
    int getX() {
        return item.x;
    }
    int getY() {
        return item.y;
    }
    int getZ() {
        return item.z;
    }
    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void test() {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.colored();
        solid.getY();
        solid.weight();
    }
}
