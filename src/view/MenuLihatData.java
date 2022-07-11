package view;

import controller.Controller;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*; 
import model.User;
import model.CategoryUser;

public class MenuLihatData {
    JFrame frame;
    JLabel labelJudul, labelKategori;
    JComboBox comboBoxKategori;
    JButton buttonSearch, buttonBack;
    
    public MenuLihatData() {
        frame = new JFrame("Lihat Data");
        frame.setSize(500, 300);
        
        labelJudul = new JLabel ("Menu Lihat Data");
        labelJudul.setFont(new Font("Arial", Font.BOLD, 22));
        labelJudul.setBounds(160, 30, 200, 30);
        
        labelKategori = new JLabel("Kategori: ");
        labelKategori.setBounds(15, 80, 200, 20);
        Controller controller = new Controller();
        ArrayList<CategoryUser> kategori = controller.getKategori();
        String[] category = new String[kategori.size()];
        int i = 0;
        for (CategoryUser cat : kategori){
            category[i] = cat.getName();
            i++;
        }
        comboBoxKategori = new JComboBox(category);
        comboBoxKategori.setBounds(105, 80, 200, 20);
        
        buttonSearch = new JButton("Search");
        buttonSearch.setBounds(150,140,200,30);
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new hasilLihatData(comboBoxKategori.getSelectedIndex()+1);
            }
        });
        
        buttonBack = new JButton("Back to Main Menu");
        buttonBack.setBounds(150, 175, 200, 30);
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
        frame.add(labelKategori);
        frame.add(comboBoxKategori);
        frame.add(buttonSearch);
        frame.add(buttonBack);
    }
}
