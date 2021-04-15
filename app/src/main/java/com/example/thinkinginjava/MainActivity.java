package com.example.thinkinginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.Array.GenericArray;
import com.example.LinkedList.SingleLinkedList;
import com.example.thinkinginjava.generic.BasicBounds;
import com.example.thinkinginjava.generic.CountedObject;
import com.example.thinkinginjava.generic.CreatorGeneric;
import com.example.thinkinginjava.generic.FactoryConstraint;
import com.example.thinkinginjava.generic.Generators;
import com.example.thinkinginjava.generic.GenericVarargs;
import com.example.thinkinginjava.generic.LinkedStack;
import com.example.thinkinginjava.generic.Store;
import com.example.thinkinginjava.generic.coffee.Coffee;
import com.example.thinkinginjava.generic.coffee.CoffeeGenerator;
import com.example.thinkinginjava.util.BasicGenerator;
import com.example.thinkinginjava.util.Generator;
import com.example.thinkinginjava.util.Tuple;
import com.example.thinkinginjava.util.TwoTuple;
import com.example.Array.Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text);
        linkedStackTest();
        coffeeGenerator();
        genericVarargs();
        generators();
        basicGenerator();
        tuple();
        store();    // 构建复杂模型
        FactoryConstraint.test();   // 显示工厂
        CreatorGeneric.test();      // 模板方法
        BasicBounds.test();         // 边界
        spent(Array.test());
        GenericArray.test();
        SingleLinkedList.test();
    }

    private void linkedStackTest() {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for(String s : "This is a string".split(" ")) {
            linkedStack.push(s);
        }
        String s;
        while((s = linkedStack.pop()) != null) {
            tv.setText(tv.getText().toString() + " " +s);
        }
    }

    private void coffeeGenerator() {
        CoffeeGenerator gen = new CoffeeGenerator();
        spentLine();
        for(int i = 0; i < 5; i ++) {
            spent(gen.next().toString());
        }
        spentLine();
        // CoffeeGenerator实现了Iterable，可以直接在循环语句中使用
        for(Coffee c : new CoffeeGenerator(5)) {
            spent(c.toString());
        }
    }

    private void genericVarargs() {
        List<String> ls = GenericVarargs.makeList("A", "B", "C");
        spentLine();
        spent(ls.toString());
    }

    private void generators() {
        Collection<Coffee> coffees = Generators.fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        spentLine();
        for(Coffee c : coffees) {
            spent(c.toString());
        }
    }

    private void basicGenerator() {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        spentLine();
        for(int i = 0; i < 5; i ++) {
            spent(gen.next().toString());
        }
    }

    private void tuple() {
        spentLine();
        TwoTuple<String, Integer> ttsi = f();
        spent(ttsi.toString());
    }

    TwoTuple<String ,Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    private void store() {
        spentLine();
        spent(new Store(1, 2, 2).toString());
    }

    private void spentLine() {
        tv.setText(tv.getText().toString() + "\n");
    }

    private void spent(String s) {
        tv.setText(tv.getText().toString() + s+" ");
    }
}