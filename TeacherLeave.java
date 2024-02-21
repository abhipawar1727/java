package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cEmpId, ctime;
    JDateChooser dcdate,dcdate2;
    JButton submit, cancel;
    
    TeacherLeave() {
        
        setSize(470, 550);
        setLocation(550, 100);
        getContentPane().setBackground(new Color(234, 234, 234));
        setLayout(null);
       setUndecorated(true);
        
        
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(100, 50, 300, 30);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(heading);
        
        
        JLabel lblrollno = new JLabel("Search by Employee Id");
        lblrollno.setBounds(100, 140, 270, 30);
        lblrollno.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblrollno);
        
        cEmpId = new Choice();
        cEmpId.setBounds(100, 170, 270, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel(" Start Date");
        lbldate.setBounds(100, 220, 270, 20);
        lbldate.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(100, 240, 270, 20);
        add(dcdate);
        
        JLabel lbldate2 = new JLabel("End Date");
        lbldate2.setBounds(100, 290, 270, 20);
        lbldate2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lbldate2);
        
        dcdate2 = new JDateChooser();
        dcdate2.setBounds(100, 310, 270, 20);
        add(dcdate2);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(100, 340, 270, 20);
        lbltime.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(100, 370, 270, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(100, 450, 120, 36);
        submit.setBackground(Color.white);
        submit.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        submit.setForeground(Color.BLACK);
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/correct.png")));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 450, 120, 36);
        cancel.setBackground(Color.white);
        cancel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cancel.setForeground(Color.BLACK);
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png")));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String date2 = ((JTextField) dcdate2.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into teacherleave values('"+rollno+"', '"+date+"','"+date2+"', '"+duration+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
