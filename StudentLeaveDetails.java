package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentLeaveDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(100, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(260, 20, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(100, 130, 700, 500);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(100, 70, 110, 36);
        search.setBackground(Color.white);
        search.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        search.setForeground(new java.awt.Color(0,0,0));
                                          search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
             
              
        
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(230, 70, 110, 36);
        print.setBackground(Color.white);
        print.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        print.setForeground(new java.awt.Color(0,0,0));
              
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png"))); // NOI18N
       
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(360, 70, 110, 36);
        cancel.setBackground(Color.white);
        cancel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cancel.setForeground(new java.awt.Color(0,0,0));  
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png")));

        cancel.addActionListener(this);
        add(cancel);
        
        setUndecorated(true);      
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
