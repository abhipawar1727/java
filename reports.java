package institutee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author aspaw
 */
public class reports extends JFrame implements ActionListener {

    JButton student, teacher, course, schedule, grades, attendance, finance, library;

    reports() {

        setSize(500, 500);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        student = new JButton("STUDENT");
        student.setBounds(50, 50, 120, 37);
        student.addActionListener(this);
        add(student);

        teacher = new JButton("TEACHER");
        teacher.setBounds(200, 50, 120, 37);
        teacher.addActionListener(this);
        add(teacher);

        course = new JButton("Student Leave");
        course.setBounds(350, 50, 120, 37);
        course.addActionListener(this);
        add(course);

        schedule = new JButton("Tacher Leave");
        schedule.setBounds(50, 150, 120, 37);
        schedule.addActionListener(this);
        add(schedule);

        grades = new JButton("GRADES");
        grades.setBounds(200, 150, 120, 37);
        grades.addActionListener(this);
        add(grades);

     

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == student) {
            openPDF("C:/Users/aspaw/OneDrive/Documents/s.pdf");
        } else if (ae.getSource() == teacher) {
            openPDF("C:/Users/aspaw/OneDrive/Documents/t.pdf");
        } else if (ae.getSource() == course) {
            openPDF("C:/Users/aspaw/OneDrive/Documents/sl.pdf");
        } else if (ae.getSource() == schedule) {
            openPDF("C:/Users/aspaw/OneDrive/Documents/tl.pdf");
        } else if (ae.getSource() == grades) {
            openPDF("C:/Users/aspaw/OneDrive/Documents/grades.pdf");
        }
    }

    private void openPDF(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File not found: " + filePath);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new reports());
    }
}
