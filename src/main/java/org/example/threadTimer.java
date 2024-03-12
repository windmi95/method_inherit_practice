package org.example;

import javax.swing.*;
import java.awt.*;

public class threadTimer {
 class ThreadTimerEx extends JFrame {
     JLabel la;
     JLabel la1;
     JLabel la2;

     int min, sec;
     int day = 1;

     ThreadTimerEx() {
         this.setTitle("2 minutes");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         la.setFont(new Font("Gothic", Font.PLAIN, 50));

         la1.setFont(new Font("Gothic", Font.ITALIC, 20));
         la1.setOpaque(true);// 색 설정
         Color color = new Color(255,0,0);
         la1.setForeground(color);

         la2.setFont(new Font("Gothic", Font.ITALIC, 20));


         this.setLocationRelativeTo(null);
         this.setSize(400,200);
         this.setVisible(true);
         this.setAlwaysOnTop(true); // 프레임 항상 위에 있게

     }

     public int time() {
         return min;
     }

     public int day() {
         return day;
     }

     class MyThread extends JFrame{

     }

 }

}
