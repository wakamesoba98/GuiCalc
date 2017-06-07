package com.algo2.guicalc.node;

import com.algo2.guicalc.parser.ParseException;

public class Num implements Node {
    private double value;
    public Num(double n) {
        value = n;
    }
    @Override
    public void show() {
        System.out.print(value);
    }
    @Override
    public void rpn() {
        System.out.print(value);
    }
    @Override
    public double calc() throws ParseException {
        return value;
    }
}