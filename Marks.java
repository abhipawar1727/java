package institutee.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno) {
        this.rollno = rollno;
        setUndecorated(true);            

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Shivaji Technical Univeristy");
        heading.setBounds(100, 30, 500, 25);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(100, 70, 500, 20);
        subheading.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number " + rollno);
        lblrollno.setBounds(100, 130, 500, 20);
        lblrollno.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(100, 160, 500, 20);
        lblsemester.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblsemester);
        
          JLabel lblstream = new JLabel();
        lblstream.setBounds(100, 190, 500, 20);
        lblstream.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblstream);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 230, 500, 20);
        sub1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 260, 500, 20);
        sub2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 290, 500, 20);
        sub3.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 320, 500, 20);
        sub4.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 350, 500, 20);
        sub5.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(sub5);
        
        
        
        
        
        try {
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno =  '"+rollno+"'");
            
            while(rs2.next()) {
                sub1.setText(sub1.getText() +  "                =     " + rs2.getString("marks1"));
                sub1.setForeground(Color.blue);
                sub2.setText(sub2.getText() +  "            =     " + rs2.getString("marks2")); 
                 sub2.setForeground(Color.blue);
                sub3.setText(sub3.getText() + "           =     " + rs2.getString("marks3"));
                 sub3.setForeground(Color.blue);
                sub4.setText(sub4.getText() + "            =     " + rs2.getString("marks4"));
                 sub4.setForeground(Color.blue);
                sub5.setText(sub5.getText() + "            =     " + rs2.getString("marks5"));
                 sub5.setForeground(Color.blue);
                 
                lblsemester.setText("Semester :" + rs2.getString("semester"));
                lblstream.setText("Stream :" + rs2.getString("stream"));
                     
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 37);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);      
        cancel.setFont(new Font("SansSerif", Font.BOLD, 15));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png")));        
        add(cancel);
        
        setVisible(true);         
       
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks("");
    }
}
