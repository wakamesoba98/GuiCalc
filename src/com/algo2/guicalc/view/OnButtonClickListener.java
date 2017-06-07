package com.algo2.guicalc.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnButtonClickListener implements ActionListener {

    private CalcManager mManager;

    public OnButtonClickListener(CalcManager c) {
        mManager = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = ((JButton) e.getSource()).getText().trim();
        mManager.appendExpression(text);
    }
}
