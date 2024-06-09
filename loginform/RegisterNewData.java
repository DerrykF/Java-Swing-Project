/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author samea
 */

public class RegisterNewData implements ActionListener {

    JFrame form = new JFrame();
    JButton RegisterButton = new JButton("Register");
    JButton ResetButton = new JButton("Reset");
    JButton BackButton = new JButton("Back");
    JTextField userIDField = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JTextField FirstnameField = new JTextField();
    JTextField LastnameField = new JTextField();
    JLabel userIdLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password :");
    JLabel FirstnameLabel = new JLabel("Firstname:");
    JLabel LastnameLabel = new JLabel("Lastname:");
    JLabel messageLabel = new JLabel("Create New Account");

    RegisterNewData() {
        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        FirstnameLabel.setBounds(50, 200, 75, 25);
        LastnameLabel.setBounds(50, 250, 75, 25);
        userIDField.setBounds(125, 100, 150, 30);
        userPassword.setBounds(125, 150, 150, 30);
        FirstnameField.setBounds(125, 200, 150, 30);
        LastnameField.setBounds(123, 250, 150, 30);
        messageLabel.setBounds(20, 20, 250, 25);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        RegisterButton.setBounds(80, 300, 100, 25);
        RegisterButton.addActionListener(this);
        ResetButton.setBounds(280, 300, 100, 25);
        ResetButton.addActionListener(this);
        BackButton.setBounds(180, 300, 100, 25);
        BackButton.addActionListener(this);

        form.add(userIdLabel);
        form.add(userPasswordLabel);
        form.add(FirstnameLabel);
        form.add(LastnameLabel);
        form.add(userIDField);
        form.add(FirstnameField);
        form.add(LastnameField);
        form.add(userPassword);
        form.add(messageLabel);
        form.add(RegisterButton);
        form.add(BackButton);
        form.add(ResetButton);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(500, 500);
        form.setLayout(null);
        form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ResetButton) {
            userIDField.setText("");
            userPassword.setText("");
            FirstnameField.setText("");
            LastnameField.setText("");

        }

        if (e.getSource() == BackButton) {
            Login loginPage = new Login();
            form.dispose();
            // Register.setVisible(true);

        }

        if (e.getSource() == RegisterButton) {
            // storing data into a TXT file:
            String username = userIDField.getText();
            String password = userPassword.getText();
            String firstName = FirstnameField.getText();
            String lastName = LastnameField.getText();


            if (isValidUsername(username) && isValidPassword(password)) {
                if (registerUser(username, password, firstName, lastName) != null) {
                    JOptionPane.showMessageDialog(null,
                            "Sign up successful! Your account has been created.");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Failed to create account. Please try again later.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Invalid username or password. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private static boolean isValidUsername(String username) {
        if (username.length() > 5 || !username.contains("_")) {
            JOptionPane.showMessageDialog(null,
                    "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Username successfully captured", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    private static boolean isValidPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        if (!password.matches(pattern)) {
            JOptionPane.showMessageDialog(null,
                    "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Password successfully captured", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }


    private static String registerUser(String username, String password, String firstName,
            String lastName) {
        String filename = "userList.txt";
        try {
            FileWriter fw = new FileWriter(filename, true); // true for append
            fw.write(username + "," + password + "," + firstName + "," + lastName + "\n");
            fw.close();
            return "Success";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
