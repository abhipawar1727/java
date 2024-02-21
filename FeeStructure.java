package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class FeeStructure extends JFrame  implements ActionListener{
    
    JButton cancel;
    FeeStructure() {
        
        setSize(1000, 500);
        setLocation(250, 90);
        setLayout(null);
        setUndecorated(true);             
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 30, 400, 30);
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(heading);
        
        
        
        JTable table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setFont(new Font("SansSerif", Font.PLAIN, 16));
            table.setRowHeight(30);
    

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 100, 900, 280);
        add(jsp);
        
        setVisible(true);
       
        
        
        
         
        cancel = new JButton("Back");
        cancel.setBounds(440, 450, 120, 37);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);      
        cancel.setFont(new Font("SansSerif", Font.BOLD, 15));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png")));        
        add(cancel);
    }
        
    public void actionPerformed(ActionEvent ae) {
        
        
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
