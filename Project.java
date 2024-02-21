package institutee.management.system;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {

    Project() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setSize(1540, 850);
        setUndecorated(true);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/set.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        add(backgroundLabel);

   
        

        setJMenuBar(createMenuBar());
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(300, 60));

        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setFont(new Font("SansSerif", Font.BOLD, 20));
        newInformation.setHorizontalAlignment(SwingConstants.CENTER);
        newInformation.setPreferredSize(new Dimension(200, 22));
        newInformation.setForeground(Color.BLUE);
        menuBar.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setHorizontalAlignment(SwingConstants.CENTER);
        facultyInfo.setPreferredSize(new Dimension(197, 22));
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setHorizontalAlignment(SwingConstants.CENTER);
        studentInfo.setPreferredSize(new Dimension(197, 22));
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // ... Your existing menu items ...
   // Details
        JMenu details = new JMenu("View Details");
        details.setFont(new Font("SansSerif  ",Font.BOLD,20));
    details.setHorizontalAlignment(SwingConstants.CENTER);
        details.setPreferredSize(new java.awt.Dimension(150, 22));
        details.setForeground(Color.RED);
        menuBar.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
         facultydetails.setHorizontalAlignment(SwingConstants.CENTER);
        facultydetails.setPreferredSize(new java.awt.Dimension(147, 22));
        
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
           studentdetails.setHorizontalAlignment(SwingConstants.CENTER);
        studentdetails.setPreferredSize(new java.awt.Dimension(147, 22));
        studentdetails.addActionListener(this);
        details.add(studentdetails);
        
        // Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
                leave.setFont(new Font("SansSerif",Font.BOLD,20));
 leave.setHorizontalAlignment(SwingConstants.CENTER);
        leave.setPreferredSize(new java.awt.Dimension(150, 22));
        menuBar.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
         facultyleave.setHorizontalAlignment(SwingConstants.CENTER);
        facultyleave.setPreferredSize(new java.awt.Dimension(147, 22));
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.setHorizontalAlignment(SwingConstants.CENTER);
        studentleave.setPreferredSize(new java.awt.Dimension(147, 22));
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
                        leaveDetails.setFont(new Font("Segoe UI ",Font.BOLD,20));
leaveDetails.setHorizontalAlignment(SwingConstants.CENTER);
        leaveDetails.setPreferredSize(new java.awt.Dimension(180, 22));
        menuBar.add(leaveDetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
         facultyleavedetails.setHorizontalAlignment(SwingConstants.CENTER);
        facultyleavedetails.setPreferredSize(new java.awt.Dimension(177, 22));
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.setHorizontalAlignment(SwingConstants.CENTER);
        studentleavedetails.setPreferredSize(new java.awt.Dimension(177, 22));
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);
        
        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setFont(new Font("SansSerif ",Font.BOLD,20));
exam.setHorizontalAlignment(SwingConstants.CENTER);
        exam.setPreferredSize(new java.awt.Dimension(150, 22));
        exam.setForeground(Color.BLUE);
        menuBar.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
          examinationdetails.setHorizontalAlignment(SwingConstants.CENTER);
        examinationdetails.setPreferredSize(new java.awt.Dimension(147, 22));
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
 entermarks.setHorizontalAlignment(SwingConstants.CENTER);
        entermarks.setPreferredSize(new java.awt.Dimension(147, 22));
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
      
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setFont(new Font("SansSerif",Font.BOLD,20));
        updateInfo.setHorizontalAlignment(SwingConstants.CENTER);
        updateInfo.setPreferredSize(new java.awt.Dimension(200, 22));
        updateInfo.setForeground(Color.RED);
        menuBar.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
         updatefacultyinfo.setHorizontalAlignment(SwingConstants.CENTER);
        updatefacultyinfo.setPreferredSize(new java.awt.Dimension(197, 22));
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.setHorizontalAlignment(SwingConstants.CENTER);
        updatestudentinfo.setPreferredSize(new java.awt.Dimension(197, 22));
        updatestudentinfo.addActionListener(this);
       updateInfo.add(updatestudentinfo);
        
        // fee
        JMenu fee = new JMenu("Fee Details");
        fee.setFont(new Font("SansSerif ",Font.BOLD,20));
        fee.setForeground(Color.BLUE);
        fee.setHorizontalAlignment(SwingConstants.CENTER);
        fee.setPreferredSize(new java.awt.Dimension(150, 22));
        menuBar.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
           feestructure.setHorizontalAlignment(SwingConstants.CENTER);
        feestructure.setPreferredSize(new java.awt.Dimension(147, 22));
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.setHorizontalAlignment(SwingConstants.CENTER);
        feeform.setPreferredSize(new java.awt.Dimension(147, 22));
        feeform.addActionListener(this);
        fee.add(feeform);
        
        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
           utility.setHorizontalAlignment(SwingConstants.CENTER);
        utility.setPreferredSize(new java.awt.Dimension(120, 22));
        utility.setFont(new Font(" SansSerif",Font.BOLD,20));
        menuBar.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        notepad.setHorizontalAlignment(SwingConstants.CENTER);
        notepad.setPreferredSize(new java.awt.Dimension(117, 22));
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.setHorizontalAlignment(SwingConstants.CENTER);
        calc.setPreferredSize(new java.awt.Dimension(117, 22));
        calc.addActionListener(this);
        utility.add(calc);
        
        JMenu report = new JMenu("Reports");
        report.setFont(new Font("SansSerif ",Font.BOLD,20));
        report.setForeground(Color.BLUE);
        report.setHorizontalAlignment(SwingConstants.CENTER);
        report.setPreferredSize(new java.awt.Dimension(100, 22));
        menuBar.add(report);
               
        
        JMenuItem one = new JMenuItem("reports");
        one.setBackground(Color.WHITE);
        one.setHorizontalAlignment(SwingConstants.CENTER);
        one.setPreferredSize(new java.awt.Dimension(100, 22));
        one.addActionListener(this);
        report.add(one);
        // exit
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("SansSerif ",Font.BOLD,20));
         exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setPreferredSize(new java.awt.Dimension(100, 22));
        exit.setForeground(Color.blue);
        menuBar.add(exit);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JMenuItem ex = new JMenuItem("Exit");
         ex.setHorizontalAlignment(SwingConstants.CENTER);
        ex.setPreferredSize(new java.awt.Dimension(100, 22));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        
        
       
        
        
        setJMenuBar(menuBar);
       
        setVisible(true);
        return menuBar;
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        // ... Your existing action listeners ...

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
         else if (msg.equals("reports")) {
            new reports();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Project());
    }
}
