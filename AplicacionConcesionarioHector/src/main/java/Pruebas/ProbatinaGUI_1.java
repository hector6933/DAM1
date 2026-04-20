package Pruebas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProbatinaGUI_1 {

    static int clicks = 0;

    static JLabel label = new JLabel();

    public static void main(String[] args) {

        JFrame frame = new JFrame("BoxLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton boton = new JButton("Click me");

        label.setText("Clicks: " + clicks);

        panel.add(boton);
        panel.add(label);

// Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        panel.setBorder(new EmptyBorder(20,20,20,20));

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                System.out.println("Clicks: " + clicks);
                label.setText("Clicks: " + clicks);
            }
        });

    }

}
