package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester,cbstream1;
    JTextField tfsub1, tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton cancel, submit;
     JTable table;
    
    EnterMarks() {
        
      

        
        getContentPane().setBackground(new Color(243,243,243));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/g20.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460, 120, 500, 500);
        add(image);
        
        ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("icons/result.png"));
        Image k2 = k1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon k3 = new ImageIcon(k2);
        JLabel image1 = new JLabel(k3);
        image1.setBounds(295, 57, 30, 30);     
        add(image1);
        
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 50, 500, 50);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(new Color(202, 46, 190));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 140, 150, 20);
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 140, 150, 20);
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
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 180, 150, 20);
        add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 180, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblStream = new JLabel("Select Stream");
        lblStream.setBounds(50, 220, 150, 20);
        add(lblStream);
        
        String stream1[] = {"Bsc-IT", "Msc-CS" };
        cbstream1 = new JComboBox(stream1);
        cbstream1.setBounds(200, 220, 150, 20);
        cbstream1.setBackground(Color.WHITE);
        add(cbstream1);
        
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 250, 200, 40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 250, 200, 40);
        add(lblentermarks);
        
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 499, 200, 30);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 300, 200, 30);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 350, 200, 30);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 400, 200, 30);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 450, 200, 30);
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 499, 200, 30);
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 300, 200, 30);
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 350, 200, 30);
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 400, 200, 30);
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 450, 200, 30);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 550, 150, 40);
        submit.setBackground(Color.white);
        submit.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        submit.setForeground(Color.black);
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/correct.png"))); // NOI18N
       
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 550, 150, 40);
        cancel.setBackground(Color.white);
        cancel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cancel.setForeground(Color.black);
                cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can.png"))); // NOI18N

        cancel.addActionListener(this);
        add(cancel);
  
        setSize(970, 700);
        setLocation(250, 70);
        setLayout(null);
        setUndecorated(true);       
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbstream1.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 =   "insert into marks values('"+crollno.getSelectedItem()+"','"+cbstream1.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";
            
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
