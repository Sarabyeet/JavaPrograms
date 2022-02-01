package com.company;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockInstance extends JFrame{

    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    String date;
    String day;
    String time;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;

    ImageIcon appIcon = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\ClockApp\\clock.png");

    ClockInstance(){
        // Time
        timeLabel = new JLabel();
        timeLabel.setSize(500,150);
        timeLabel.setBackground(new Color(0x000000));
        timeLabel.setOpaque(true);
        timeLabel.setForeground(new Color(0xFF1E56));
        timeLabel.setFont(new Font ("Corbel",Font.BOLD, 80));

        timeFormat = new SimpleDateFormat("h:mm:ss a");

        // Day
        dayLabel = new JLabel();
        dayLabel.setSize(500,150);
        dayLabel.setForeground(new Color(238,226,120));
        dayLabel.setFont(new Font ("Freestyle script",Font.PLAIN, 70));

        dayFormat = new SimpleDateFormat("EEEE");
        day = dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);

        // Date
        dateLabel = new JLabel();
        dateLabel.setSize(500,150);
        dateLabel.setForeground(new Color(238, 226, 120));
        dateLabel.setFont(new Font ("Ink Free",Font.PLAIN, 40));

        dateFormat = new SimpleDateFormat("MMMM d, yyyy");
        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);

        this.setTitle("Clock");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,80,20));
        this.setResizable(false);
        this.setSize(500,350);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x323232));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        timeUpdate();

    }

    public void timeUpdate(){
        while(true){

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
