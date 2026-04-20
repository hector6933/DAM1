package Vista;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static JTextField campoUsername;
    private static JPasswordField campoPasswd;

    private static JButton botonEnviar;


    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setLocationRelativeTo(null);
        frame.setLocation(725,325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3,1));
        frame.setResizable(false);

        // -------------------- INICIO TEXTO INICIAR SESIÓN ----------------------

        JPanel panelRow1 = new JPanel();

        SpringLayout sLayout = new SpringLayout();
        panelRow1.setLayout(sLayout);

        JLabel iniciarSesion = new JLabel("Iniciar sesión");
        iniciarSesion.setFont(new Font("JetBrains Mono",Font.BOLD,30));

        panelRow1.add(iniciarSesion);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, iniciarSesion, 5,
                SpringLayout.HORIZONTAL_CENTER, panelRow1);
        sLayout.putConstraint(SpringLayout.VERTICAL_CENTER, iniciarSesion, 5,
                SpringLayout.VERTICAL_CENTER, panelRow1);

        // -------------------- FIN TEXTO INICIAR SESIÓN ----------------------

        // -------------------- INICIO USERNAME -------------------------------

        JPanel panelLogUsername = new JPanel(new GridLayout(2,1));

        JPanel panelTextoUsername = new JPanel(sLayout);

        JLabel textoUsername = new JLabel("Usuario");

        textoUsername.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelTextoUsername.add(textoUsername);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoUsername, -77,
                SpringLayout.HORIZONTAL_CENTER, panelTextoUsername);
        sLayout.putConstraint(SpringLayout.NORTH, textoUsername, 0,
                SpringLayout.NORTH, panelTextoUsername);

        campoUsername = new JTextField(20);
        panelTextoUsername.add(campoUsername);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoUsername, 185,
                SpringLayout.HORIZONTAL_CENTER, panelLogUsername);
        sLayout.putConstraint(SpringLayout.NORTH, campoUsername, 35,
                SpringLayout.NORTH, panelLogUsername);

        panelLogUsername.add(panelTextoUsername);

        // -------------------- FIN USERNAME ----------------------------------

        // -------------------- INICIO PASSWD ---------------------------------

        JPanel panelLogPasswd = new JPanel(new GridLayout(2,1));

        JPanel panelTextoPasswd = new JPanel(sLayout);

        JLabel textoPasswd = new JLabel("Contraseña");

        textoPasswd.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelTextoPasswd.add(textoPasswd);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoPasswd, -60,
                SpringLayout.HORIZONTAL_CENTER, panelTextoPasswd);
        sLayout.putConstraint(SpringLayout.NORTH, textoPasswd, 0,
                SpringLayout.NORTH, panelTextoPasswd);

        campoPasswd = new JPasswordField(20);
        panelTextoPasswd.add(campoPasswd);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoPasswd, -8,
                SpringLayout.HORIZONTAL_CENTER, panelTextoPasswd);
        sLayout.putConstraint(SpringLayout.NORTH, campoPasswd, 35,
                SpringLayout.NORTH, panelTextoPasswd);

        panelLogPasswd.add(panelTextoPasswd);

        // -------------------- FIN PASSWD ---------------------------------

        frame.add(panelRow1);
        frame.add(panelLogUsername);
        frame.add(panelLogPasswd);

        frame.setVisible(true);

    }

}
