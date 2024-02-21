import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLeaveForm extends JFrame {
    private JTextField nameField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextArea reasonArea;

    public StudentLeaveForm() {
        // Set up the frame
        setTitle("Student Leave Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        nameField = new JTextField(20);
        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        reasonArea = new JTextArea(5, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });

        // Create panels with titled borders for better organization
        JPanel personalInfoPanel = createPanel("Personal Information");
        JPanel leaveInfoPanel = createPanel("Leave Information");
        JPanel reasonPanel = createPanel("Reason for Leave");

        // Add components to panels
        personalInfoPanel.add(createLabel("Student Name:"));
        personalInfoPanel.add(nameField);

        leaveInfoPanel.add(createLabel("Start Date:"));
        leaveInfoPanel.add(startDateField);
        leaveInfoPanel.add(createLabel("End Date:"));
        leaveInfoPanel.add(endDateField);

        reasonPanel.add(createLabel("Reason:"));
        reasonPanel.add(new JScrollPane(reasonArea));

        // Create layout
        setLayout(new GridLayout(4, 1, 10, 10));

        // Add panels to the frame
        add(personalInfoPanel);
        add(leaveInfoPanel);
        add(reasonPanel);
        add(submitButton);

        // Display the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(80, 20));
        return label;
    }

    private void submitForm() {
        String name = nameField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String reason = reasonArea.getText();

        // Processing the form data (printing to console in this example)
        System.out.println("Student Name: " + name);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Reason for Leave: " + reason);

        // Display a message to the user
        JOptionPane.showMessageDialog(this, "Leave form submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear the form fields
        nameField.setText("");
        startDateField.setText("");
        endDateField.setText("");
        reasonArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentLeaveForm();
            }
        });
    }
}
