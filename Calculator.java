package com.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numbersButton = new JButton[10];
    JButton[] functionButton = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    JPanel panel;

    double num1 = 0;
    double num2 = 0;
    double result;
    char operator;


    Calculator() {
        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setLayout(null);


        textField = new JTextField();
        textField.setBounds(50, 25, 300, 30);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        clrButton = new JButton("CLEAR");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numbersButton[i] = new JButton(String.valueOf(i));
            numbersButton[i].addActionListener(this);
            numbersButton[i].setFocusable(false);

        }
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbersButton[1]);
        panel.add(numbersButton[2]);
        panel.add(numbersButton[3]);
        panel.add(addButton);
        panel.add(numbersButton[4]);
        panel.add(numbersButton[5]);
        panel.add(numbersButton[6]);
        panel.add(subButton);
        panel.add(numbersButton[7]);
        panel.add(numbersButton[8]);
        panel.add(numbersButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbersButton[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator cal = new Calculator();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbersButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {

            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}
