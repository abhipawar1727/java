package institutee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;
    
    public TeacherDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setUndecorated(true);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(50, 20, 200, 20);
        heading.setFont(new Font("SansSerif", Font.BOLD, 15));
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
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 170, 1400, 600);
        add(jsp);

        search = createButton("Search", "/icons/search.png", 50, 70);
        print = createButton("Print", "/icons/pdf.png", 203, 70);
        add = createButton("Add", "/icons/add.png", 360, 70);
        update = createButton("Update", "/icons/1.png", 520, 70);
        cancel = createButton("Cancel", "/icons/can.png", 680, 70);

        setSize(1200, 700);
        setLocation(100, 100);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private JButton createButton(String text, String iconPath, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 36);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setForeground(Color.BLACK);
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.addActionListener(this);
        add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacher where empId = '"+cEmpId.getSelectedItem()+"'";
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
            new AddTeacher();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateTeacher();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
