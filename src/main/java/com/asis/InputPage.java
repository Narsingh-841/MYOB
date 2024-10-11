package com.asis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputPage extends JFrame implements ActionListener {
    private JTextField clientNameField;
    private JTextField usernameField;
    private JTextField fromDateField;
    private JTextField toDateField;
    private JCheckBox quarter1CheckBox;
    private JCheckBox quarter2CheckBox;
    private JCheckBox quarter3CheckBox;
    private JCheckBox quarter4CheckBox;
    private JButton submitButton;

    public InputPage() {
        setTitle("Input Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel clientNameLabel = new JLabel("Client Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(clientNameLabel, gbc);

        clientNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(clientNameField, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);

        JLabel fromDateLabel = new JLabel("From Date:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(fromDateLabel, gbc);

        fromDateField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(fromDateField, gbc);

        JLabel toDateLabel = new JLabel("To Date:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(toDateLabel, gbc);

        toDateField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(toDateField, gbc);

        JLabel quarterLabel = new JLabel("Quarters:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(quarterLabel, gbc);

        JPanel quarterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        quarter1CheckBox = new JCheckBox("Quarter 1");
        quarter2CheckBox = new JCheckBox("Quarter 2");
        quarter3CheckBox = new JCheckBox("Quarter 3");
        quarter4CheckBox = new JCheckBox("Quarter 4");
        quarterPanel.add(quarter1CheckBox);
        quarterPanel.add(quarter2CheckBox);
        quarterPanel.add(quarter3CheckBox);
        quarterPanel.add(quarter4CheckBox);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(quarterPanel, gbc);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Check if all fields are filled
            if (clientNameField.getText().isEmpty() || usernameField.getText().isEmpty() ||
                fromDateField.getText().isEmpty() || toDateField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all details.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Start the automation process
                startAutomation();
            }
        }
    }

    private void startAutomation() {
        // Mocking automation process
        System.out.println("Automation process started...");
        System.out.println("Client Name: " + clientNameField.getText());
        System.out.println("Username: " + usernameField.getText());
        System.out.println("From Date: " + fromDateField.getText());
        System.out.println("To Date: " + toDateField.getText());
        System.out.print("Selected Quarters: ");
        if (quarter1CheckBox.isSelected()) {
            System.out.print("Quarter 1 ");
        }
        if (quarter2CheckBox.isSelected()) {
            System.out.print("Quarter 2 ");
        }
        if (quarter3CheckBox.isSelected()) {
            System.out.print("Quarter 3 ");
        }
        if (quarter4CheckBox.isSelected()) {
            System.out.print("Quarter 4 ");
        }
        System.out.println();
        // Add your automation code here
    }

    public static void main(String[] args) {
        new InputPage();
    }
}
