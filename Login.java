package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login() {

        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/grad.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(70, 100, 590, 500);
        add(l4);

        // Text Labels
        JLabel text = new JLabel("LOG IN");
        text.setFont(new Font("Segoe UI", Font.BOLD, 35));
        text.setForeground(new Color(204, 51, 255));
        text.setBounds(700, 80, 400, 40);
        add(text);

        JLabel text2 = new JLabel("Welcome to the smart site system");
        text2.setForeground(new Color(0, 0, 0));
        text2.setBounds(700, 70, 500, 150);
        add(text2);

        JLabel text3 = new JLabel("for managing university details");
        text3.setForeground(new Color(0, 0, 0));
        text3.setBounds(700, 90, 500, 150);
        add(text3);

        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(700, 240, 100, 20);
        lblusername.setForeground(new Color(0, 0, 0));
        add(lblusername);

        // Username TextField
        tfusername = new JTextField();
        tfusername.setBounds(700, 270, 350, 50);
        tfusername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(114, 166, 226)));
        tfusername.setCaretColor(new Color(255, 51, 102));
        tfusername.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(tfusername);

        // Password Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(700, 360, 100, 20);
        lblpassword.setForeground(new Color(0, 0, 0));
        add(lblpassword);

        // Password TextField
        tfpassword = new JPasswordField();
        tfpassword.setBounds(700, 390, 350, 50);
        tfpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(114, 166, 226)));
        tfpassword.setCaretColor(new Color(255, 51, 102));
        tfpassword.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(tfpassword);

        // Login Button
        login = new JButton("Login");
        login.setBounds(700, 520, 150, 50);
        login.setBackground(Color.WHITE);
        login.setFont(new Font("SansSerif", Font.BOLD, 16));
        login.setForeground(new Color(0, 0, 0));
        login.setIcon(new ImageIcon(getClass().getResource("/icons/log.png")));
        login.addActionListener(this);
        add(login);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(900, 520, 150, 50);
        cancel.setBackground(Color.WHITE);
        cancel.setFont(new Font("SansSerif", Font.BOLD, 16));
        cancel.setForeground(new Color(0, 0, 0));
        cancel.setIcon(new ImageIcon(getClass().getResource("/icons/can.png")));
        cancel.addActionListener(this);
        add(cancel);

        setSize(1200, 700);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username='" + username + "' and password='" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Project();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid ID or Password", "Warning Message", 0);
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
