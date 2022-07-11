package view;

import controller.Controller;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*; 
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import model.User;
import model.CategoryUser;

public class MenuRegistrasi {
    JFrame frame;
    JLabel labelJudul, labelNama, labelEmail, labelPassword, labelFoto, labelPathFoto, labelKategori;
    JTextField textFieldNama, textFieldEmail;
    JPasswordField passwordFieldPass;
    JMenuItem menuItemFileFoto;
    JFileChooser chooseFileFoto;
    File fileFoto;
    JComboBox comboBoxKategori;
    JButton buttonRegistrasi, buttonBack;
    
    public MenuRegistrasi() {
        frame = new JFrame("Menu Registrasi");
        frame.setSize(500, 400);
        
        labelJudul = new JLabel ("Menu Registrasi");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 22));
        labelJudul.setBounds(150, 30, 200, 30);
        
        labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 80, 200, 20);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(105, 80, 200, 20);
        
        labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(15, 105, 200, 20);
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(105, 105, 200, 20);
        
        labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(15, 130, 200, 20);
        passwordFieldPass = new JPasswordField();
        passwordFieldPass.setBounds(105, 130, 200, 20);
        
        labelFoto = new JLabel("Foto: ");
        labelFoto.setBounds(15, 155, 200, 20);
        labelPathFoto = new JLabel();
        labelPathFoto.setBounds(195, 155, 400, 20);
        menuItemFileFoto = new JMenuItem("Pilih Foto: ");
        menuItemFileFoto.setBounds(105, 155, 80, 20);
        menuItemFileFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == menuItemFileFoto) {
                    chooseFileFoto = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                    chooseFileFoto.addChoosableFileFilter(filter);
                    int resultFoto = chooseFileFoto.showSaveDialog(null);
                    if (resultFoto == JFileChooser.APPROVE_OPTION){
                        fileFoto = chooseFileFoto.getSelectedFile();
                        labelPathFoto.setText(fileFoto.getPath());
                    } else if (resultFoto == JFileChooser.CANCEL_OPTION){
                        System.out.println("No File Select");
                    }
                }
            }  
        });
        
        labelKategori = new JLabel("Kategori: ");
        labelKategori.setBounds(15, 180, 200, 20);
        Controller controller = new Controller();
        ArrayList<CategoryUser> kategori = controller.getKategori();
        String[] category = new String[kategori.size()];
        int i = 0;
        for (CategoryUser cate : kategori){
            category[i] = cate.getName();
            i++;
        }
        comboBoxKategori = new JComboBox(category);
        comboBoxKategori.setBounds(105, 180, 200, 20);
        
        buttonRegistrasi = new JButton("Registrasi");
        buttonRegistrasi.setBounds(150, 230, 200, 30);
        buttonRegistrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pw = "";
                char[] password = passwordFieldPass.getPassword();
                if (!textFieldNama.getText().isEmpty()) {
                    if (!textFieldNama.getText().isEmpty() && !password.equals("")) {
                        for (int i = 0; i < password.length; i++) {
                            pw += password[i];
                        }
                        User user = new User(0, textFieldNama.getText(), textFieldEmail.getText(), pw, comboBoxKategori.getSelectedIndex()+1, labelPathFoto.getText());
                        boolean insert = controller.insertNewUser(user);
                        if (insert) {
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                            frame.dispose();
                            new MenuLihatData();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "id/password salah", "registrasi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "nama belum diisi", "registrasi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonBack = new JButton("Back to Main Menu");
        buttonBack.setBounds(150, 265, 200, 30);
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
        frame.add(labelNama);
        frame.add(textFieldNama);
        frame.add(textFieldEmail);
        frame.add(labelPassword);
        frame.add(passwordFieldPass);
        frame.add(labelFoto);
        frame.add(labelPathFoto);
        frame.add(menuItemFileFoto);
        frame.add(labelKategori);
        frame.add(comboBoxKategori);
        frame.add(buttonRegistrasi);
        frame.add(buttonBack);
    }
}
