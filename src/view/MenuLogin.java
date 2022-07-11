package view;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*; 
import model.User;
import model.CategoryUser;
import controller.Controller;

public class MenuLogin {
    JFrame frame;
    JLabel labelJudul, labelLogo, labelEmail, labelPassword;
    ImageIcon icon;
    JTextField textFieldEmail;
    JPasswordField passwordFieldPass;
    JButton buttonLogin, buttonBack;
    
    public MenuLogin() {
        frame = new JFrame("Menu Login");
        frame.setSize(500, 450);
        
        labelJudul = new JLabel ("Menu Login");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 22));
        labelJudul.setBounds(170, 30, 200, 30);
        
        labelLogo = new JLabel();
        icon = new ImageIcon ("dota2.jpg");
        labelLogo.setIcon(icon);
        labelLogo.setBounds(155, 80, 150, 80);
        
        labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(15, 180, 200, 20);
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(105, 180, 200, 20);
        
        labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(15, 210, 200, 20);
        passwordFieldPass = new JPasswordField();
        passwordFieldPass.setBounds(105, 210, 200, 20);
        
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(160, 255, 150, 30);
        Controller controller = new Controller();
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = String.valaueOf(passwordFieldPass.getPassword());
                controller.LogIn(textFieldEmail.getText(), pass);
                if (new UserManager().getInstance().getUser() != null) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    new MenuLihatData();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "login gagal", "registrasi", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        buttonBack = new JButton("Back to Main Menu");
        buttonBack.setBounds(160, 305, 150, 30);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenu();
            }
        });
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(labelJudul);
        frame.add(labelLogo);
        frame.add(labelEmail);
        frame.add(textFieldEmail);
        frame.add(labelPassword);
        frame.add(passwordFieldPass);
        frame.add(buttonLogin);
        frame.add(buttonBack);
    }
}
