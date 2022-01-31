package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    private final HashMap<String, String> loginInfo;

    JFrame login;
    JButton loginBtn;
    JButton resetBtn;

    JTextField userName;
    JPasswordField userPassword;

    JLabel userLabel;
    JLabel passwordLabel;
    JLabel messageLabel;

    JPanel buttonsPanel;

    Font myFont = new Font("Convection", Font.BOLD, 30);

    LoginPage(HashMap <String,String> loginInfoOriginal){

        // ************** HashMap copy ***************
        loginInfo = new HashMap<>(loginInfoOriginal);

        // ************** Labels ***************
        userLabel = new JLabel("User name : ");
        passwordLabel = new JLabel(" Password : ");

        userLabel.setFont(myFont);
        passwordLabel.setFont(myFont);

        messageLabel = new JLabel( /* "This is test" */ );
        messageLabel.setFont(myFont);

        // ************** Text and password Fields ***************
        userName = new JTextField();
        userName.setPreferredSize(new Dimension(450,35));
        userName.setFont(new Font("Convection", Font.PLAIN, 20));

        userPassword = new JPasswordField();
        userPassword.setPreferredSize(new Dimension(450,35));
        userPassword.setFont(new Font("Convection", Font.PLAIN, 20));


        // ************** Buttons ***************

        loginBtn = new JButton("LOGIN");
        resetBtn = new JButton("RESET");

        loginBtn.setFont(myFont);
        resetBtn.setFont(myFont);

        loginBtn.setFocusable(false);
        resetBtn.setFocusable(false);

        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        // ************** Panel for Login and reset button ***************

        buttonsPanel = new JPanel();
        // buttonsPanel.setBackground(Color.red);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
        buttonsPanel.setPreferredSize(new Dimension(665,50));

        // Adding to panel
        buttonsPanel.add(loginBtn);
        buttonsPanel.add(resetBtn);

        // ************** Login Window (Frame)***************

        login = new JFrame("Login");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setLayout(new FlowLayout(FlowLayout.CENTER, 10,25));
        login.setSize(700,350);
        login.setLocationRelativeTo(null);

        // ************** Adding to Login Window ***************
        login.add(userLabel);
        login.add(userName);
        login.add(passwordLabel);
        login.add(userPassword);
        login.add(buttonsPanel);
        login.add(messageLabel);

        login.setVisible(true);
    }


    private void checkInfo(){
        if(loginInfo.containsKey(userName.getText()) && loginInfo.containsValue(String.valueOf(userPassword.getPassword()))){

            messageLabel.setText("Success!");
            messageLabel.setForeground(Color.green);

            new WelcomePage();
            login.dispose();
        }
        else{
            messageLabel.setText("Wrong UserID or password :(");
            messageLabel.setForeground(Color.red);
        }
    }

    private void clearInfo(){
        userName.setText("");
        userPassword.setText("");
        messageLabel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == loginBtn){
            checkInfo();
        }

        if(e.getSource() == resetBtn){
            clearInfo();
        }
    }
}
