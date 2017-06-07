package com.algo2.guicalc.view;

import javax.swing.*;

public class LookAndFeel {
    public static void changeLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException
                | InstantiationException
                | UnsupportedLookAndFeelException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
