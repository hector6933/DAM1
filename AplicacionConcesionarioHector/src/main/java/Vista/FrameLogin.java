package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameLogin extends JFrame {

    public FrameLogin(){

        int x = 400;
        int y = 400;

        setTitle("Login");
        setSize(x, y);
        setLocationRelativeTo(null);
        setLocation( (int) getLocation().getX()-(x/2),(int) getLocation().getY()-(y/2));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        setResizable(false);

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

        JPanel panelLogin = new JPanel();
        SpringLayout slayoutLogin = new SpringLayout();
        panelLogin.setLayout(slayoutLogin);

        JLabel textoUsername = new JLabel("Usuario");

        textoUsername.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelLogin.add(textoUsername);

        slayoutLogin.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoUsername, -77,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        slayoutLogin.putConstraint(SpringLayout.NORTH, textoUsername, 0,
                SpringLayout.NORTH, panelLogin);

        JTextField campoUsername = new JTextField(20);
        panelLogin.add(campoUsername);

        campoUsername.setText("hecprooll"); // BORRAR

        slayoutLogin.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoUsername, -8,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        slayoutLogin.putConstraint(SpringLayout.NORTH, campoUsername, 35,
                SpringLayout.NORTH, panelLogin);

        // -------------------- FIN USERNAME ----------------------------------

        // -------------------- INICIO PASSWD ---------------------------------

        JLabel textoPasswd = new JLabel("Contraseña");

        textoPasswd.setFont(new Font("JetBrains Mono",Font.BOLD,20));

        panelLogin.add(textoPasswd);

        slayoutLogin.putConstraint(SpringLayout.HORIZONTAL_CENTER, textoPasswd, -60,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        slayoutLogin.putConstraint(SpringLayout.NORTH, textoPasswd, 70,
                SpringLayout.NORTH, panelLogin);

        JPasswordField campoPasswd = new JPasswordField(20);
        panelLogin.add(campoPasswd);

        campoPasswd.setText("admin123");

        slayoutLogin.putConstraint(SpringLayout.HORIZONTAL_CENTER, campoPasswd, -8,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        slayoutLogin.putConstraint(SpringLayout.NORTH, campoPasswd, 100,
                SpringLayout.NORTH, panelLogin);

        // -------------------- FIN PASSWD ---------------------------------

        // -------------------- INICIO BOTON -------------------------------

        JPanel panelBoton = new JPanel();
        SpringLayout sLayoutBoton = new SpringLayout();
        panelBoton.setLayout(sLayoutBoton);

        JButton enviarLogin = new JButton("Enviar");

        panelBoton.add(enviarLogin);

        sLayoutBoton.putConstraint(SpringLayout.HORIZONTAL_CENTER, enviarLogin, 180,
                SpringLayout.HORIZONTAL_CENTER, panelLogin);
        sLayoutBoton.putConstraint(SpringLayout.VERTICAL_CENTER, enviarLogin, 50,
                SpringLayout.VERTICAL_CENTER, panelLogin);

        // Esto es para que si le das al enter active el botón y se envie el "formulario" para comprobar las credenciales
        getRootPane().setDefaultButton(enviarLogin);

        enviarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (DataManager.comprobarCredencialesUsuario(campoUsername.getText(),String.valueOf(campoPasswd.getPassword()))) {

                    menu();
                    dispose();


                } else {

                    mostrarErrorCredenciales();

                }

            }
        });

        // -------------------- FIN BOTON -------------------------------

        add(panelRow1);
        add(panelLogin);
        add(panelBoton);
        
    }

    private void menu(){

        FrameMenu menu = new FrameMenu();
        menu.setVisible(true);

    }

    private void mostrarErrorCredenciales() {

        JDialog dialog = new JDialog(this, "Error", true); // true para que bloquee la ventana principal
        dialog.setSize(300, 150);

        // Esto es para que se centre relativamente a la ventana principal
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new GridLayout(2, 1, 10, 10));


        JLabel mensaje = new JLabel("¡¡¡ Credenciales incorrectas !!!", SwingConstants.CENTER);
        mensaje.setFont(new Font("JetBrains Mono", Font.BOLD, 14));


        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonOk = new JButton("Ok");

        // Para que el botón cierre la ventana:
        botonOk.addActionListener(e -> dialog.dispose());

        panelBoton.add(botonOk);

        dialog.add(mensaje);
        dialog.add(panelBoton);

        dialog.setVisible(true);

    }
    
}
