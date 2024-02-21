package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JLabel labeltotal,custom;
    JButton update, pay, back;
    JTextField tcustom;
    
    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setUndecorated(true);

        
        getContentPane().setBackground(new Color(238, 238, 238));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/edufee.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480, 50, 350, 350);
        add(image);
        
        JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(60, 60, 150, 20);
        lblrollnumber.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(220, 60, 150, 20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 100, 150, 20);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 100, 150, 20);
        labelname.setFont(new Font("SansSerif", Font.PLAIN, 13));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(60, 140, 150, 20);
        lblfname.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(220, 140, 150, 20);
        labelfname.setFont(new Font("SansSerif", Font.PLAIN, 13));
        add(labelfname);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(60, 180, 150, 20);
        lblcourse.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblcourse);
        
        String course[] = { "Bsc", "Msc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(220, 180, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(60, 220, 150, 20);
        lblbranch.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblbranch);
        
        String branch[] = {"Computer Science",  "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(220, 220, 150, 20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(60, 260, 150, 20);
        lblsemester.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lblsemester);
        
        String semester[] = {"FirstYear", "SecondYear", "ThirdYear" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(220, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total FEE");
        lbltotal.setBounds(60, 300, 150, 20);
        lbltotal.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(220, 300, 150, 20);
        labeltotal.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labeltotal);
        
        custom = new JLabel("Paid fee");
        custom.setBounds(60, 340, 150, 20);
        custom.setFont(new Font("SansSerif", Font.BOLD, 13));
        add(custom);
        
        tcustom = new JTextField();
        tcustom.setBounds(220, 340, 150, 20);
        add(tcustom);
        
        update = new JButton("Update");
        update.setBounds(30, 400, 120, 30); 
        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("SansSerif", 1, 13)); 
        update.setForeground(new java.awt.Color(0,0,0));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1.png"))); 
        update.addActionListener(this);
        add(update);
        
        pay = new JButton("Pay");
        pay.setBounds(170, 400, 100, 30);
        pay.setBackground(Color.white);
        pay.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay.png"))); 
        pay.setForeground(new java.awt.Color(0,0,0));
        pay.addActionListener(this);        
        add(pay);
        
        back = new JButton("Cancel");
        back.setBounds(290, 400, 100, 30);
        back.setBackground(Color.white);
        back.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        back.setForeground(new java.awt.Color(0,0,0));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png"))); 
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course   = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            String paid = tcustom.getText();
            try {
                Conn c = new Conn();
                
                String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"', '"+paid+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
