package com.algo2.guicalc.node;

import com.algo2.guicalc.parser.ParseException;

public class Op implements Node {
    private Node left, right;
    private char op;
    public Op(Node l, char o, Node r) {
        left = l;
        op = o;
        right = r;
    }
    @Override
    public void show() {
        System.out.print("(");
        if(left != null) left.show();
        System.out.print(op);
        if(right != null) right.show();
        System.out.print(")");
    }
    @Override
    public void rpn() {
        if(left != null) left.rpn();
        System.out.print(" ");
        if(right != null) right.rpn();
        System.out.print(" ");
        System.out.print(op);
        System.out.print(" ");
    }
    @Override
    public double calc() throws ParseException {
        switch (op) {
            case '+': return left.calc() + right.calc();
            case '-': return left.calc() - right.calc();
            case '*': return left.calc() * right.calc();
            case '/': return left.calc() / right.calc();
            default:  throw new ParseException();
        }
    }
}
