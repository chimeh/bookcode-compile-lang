package com.designpatterns.chp2;

import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Swing Observer implementation
 */
public class SwingObserverExample {
    JFrame frame;

    public static void main(String [] args){
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Should I do it");
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        frame.getContentPane().add(BorderLayout.CENTER, button);
        //set frame properties here
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    class AngelListener implements ActionListener {
        private org.slf4j.Logger logger = LoggerFactory.getLogger(AngelListener.class);

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("Don't do it, you might regret it!");
        }
    }

    class DevilListener implements ActionListener {
        private org.slf4j.Logger logger = LoggerFactory.getLogger(DevilListener.class);

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.info("Come on, do it!");
        }
    }
}
