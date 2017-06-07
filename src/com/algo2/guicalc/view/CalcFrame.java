package com.algo2.guicalc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame {

    public static final Font FONT = new Font("SansSerif", Font.PLAIN, 26);
    public static final String[][] BUTTONS = {
            {"(", ")", "C", "<"},
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "=", "+"}};

    private JLabel mLabel;

    public CalcFrame(CalcManager manager) {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);

        mLabel = createLabel();
        addItem(mLabel, grid, 1, 1, 4, 1);

        ActionListener listener = new OnButtonClickListener(manager);
        for (int y=0; y<5; y++) {
            for (int x=0; x<4; x++) {
                JButton button = createButton(BUTTONS[y][x], listener);
                addItem(button, grid, x+1, y+2, 1, 1);
            }
        }
    }

    public void setText(String s) {
        mLabel.setText(s);
    }

    private JLabel createLabel() {
        Dimension d = new Dimension(50, 50);
        JLabel label = new JLabel();
        label.setFont(FONT);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(d);
        label.setMinimumSize(d);
        return label;
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton();
        button.setText(text);
        button.setFont(FONT);
        button.addActionListener(listener);
        return button;
    }

    private void addItem(Component component, GridBagLayout layout, int x, int y, int w, int h) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = 1.0d;
        c.weighty = 1.0d;
        layout.setConstraints(component, c);
        add(component);
    }
}
