package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch extends JFrame implements ActionListener {
    private final JButton startButton;
    private final JButton resetButton;
    private final JLabel timeLabel;

    private int timeElapsed = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    private String secondsString = String.format("%02d",seconds);
    private String minutesString = String.format("%02d",minutes);
    private String hoursString = String.format("%02d",hours);

    private final Timer timer;
    private boolean started = false;

    StopWatch(){

        // ========= Timer Function ===============
        timer = new Timer(1000, e-> setTime());

        // ========= Time Label ==================
        timeLabel = new JLabel(hoursString + ":" + minutesString + ":"+ secondsString);
        timeLabel.setBounds(75,100,350,100);
        timeLabel.setFont(new Font("Berlin sans FB", Font.PLAIN, 50));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.lightGray));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setVerticalAlignment(JTextField.CENTER);
        timeLabel.setForeground(Color.white);
        timeLabel.setBackground(Color.darkGray);

        // ========= Start and reset button ===========
        startButton = new JButton("START");
        startButton.setBounds(75,200,175,50);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Convection",Font.BOLD,30));
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.addActionListener(this);

        resetButton = new JButton("RESET");
        resetButton.setBounds(250,200,175,50);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Convection",Font.BOLD,30));
        resetButton.setBackground(Color.black);
        resetButton.setForeground(Color.white);
        resetButton.addActionListener(this);

        // ========= Setting up the frame =============
        this.setTitle("StopWatch ⌚");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);

        // ========== Adding to frame ==================
        this.add(startButton);
        this.add(resetButton);
        this.add(timeLabel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton){
            if(!started){
                started = true;
                timer.start();
                startButton.setText("STOP");
            }
            else {
                started = false;
                timer.stop();
                startButton.setText("START");
            }
        }

        if(e.getSource() == resetButton){
            resetTime();
        }
    }

    private void setTime(){
        timeElapsed +=1000;
        hours = (timeElapsed/3600000);
        minutes = (timeElapsed/60000) % 60;
        seconds = (timeElapsed/1000) % 60;

        secondsString = String.format("%02d",seconds);
        minutesString = String.format("%02d",minutes);
        hoursString = String.format("%02d",hours);
        timeLabel.setText(hoursString + ":" + minutesString + ":"+ secondsString);
    }

    private void resetTime(){
        timer.stop();
        started = false;

        startButton.setText("START");

        timeElapsed = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        secondsString = String.format("%02d",seconds);
        minutesString = String.format("%02d",minutes);
        hoursString = String.format("%02d",hours);
        timeLabel.setText(hoursString + ":" + minutesString + ":"+ secondsString);
    }
}
