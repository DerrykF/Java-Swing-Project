
package loginform;

/**
 * 
 * @author lab_service_student
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Login implements ActionListener {

    private static JLabel username;
    private static JLabel password;
    private static JTextField usetext;
    private static JTextField passtext;
    private static JFrame frame;
    private static JPanel panel;
    private static JButton Btnlogin;
    private static JLabel success;
    private static JTextField usertext;

    Login() {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);

        username = new JLabel("Username");
        username.setBounds(10, 20, 165, 25);
        panel.add(username);

        usertext = new JTextField(20);
        usertext.setBounds(100, 20, 100, 25);
        panel.add(usertext);

        password = new JLabel("Password");
        password.setBounds(10, 50, 165, 25);
        panel.add(password);

        passtext = new JTextField(20);
        passtext.setBounds(100, 50, 100, 25);
        panel.add(passtext);

        Btnlogin = new JButton();
        Btnlogin.setText("Login");
        Btnlogin.setBounds(10, 100, 165, 25);
        // Btnlogin.addActionListener((ActionListener) new LoginPage());
        panel.add(Btnlogin);
        Btnlogin.addActionListener(this);

        success = new JLabel();
        success.setBounds(10, 100, 165, 25);
        panel.add(success);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet");
        // Genarated from nbhost/SystemFileSystem/Template/Classes/Code/GeneratedMethodBody
        String username = usertext.getText();
        String password = passtext.getText();
        if (e.getSource() == Btnlogin) {
            TaskPage loginPage = new TaskPage();

            frame.dispose();

        }
        // if (username.length() <= username.contains("_")) {

        // if (password.length() <= password.matches(".*[A-Z]*") && password.matches(".*//.*")
        // && password.matches(".*[,+=';:)(%@#$^!-=)]")) {
        // JOptionPane.ShowMessageDialog(null, "password is accepted");
        // frame.setVisibe(false);

        // } else {
        // jOptionPane.showMessageDialog(null,
        // "password is not correctly formatted, please ensure that the password contains at least 8
        // charecters, a capital letter, a nummber and a special character or username is
        // incorrect");

        // }
        // } else
        // JOptionPane.showMessageDialog(null, "Password or username incorrect");

        // }

    }
}
