package Pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProbatinaGUI_2 {

    static int clicks = 0;

    static JLabel label = new JLabel();

    public static void main(String[] args) {

        JFrame frame = new JFrame("GridBagLayout Example");

        frame.setLocationRelativeTo(null);
        frame.setLocation(725,325);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        JButton boton = new JButton("Click me");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                System.out.println("Clicks: " + clicks);
                label.setText("Clicks: " + clicks);
            }
        });

        label.setText("Clicks: " + clicks);

        frame.add(boton, constraints);
        constraints.gridy = 10;
        frame.add(label, constraints);

        frame.setVisible(true);

    }

}
