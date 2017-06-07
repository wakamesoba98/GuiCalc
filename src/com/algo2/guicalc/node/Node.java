package com.algo2.guicalc.node;

import com.algo2.guicalc.parser.ParseException;

public interface Node {
    void show();
    void rpn();
    double calc() throws ParseException;
}