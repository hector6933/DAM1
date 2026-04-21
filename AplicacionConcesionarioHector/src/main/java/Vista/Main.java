package Vista;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static JTextField campoUsername;
    private static JPasswordField campoPasswd;

    private static JButton botonEnviar;


    public static void main(String[] args) {

        int x = 400;
        int y = 400;

        JFrame frame = new JFrame("Login");
        frame.setSize(x, y);
        frame.setLocationRelativeTo(null);
        frame.setLocation( (int) frame.getLocation().getX()-(x/2) ,(int) frame.getLocation().getY()-(y/2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));
        frame.setResizable(true);

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

        JPanel panelLogUsername = new JPanel(new GridLayout(1,1));

        JPanel panelLogin = new JPanel(sLayout);

        JLabel textoUsername = new JLabel("Usuario");

        textoUsername.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelLogin.add(textoUsername);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoUsername, -77,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        sLayout.putConstraint(SpringLayout.NORTH, textoUsername, 0,
                SpringLayout.NORTH, panelLogin);

        campoUsername = new JTextField(20);
        panelLogin.add(campoUsername);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoUsername, 185,
                SpringLayout.HORIZONTAL_CENTER, panelLogUsername);
        sLayout.putConstraint(SpringLayout.NORTH, campoUsername, 35,
                SpringLayout.NORTH, panelLogUsername);

        panelLogUsername.add(panelLogin);

        // -------------------- FIN USERNAME ----------------------------------

        // -------------------- INICIO PASSWD ---------------------------------

        JLabel textoPasswd = new JLabel("Contraseña");

        textoPasswd.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelLogin.add(textoPasswd);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoPasswd, -60,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        sLayout.putConstraint(SpringLayout.NORTH, textoPasswd, 70,
                SpringLayout.NORTH, panelLogin);

        campoPasswd = new JPasswordField(20);
        panelLogin.add(campoPasswd);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoPasswd, -8,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        sLayout.putConstraint(SpringLayout.NORTH, campoPasswd, 100,
                SpringLayout.NORTH, panelLogin);

        // -------------------- FIN PASSWD ---------------------------------

        // -------------------- INICIO BOTON -------------------------------

        JPanel panelBoton = new JPanel(sLayout);

        JButton enviarLogin = new JButton("Enviar");

        panelBoton.add(enviarLogin);

        sLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, enviarLogin, 0,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        sLayout.putConstraint(SpringLayout.SOUTH, enviarLogin, 0,
                SpringLayout.NORTH, panelLogin);

        // -------------------- FIN BOTON -------------------------------

        frame.add(panelRow1);
        frame.add(panelLogUsername);
        frame.add(panelBoton);

        frame.setVisible(true);

    }

}
