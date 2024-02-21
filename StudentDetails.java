package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;
    
    StudentDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setUndecorated(true);

        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setFont(new  Font("SansSerif",Font.BOLD,15));
        heading.setBounds(50, 20, 210, 20);
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
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 170, 1400, 600);
        add(jsp);
        
      search = new JButton("Search");
        search.setBounds(50, 70, 120, 36); 
        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N    
                                         search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N

        search.setForeground(new java.awt.Color(0,0,0));
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(203, 70, 120, 36);      
        print.setBackground(new java.awt.Color(255, 255, 255));
        print.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
                                 print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png"))); // NOI18N

        print.setForeground(new java.awt.Color(0,0,0));
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(360, 70, 120, 36);        
        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        add.setForeground(new java.awt.Color(0,0,0));
                         add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N

        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(520, 70, 120, 36);       
        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
                 update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1.png"))); // NOI18N

        update.setForeground(new java.awt.Color(0,0,0));
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton();
        cancel.setBounds(680, 70, 120, 36);
        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cancel.setForeground(new java.awt.Color(0,0,0));
        cancel.addActionListener(this);
        
         cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png"))); // NOI18N
        cancel.setText("CANCEL");
        add(cancel);
        
        setSize(1200, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(100, 170);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
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
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
