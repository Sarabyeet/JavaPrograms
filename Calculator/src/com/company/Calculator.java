package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;

    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton delButton, clrButton, decButton, eqlButton, negButton;

    JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    private final Font calcFont = new Font("Convection", Font.BOLD, 30);

    Calculator() {

        // ************ Display **************************
        display = new JTextField();
        display.setBounds(20, 20, 440, 100);
        display.setFont(calcFont);
        display.setEditable(false);

        // *********** Function Buttons *******************

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = delButton;
        functionButton[5] = clrButton;
        functionButton[6] = decButton;
        functionButton[7] = eqlButton;
        functionButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(calcFont);
            functionButton[i].setFocusable(false);
        }

        // ************ Number Buttons ******************

        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(calcFont);
            numberButton[i].setFocusable(false);
        }

        // ************** Panel *************************

        panel = new JPanel();
        panel.setBounds(20,130,440,500);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(divButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(mulButton);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(subButton);

        panel.add(negButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(addButton);


        // ************ Del, clear and negative *************
        delButton.setBounds(20,640,130,60);
        clrButton.setBounds(160,640,130,60);
        eqlButton.setBounds(300,640,160,60);

        // ************ Setting up the frame ****************
        this.setTitle("Calculator 🧮");
        this.setSize(500, 760);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // *********** Adding to Frame **********************
        this.add(clrButton);
        this.add(eqlButton);
        this.add(delButton);
        this.add(display);
        this.add(panel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButton[i]){
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            if (!display.getText().contains(".")) {
                display.setText(display.getText().concat("."));
            }
        }

        // ********** Functionality for Operator buttons ****************
        if (e.getSource()== addButton){
            num1= Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource()== subButton){
            num1= Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource()== divButton){
            num1= Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource()== mulButton){
            num1= Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == negButton){
            if(!display.getText().equals("")){
                double temp = Double.parseDouble(display.getText());
                temp *= -1;
                display.setText(String.valueOf(temp));
            }
        }

        // ************ Actual Operations **************************
        if(e.getSource() == eqlButton){
            num2 = Double.parseDouble(display.getText());

            switch (operator){
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '/' -> result = num1 / num2;
                case '*' ->result = num1 * num2;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }

        // ************** Clear and delete Button *********************
        if (e.getSource() == clrButton){
            display.setText("");
        }
        if(e.getSource()==delButton) {
            String string = display.getText();
            display.setText(string.substring(0,string.length()-1)); // SubString method
        }
    }
}
