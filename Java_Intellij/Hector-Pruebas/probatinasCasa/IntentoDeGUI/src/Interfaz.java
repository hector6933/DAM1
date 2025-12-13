import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz implements ActionListener {

    private int contador = 0;
    private int meta = 100;
    private int multi = 2;
    private JFrame frame;
    private JPanel panel;
    private JButton boton;
    private JLabel textoContador;
    private JLabel textoMeta;
    public Interfaz() {

        frame = new JFrame();

        panel = new JPanel();

        boton = new JButton("Clickame !");

        JCheckBox check = new JCheckBox();

        boton.addActionListener(this);

        textoContador = new JLabel("Contador: 0");
        textoMeta = new JLabel("Meta: " + meta);

        panel.setBorder(BorderFactory.createEmptyBorder(60,60,20,60));
        panel.setLayout(new GridLayout(0,1));
        panel.add(boton);
        panel.add(textoContador);
        panel.add(textoMeta);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Mi interfaz");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main() {

        new Interfaz();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        contador+=multi;
        if (contador >= meta) {

            contador = 0;
            meta *=2;
            multi*=2;

        }
        if (contador <= 0) {

            contador = 0;

        }

        if (multi <= 0) {

            multi = 2;

        }
        textoContador.setText("Contador: " + contador);
        textoMeta.setText("Meta: " + meta);



    }
}
