package com.company;

import javax.swing.*;
import java.awt.*;

     class WelcomePage extends JFrame {

    JLabel welcomeMessage;

    WelcomePage(){

        welcomeMessage = new JLabel("Hello! Welcome to this frame.");
        welcomeMessage.setFont(new Font("Comic sans MS", Font.BOLD, 50));
        welcomeMessage.setForeground(new Color(255, 134, 0));
        welcomeMessage.setBackground(Color.black);
        welcomeMessage.setOpaque(true);

        // ***************** Welcome page ************************

        this.setTitle("Home 🏡");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));

        // **************** Adding to the welcome Page ****************
        this.add(welcomeMessage);

        this.setVisible(true);
    }
}
