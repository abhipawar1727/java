package institutee.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails() {
     
         setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(50, 15, 400, 50);
        heading.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(heading);
        
        
        search = new JTextField();
        search.setBounds(50, 70, 200, 30);
        search.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Result");
        submit.setBounds(300, 70, 120, 30);
        submit.setBackground(new java.awt.Color(255,255, 255));
        submit.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        submit.setForeground(new java.awt.Color(0,0,0));
                         submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/score.png"))); // NOI18N

        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440, 70, 120, 30);
        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cancel.setForeground(new java.awt.Color(0,0,0));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png"))); // NOI18N
       
        cancel.addActionListener(this);
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));
                    table.setRowHeight(30);

         JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 170, 1400, 600);
        add(jsp);
        
        try {
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from student");
             table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        setSize(1100, 600);
        setLocation(250, 70);
        setLayout(null);
        setUndecorated(true);             
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE); 
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            setVisible(false);    
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
