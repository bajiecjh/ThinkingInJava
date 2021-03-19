package com.example.thinkinginjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.thinkinginjava.generic.Generators;
import com.example.thinkinginjava.generic.GenericVarargs;
import com.example.thinkinginjava.generic.LinkedStack;
import com.example.thinkinginjava.generic.coffee.Coffee;
import com.example.thinkinginjava.generic.coffee.CoffeeGenerator;

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

    private void spentLine() {
        tv.setText(tv.getText().toString() + "\n");
    }

    private void spent(String s) {
        tv.setText(tv.getText().toString() + s+" ");
    }
}