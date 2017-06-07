package com.algo2.guicalc.view;

import com.algo2.guicalc.node.Node;
import com.algo2.guicalc.parser.ParseException;
import com.algo2.guicalc.parser.Parser;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CalcManager {

    public static final String TITLE = "JavaCC Calc";
    public static final String SYNTAX_ERROR = "SYNTAX ERROR";
    public static final String FORMAT_ERROR = "FORMAT ERROR";
    public static final String SOLVE_ERROR = "SOLVE ERROR";
    public static final Dimension DIMENSION = new Dimension(240, 320);

    private CalcFrame mFrame;
    private StringBuilder mExpr;

    public CalcManager() {
        mExpr = new StringBuilder();
    }

    public void show() {
        LookAndFeel.changeLookAndFeel();
        mFrame = createFrame();
        mFrame.setVisible(true);
    }

    public void appendExpression(String s) {
        if ("=".equals(s)) {
            parse(mExpr.toString() + "=");
        } else {
            if ("C".equals(s)) {
                mExpr.delete(0, mExpr.length());
            } else if ("<".equals(s)) {
                if (mExpr.length() > 0) {
                    mExpr.deleteCharAt(mExpr.length() - 1);
                }
            } else {
                mExpr.append(s);
            }
            mFrame.setText(mExpr.toString());
        }
    }

    private void parse(String s) {
        InputStream stream = new ByteArrayInputStream(s.getBytes());
        Parser parser = new Parser(stream);
        try {
            Node node = parser.start();
            output(node);
        } catch (ParseException e) {
            e.printStackTrace();
            mFrame.setText(SYNTAX_ERROR);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            mFrame.setText(FORMAT_ERROR);
        }
    }

    private void output(Node tree) {
        mExpr.delete(0, mExpr.length());
        String solve;
        try {
            solve = String.valueOf(tree.calc());
            mExpr.append(solve);
            mFrame.setText(mExpr.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            mFrame.setText(SOLVE_ERROR);
        }
    }

    private CalcFrame createFrame() {
        CalcFrame frame = new CalcFrame(this);
        frame.setTitle(TITLE);
        frame.setMinimumSize(DIMENSION);
        frame.setSize(DIMENSION);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }
}