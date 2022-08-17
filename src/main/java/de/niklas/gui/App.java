package de.niklas.gui;

import de.niklas.Playfield;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    boolean input = false;
    JFrame frame = new JFrame();
    JButton buttonTopLeft = new JButton(" ");
    JButton buttonTopMiddle = new JButton(" ");
    JButton buttonTopRight = new JButton(" ");
    JButton buttonMiddleLeft = new JButton(" ");
    JButton buttonMiddle = new JButton(" ");
    JButton buttonMiddleRight = new JButton(" ");
    JButton buttonBottomLeft = new JButton(" ");
    JButton buttonBottomMiddle = new JButton(" ");
    JButton buttonBottomRight = new JButton(" ");
    JLabel status = new JLabel();
    Playfield field = new Playfield();

        public void start(){

            buttonTopLeft.setBounds(20,60,100,100);
            buttonTopMiddle.setBounds(140,60,100,100);
            buttonTopRight.setBounds(260,60,100,100);
            buttonMiddleLeft.setBounds(20,180,100,100);
            buttonMiddle.setBounds(140,180,100,100);
            buttonMiddleRight.setBounds(260,180,100,100);
            buttonBottomLeft.setBounds(20,300,100,100);
            buttonBottomMiddle.setBounds(140,300,100,100);
            buttonBottomRight.setBounds(260,300,100,100);
            status.setBounds(20,20,360,20);

            buttonTopLeft.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!input) {
                        field.set(0, 0, 1);
                        setInput(true);
                    }
                }
            });

            buttonTopMiddle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(1, 0, 1);
                        setInput(true);
                    }
                }
            });

            buttonTopRight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(2, 0, 1);
                        setInput(true);
                    }
                }
            });
            buttonMiddleLeft.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(0, 1, 1);
                        setInput(true);
                    }
                }
            });
            buttonMiddle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(1, 1, 1);
                        setInput(true);
                    }
                }
            });
            buttonMiddleRight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(2, 1, 1);
                        setInput(true);
                    }
                }
            });
            buttonBottomLeft.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(0, 2, 1);
                        setInput(true);
                    }
                }
            });
            buttonBottomMiddle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(1, 2, 1);
                        setInput(true);
                    }
                }
            });
            buttonBottomRight.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!input) {
                        field.set(2, 2, 1);
                        setInput(true);
                    }
                }
            });

            frame.add(buttonTopLeft);
            frame.add(buttonTopMiddle);
            frame.add(buttonTopRight);
            frame.add(buttonMiddleLeft);
            frame.add(buttonMiddle);
            frame.add(buttonMiddleRight);
            frame.add(buttonBottomLeft);
            frame.add(buttonBottomMiddle);
            frame.add(buttonBottomRight);
            frame.add(status);


            frame.setSize(400,460);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void load(Playfield playfield){
            field = playfield;
            buttonTopLeft.setText(String.valueOf(playfield.get(0,0)));
            buttonTopMiddle.setText(String.valueOf(playfield.get(1,0)));
            buttonTopRight.setText(String.valueOf(playfield.get(2,0)));
            buttonMiddleLeft.setText(String.valueOf(playfield.get(0,1)));
            buttonMiddle.setText(String.valueOf(playfield.get(1,1)));
            buttonMiddleRight.setText(String.valueOf(playfield.get(2,1)));
            buttonBottomLeft.setText(String.valueOf(playfield.get(0,2)));
            buttonBottomMiddle.setText(String.valueOf(playfield.get(1,2)));
            buttonBottomRight.setText(String.valueOf(playfield.get(2,2)));
        }

    public boolean isInput() {
        return input;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    public void setStatus(String text){
            status.setText(text);
    }
}
