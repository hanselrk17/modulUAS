package view;

import controller.Controller;
import javax.swing.*;
import java.awt.*;

public class hasilLihatData {
    JFrame frame;
    JPanel hasilPanel;
    JTable tabelUser;
    JScrollPane scroll;
    public hasilLihatData(int kategori){
        frame = new JFrame("Tampilkan data");
        frame.setSize(600, 600);
        
        Controller controller = new Controller();
        String [][] dataUser = controller.konversiListToArray(controller.getAllUsers(kategori));
        String hasil[] = {"idUser", "Nama", "Email", "Password", "idCategory", "pathFoto"};

        tabelUser = new JTable(dataUser, hasil);
        scroll = new JScrollPane(tabelUser);
        scroll.setBounds(0, 0, 580, 500);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        hasilPanel = new JPanel(null);
        hasilPanel.add(scroll);
        frame.setContentPane(hasilPanel);
    }
}