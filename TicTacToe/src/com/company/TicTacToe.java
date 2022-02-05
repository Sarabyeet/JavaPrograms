package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    private Random random = new Random();

    private JFrame game;
    private JPanel titlePanel;
    private JPanel buttonsPanel;
    private JLabel textField;
    private JButton[] buttons = new JButton[9];

    private boolean player1Turn;

    TicTacToe(){
        // ######################## Buttons panel and buttons #########################
        buttonsPanel = new JPanel(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Convection",Font.BOLD,120));
            buttonsPanel.add(buttons[i]);
        }

        // ######################## Label for Title #########################
        textField = new JLabel("Welcome to Tic-Tac-Toe");
        textField.setForeground(new Color(255, 0, 89));
        textField.setBackground(new Color(0, 0, 0));
        textField.setOpaque(true);
        textField.setFont(new Font("Convection",Font.BOLD,60));
        textField.setHorizontalAlignment(JLabel.CENTER);

        // ######################## Title Panel ###########################
        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,100,800,100);

        titlePanel.add(textField);

        // ######################## Frame setup ###########################
        game = new JFrame("Tic-Tac-Toe 🎰");

        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(800,800);
        game.setLayout(new BorderLayout());
        game.setLocationRelativeTo(null);

        game.add(titlePanel,BorderLayout.NORTH);
        game.add(buttonsPanel);
        game.setVisible(true);

        // ########### First turn ###########

        firstTurn();
    }

    private void firstTurn(){
        // Lil Delay for Title
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Checking the first turn
        if (random.nextInt(2) == 0){
            player1Turn = true;
            textField.setText("X's Turn");
        }
        else{
            player1Turn = false;
            textField.setText("O's Turn");
        }
    }

    private void check(){
        // ############### Check if X wins #####################
        if(     buttons[0].getText().equals("X")&&
                buttons[1].getText().equals("X")&&
                buttons[2].getText().equals("X")) {

            xWins(0,1,2);
            
        }

        if(     buttons[3].getText().equals("X")&&
                buttons[4].getText().equals("X")&&
                buttons[5].getText().equals("X")) {

            xWins(3,4,5);
            
        }

        if(     buttons[6].getText().equals("X")&&
                buttons[7].getText().equals("X")&&
                buttons[8].getText().equals("X")) {

            xWins(6,7,8);
            
        }

        if(     buttons[0].getText().equals("X")&&
                buttons[3].getText().equals("X")&&
                buttons[6].getText().equals("X")) {

            xWins(0,3,6);
            
        }

        if(     buttons[1].getText().equals("X")&&
                buttons[4].getText().equals("X")&&
                buttons[7].getText().equals("X")) {

            xWins(1,4,7);
            
        }

        if(     buttons[2].getText().equals("X")&&
                buttons[5].getText().equals("X")&&
                buttons[8].getText().equals("X")) {

            xWins(2,5,8);
            
        }

        if(     buttons[0].getText().equals("X")&&
                buttons[4].getText().equals("X")&&
                buttons[8].getText().equals("X")) {

            xWins(0,4,8);
            
        }

        if(     buttons[2].getText().equals("X")&&
                buttons[4].getText().equals("X")&&
                buttons[6].getText().equals("X")) {

            xWins(2,4,6);
            
        }

        // ################ Check if O wins ######################
        if(     buttons[0].getText().equals("O")&&
                buttons[1].getText().equals("O")&&
                buttons[2].getText().equals("O")) {

            oWins(0,1,2);
            
        }

        if(     buttons[3].getText().equals("O")&&
                buttons[4].getText().equals("O")&&
                buttons[5].getText().equals("O")) {

            oWins(3,4,5);
            
        }

        if(     buttons[6].getText().equals("O")&&
                buttons[7].getText().equals("O")&&
                buttons[8].getText().equals("O")) {

            oWins(6,7,8);
            
        }

        if(     buttons[0].getText().equals("O")&&
                buttons[3].getText().equals("O")&&
                buttons[6].getText().equals("O")) {

            oWins(0,3,6);
            
        }

        if(     buttons[1].getText().equals("O")&&
                buttons[4].getText().equals("O")&&
                buttons[7].getText().equals("O")) {

            oWins(1,4,7);
            
        }

        if(     buttons[2].getText().equals("O")&&
                buttons[5].getText().equals("O")&&
                buttons[8].getText().equals("O")) {

            oWins(2,5,8);
            
        }

        if(     buttons[0].getText().equals("O")&&
                buttons[4].getText().equals("O")&&
                buttons[8].getText().equals("O")) {

            oWins(0,4,8);
            
        }
        
        if(     buttons[2].getText().equals("O")&&
                buttons[4].getText().equals("O")&&
                buttons[6].getText().equals("O")) {

            oWins(2,4,6);
            
        }
    }

    private void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins!");
    }

    private void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins!");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource()==buttons[i]){
                if (player1Turn) {
                    if (buttons[i].getText().equals("")){

                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1Turn = false;
                        textField.setText("O's Turn");

                        check();
                    }
                }
                else{
                    if (buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1Turn = true;
                        textField.setText("X's Turn");

                        check();
                    }
                }
                check();
            }
        }
    }
}
