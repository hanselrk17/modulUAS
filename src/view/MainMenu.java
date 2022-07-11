package view;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*; 
import model.User;
import model.CategoryUser;

public class MainMenu implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel labelJudul;
    JButton buttonLogin, buttonRegistrasi, buttonLihatData;
    
    public MainMenu() {
        frame = new JFrame ("Menu");
        frame.setSize (500, 350);
        
        panel = new JPanel();
        panel.setSize (500, 350);
        panel.setBackground(Color.orange);
        
        Font font = new Font("Arial", Font.BOLD, 22);
        
        labelJudul = new JLabel ("Main Menu");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 26));
        labelJudul.setBounds(175, 20, 150, 30);
        
        buttonLogin = new JButton("Login");
        buttonLogin.setFont(font);
        buttonLogin.setBounds (150, 80, 190, 40);
        
        buttonRegistrasi = new JButton("Registrasi");
        buttonRegistrasi.setFont(font);
        buttonRegistrasi.setBounds (150, 140, 190, 40);
        
        buttonLihatData = new JButton("Lihat Data");
        buttonLihatData.setFont(font);
        buttonLihatData.setBounds (150, 200, 190, 40);
        
        buttonLogin.addActionListener(this);
        buttonRegistrasi.addActionListener(this);
        buttonLihatData.addActionListener(this);
        
        panel.add(labelJudul);
        panel.add(buttonLogin);
        panel.add(buttonRegistrasi);
        panel.add(buttonLihatData);
        
        frame.add(panel);
        
        panel.setLayout(null);
        panel.setVisible(true);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Login": 
                new MenuLogin();
                break;
            case "Registrasi":
                new MenuRegistrasi();
                break;
            case "Lihat Data":
                
                break;
            default: 
                break;
        }
    }
}