package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, cancel;
    
    TeacherLeaveDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(100, 20, 150, 20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(260, 20, 150, 20);
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
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
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
            String query = "select * from teacherleave where empId = '"+cEmpId.getSelectedItem()+"'";
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
        new TeacherLeaveDetails();
    }
}
