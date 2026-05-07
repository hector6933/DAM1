package Vista;

import Controlador.*;
import Modelo.*;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrameMenu extends JFrame {

    private JPanel panelTabla;
    private JTable tablaActual;
    private String entidadActual;
    private JButton btnEliminar;

    private JButton btnEmpleados;
    private JButton btnDepartamentos;
    private JButton btnVehiculos;
    private JButton btnClientes;
    private JButton btnUsuarios;

    public FrameMenu() {

        setTitle("Menú");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------------------- BOTONES SUPERIORES --------------------
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnEmpleados = new JButton("Empleados");
        btnDepartamentos = new JButton("Departamentos");
        btnVehiculos = new JButton("Vehículos");
        btnClientes = new JButton("Clientes");
        btnUsuarios = new JButton("Usuarios");

        panelBotones.add(btnEmpleados);
        panelBotones.add(btnDepartamentos);
        panelBotones.add(btnVehiculos);
        panelBotones.add(btnClientes);
        panelBotones.add(btnUsuarios);

        add(panelBotones, BorderLayout.NORTH);

        // -------------------- PANEL TABLA --------------------
        panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // padding inferior
        add(panelTabla, BorderLayout.CENTER);

        // -------------------- BOTONES INFERIORES --------------------
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton btnInsertar = new JButton("Insertar");
        JButton btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");

        panelAcciones.add(btnInsertar);
        panelAcciones.add(btnModificar);
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnActualizar);

        add(panelAcciones, BorderLayout.SOUTH);

        // -------------------- LISTENERS SUPERIORES --------------------
        btnEmpleados.addActionListener(e -> {

            entidadActual = "empleado";
            resaltarBoton(btnEmpleados);
            mostrarTabla(obtenerModeloEmpleados());

        });

        btnDepartamentos.addActionListener(e -> {

            entidadActual = "departamento";
            resaltarBoton(btnDepartamentos);
            mostrarTabla(obtenerModeloDepartamentos());

        });

        btnVehiculos.addActionListener(e -> {

            entidadActual = "vehiculo";
            resaltarBoton(btnVehiculos);
            mostrarTabla(obtenerModeloVehiculos());

        });

        btnClientes.addActionListener(e -> {

            entidadActual = "cliente";
            resaltarBoton(btnClientes);
            mostrarTabla(obtenerModeloClientes());

        });

        btnUsuarios.addActionListener(e -> {

            entidadActual = "usuario";
            resaltarBoton(btnUsuarios);
            mostrarTabla(obtenerModeloUsuarios());

        });

        // -------------------- LISTENER ELIMINAR --------------------
        btnEliminar.addActionListener(e -> eliminarSeleccionado());

        // -------------------- LISTENER INSERTAR --------------------
        btnInsertar.addActionListener(e -> {

            if (entidadActual == null) {

                JOptionPane.showMessageDialog(this, "Selecciona una entidad primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;

            }

            switch (entidadActual) {

                case "cliente" -> mostrarDialogoInsertarCliente();
                case "usuario" -> mostrarDialogoInsertarUsuario();
                case "departamento" -> mostrarDialogoInsertarDepartamento();
                case "empleado" -> mostrarDialogoInsertarEmpleado();
                case "vehiculo" -> mostrarDialogoInsertarVehiculo();
                default ->
                        JOptionPane.showMessageDialog(this, "Inserción de esta entidad aún no implementada.", "Aviso", JOptionPane.WARNING_MESSAGE);

            }

        });

        // -------------------- LISTENER MODIFICAR --------------------
        btnModificar.addActionListener(e -> {

            if (entidadActual == null) {

                JOptionPane.showMessageDialog(this, "Selecciona una entidad primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;

            }

            switch (entidadActual) {

                case "cliente" -> mostrarDialogoModificarCliente();
                default ->
                        JOptionPane.showMessageDialog(this, "Modificación de esta entidad aún no implementada.", "Aviso", JOptionPane.WARNING_MESSAGE);

            }

        });

        // -------------------- LISTENER ACTUALIZAR --------------------
        btnActualizar.addActionListener(e -> {

            if (entidadActual == null) {

                JOptionPane.showMessageDialog(this, "Selecciona una entidad primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;

            }

            switch (entidadActual) {

                case "empleado" -> mostrarTabla(obtenerModeloEmpleados());
                case "departamento" -> mostrarTabla(obtenerModeloDepartamentos());
                case "vehiculo" -> mostrarTabla(obtenerModeloVehiculos());
                case "cliente" -> mostrarTabla(obtenerModeloClientes());
                case "usuario" -> mostrarTabla(obtenerModeloUsuarios());

            }
        });

        // -------------------- CERRAR VENTANA LISTENER --------------------
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                dispose();
                new FrameLogin().setVisible(true);

            }
        });
    }

    // -------------------- ELIMINAR --------------------
    private void eliminarSeleccionado() {

        // Compruebo que hay una tabla/entidad seleccionada
        // En caso de que no la haya muestro una ventana de aviso
        if (tablaActual == null || entidadActual == null) {

            JOptionPane.showMessageDialog(this, "Selecciona una entidad primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;

        }

        // Si la tupla seleccionada es -1 significa que no hay ninguna seleccionada por lo que muestro un aviso
        int filaSeleccionada = tablaActual.getSelectedRow();
        if (filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;

        }

        // Cojo la clave primaria que está en la primera columna de cada entidad
        Object clavePrimaria = tablaActual.getValueAt(filaSeleccionada, 0);

        // Panel de confirmación antes de eliminar
        // La ventana de confirmación devuelve 0 en caso de eliga Yes y 1 en caso de que eliga No
        int confirmar = JOptionPane.showConfirmDialog(

                this,
                "¿Seguro que quieres eliminar el registro con clave: " + clavePrimaria + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION

        );

        if (confirmar != JOptionPane.YES_OPTION) return;

        try { // Todos los métdoos van a devolver un boolean dependiendo de si se ha podido eliminar o no, por lo que puedo hacer un switch pro

            boolean eliminado = switch (entidadActual) {

                case "empleado" -> EmpleadoController.borrarEmpleado((Integer) clavePrimaria);
                case "departamento" -> DepartamentoController.borrarDepartamento((Integer) clavePrimaria);
                case "vehiculo" -> VehiculoController.borrarVehiculo((String) clavePrimaria);
                case "cliente" -> ClienteController.borrarCliente((String) clavePrimaria);
                case "usuario" -> UsuarioController.borrarUsuario((Integer) clavePrimaria);
                default -> false;

            };

            // En caso de que se elimine correcatmente muestro una ventana indicandolo y vuelvo a construir la tabla con los nuevos registros
            if (eliminado) {

                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Actualización de la tabla:
                switch (entidadActual) {

                    case "empleado" -> mostrarTabla(obtenerModeloEmpleados());
                    case "departamento" -> mostrarTabla(obtenerModeloDepartamentos());
                    case "vehiculo" -> mostrarTabla(obtenerModeloVehiculos());
                    case "cliente" -> mostrarTabla(obtenerModeloClientes());
                    case "usuario" -> mostrarTabla(obtenerModeloUsuarios());

                }

            } else {

                // En caso de que por algún motivo no se haya podido borrar la entidad muestro un panel indicándolo
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro.", "Error", JOptionPane.ERROR_MESSAGE);

            }

            // Si hay algún error con la conexión en la base de datos o un error SQL lo atrapo y lo muestro en un dialog
        } catch (SQLException ex) {

            mostrarErrorBD(ex);

        }
    }

    // -------------------- MOSTRAR TABLA --------------------
    private void mostrarTabla(DefaultTableModel modelo) {

        panelTabla.removeAll(); // Vacio el panel para meter nuevos elementos
        tablaActual = null; // La pongo a null en caso de que si no hay ningún registro en el modelo que no se quede con el modelo anterior

        if (modelo.getRowCount() == 0) {

            JLabel sinDatos = new JLabel("¡ No hay registros en la base de datos !", SwingConstants.CENTER);
            sinDatos.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
            panelTabla.add(sinDatos, BorderLayout.CENTER);

        } else {

            tablaActual = new JTable(modelo) { // Estos corchetes son para modificar o personalizar métodos y atributos de la clase original al objeto que voy a crear

                // Sobreescribo el método isCellEditable para el usuario NO pueda editar las celdas de las tablas
                @Override
                public boolean isCellEditable(int row, int column) {

                    return false;

                }

            };

            // KeyListnener para que si le da a la tecla suprimir accione el botón btnEliminar
            tablaActual.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                        btnEliminar.doClick();
                    }
                }
            });

            JScrollPane scroll = new JScrollPane(tablaActual);
            scroll.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            panelTabla.add(scroll, BorderLayout.CENTER);

        }

        panelTabla.revalidate();
        panelTabla.repaint();
    }

    // -------------------- EMPLEADO --------------------
    private DefaultTableModel obtenerModeloEmpleados() {

        String[] columnas = {"Nº Empleado", "Nombre", "Apellidos", "Teléfono", "F. Nacimiento", "Nº Gerente", "Nº Dep.", "ID Usuario"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {

            List<Empleado> lista = EmpleadoController.verEmpleados();

            if (lista == null) return modelo;

            for (Empleado e : lista) {

                modelo.addRow(new Object[]{

                        e.getNumEmpleado(),
                        e.getNombre(),
                        e.getApellidos(),
                        e.getTelefono(),
                        e.getFechaNacimiento(),
                        e.getNumGerente(),
                        e.getNumDep(),
                        e.getId_usuario(),

                });

            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        }

        return modelo;
    }

    // -------------------- DEPARTAMENTO --------------------
    private DefaultTableModel obtenerModeloDepartamentos() {

        String[] columnas = {"Nº Departamento", "Nombre"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {

            List<Departamento> lista = DepartamentoController.verDepartamentos();

            if (lista == null) return modelo;

            for (Departamento d : lista) {
                modelo.addRow(new Object[]{

                        d.getNumDep(),
                        d.getNombre()
                });
            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        }

        return modelo;
    }

    // -------------------- VEHÍCULO --------------------
    private DefaultTableModel obtenerModeloVehiculos() {

        String[] columnas = {"Matrícula", "Marca", "Modelo", "Combustible", "Precio", "DNI Cliente", "Nº Empleado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {

            List<Vehiculo> lista = VehiculoController.verVehiculos();

            if (lista == null) return modelo;

            for (Vehiculo v : lista) {
                modelo.addRow(new Object[]{

                        v.getMatricula(),
                        v.getMarca(),
                        v.getModelo(),
                        v.getTipoCombustible(),
                        v.getPrecio(),
                        v.getDniCliente(),
                        v.getNumEmpleado()
                });
            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        }

        return modelo;
    }

    // -------------------- CLIENTE --------------------
    private DefaultTableModel obtenerModeloClientes() {

        String[] columnas = {"DNI", "Nombre", "Apellidos", "Teléfono"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {

            List<Cliente> lista = ClienteController.verClientes();

            if (lista == null) return modelo;

            for (Cliente c : lista) {
                modelo.addRow(new Object[]{

                        c.getDni(),
                        c.getNombre(),
                        c.getApellidos(),
                        c.getTelefono()
                });
            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        }

        return modelo;
    }

    // -------------------- USUARIO --------------------
    private DefaultTableModel obtenerModeloUsuarios() {

        String[] columnas = {"ID", "Nombre", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {

            List<Usuario> lista = UsuarioController.verUsuarios();

            if (lista == null) return modelo;

            for (Usuario u : lista) {
                modelo.addRow(new Object[]{

                        u.getId(),
                        u.getNombre(),
                        u.getRol()
                });
            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        }

        return modelo;
    }

    // Ventana con el error SQL en caso de que falle alguna conexion o algún error SQL en la base de datos
    private void mostrarErrorBD(SQLException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Error al conectar con la base de datos:\n" + ex.getMessage(),
                "Error BD",
                JOptionPane.ERROR_MESSAGE
        );

    }

    private void dialogError(String error) {

        JOptionPane.showMessageDialog(
                this,
                error,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );

    }

    private void mostrarDialogoInsertarCliente() {

        // Me creo el dialog principal con sus respectivas características para la insercción del ciente
        JDialog dialog = new JDialog(this, "Insertar Cliente", true);
        dialog.setSize(420, 380);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);

        JTextField campoDni = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoApellidos = new JTextField();
        JTextField campoTelefono = new JTextField();

        // Labels de error para cada campo
        JLabel errDni = crearLabelError();
        JLabel errNombre = crearLabelError();
        JLabel errApellidos = crearLabelError();
        JLabel errTelefono = crearLabelError();

        // ---- DNI ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("DNI:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoDni, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(errDni, gbc);

        // ---- Nombre ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errNombre, gbc);

        // ---- Apellidos ----
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoApellidos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelForm.add(errApellidos, gbc);

        // ---- Teléfono ----
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panelForm.add(errTelefono, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recogo los campos introducidos por el usuario
            String dni = campoDni.getText().trim();
            String nombre = campoNombre.getText().trim();
            String apellidos = campoApellidos.getText().trim();
            String telefono = campoTelefono.getText().trim();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoDni, errDni);
            limpiarError(campoNombre, errNombre);
            limpiarError(campoApellidos, errApellidos);
            limpiarError(campoTelefono, errTelefono);

            boolean hayError = false;

            if (!Cliente.validarDni(dni)) {

                mostrarError(campoDni, errDni, "Formato inválido. Ej: 12345678A");
                hayError = true;

            } else {

                try {

                    if (!DataManager.comprobarDni(dni)) {

                        mostrarError(campoDni, errDni, "Ya existe un cliente con ese DNI.");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);
                    return;

                }
            }

            if (!DataManager.validarNombre(nombre, 3, 20)) {

                mostrarError(campoNombre, errNombre, "Mínimo 3 y máximo 20 letras.");
                hayError = true;

            }

            if (!DataManager.validarApellidos(apellidos)) {

                mostrarError(campoApellidos, errApellidos, "Mínimo 3 y máximo 50 letras.");
                hayError = true;

            }

            if (!DataManager.validartelefono(telefono)) {

                mostrarError(campoTelefono, errTelefono, "Formato inválido. Tiene que ser 9 números");
                hayError = true;

            }

            if (hayError) return; // si hay algún error no continuamos, el return sale el action listener

            try {

                boolean insertado = ClienteController.insertarCliente(new Cliente(dni, nombre, apellidos, telefono)); // Intento insertar el cliente con los datos proporcionados

                if (insertado) {

                    // En caso de que se inserte muestro un dialog y cuando le de a OK salgo del dialog principal,
                    JOptionPane.showMessageDialog(dialog, "Cliente insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    // Actualizo la tabla con los nuevos registros una vez insertado el cliente
                    mostrarTabla(obtenerModeloClientes());

                } else {

                    // En caso de que no se haya podido insertar el cliente muestro un error en un dialog
                    JOptionPane.showMessageDialog(dialog, "No se pudo insertar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                // En caso de que haya habido algún error SQL o con la conexión a la base de datos lo muestro en un dialog
                mostrarErrorBD(ex);

            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogoInsertarUsuario() {

        // Me creo el dialog principal con sus respectivas características para la inserción del usuario
        JDialog dialog = new JDialog(this, "Insertar Usuario", true);
        dialog.setSize(500, 380);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);

        JLabel campoId = new JLabel();
        JTextField campoNombre = new JTextField();
        JPasswordField campoPasswd = new JPasswordField();

        // El objeto comobox es un desplegable a partir de un array de strings
        // El primer valor es el que se pone por defecto, entonces si el usuario no elige nada validaré si el primer valor está seleccionado
        JComboBox<String> campoRol = new JComboBox<>(new String[]{"-- Selecciona un rol --", "Admin", "Gerente", "Empleado"});

        // Labels de error para cada campo
        JLabel rellenoId = crearLabelError();
        JLabel errNombre = crearLabelError();
        JLabel errPasswd = crearLabelError();
        JLabel errRol = crearLabelError();

        // ---- ID ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoId, gbc);

        try {

            campoId.setText(String.valueOf(DataManager.getUltimoIdUsuario() + 1));

        } catch (SQLException e) {

            mostrarErrorBD(e);
            return;

        }

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(rellenoId, gbc);

        // ---- Nombre ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errNombre, gbc);

        // ---- Contraseña ----
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoPasswd, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelForm.add(errPasswd, gbc);

        // ---- ROL ----
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Rol:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoRol, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panelForm.add(errRol, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recogo los campos introducidos por el usuario
            String nombre = campoNombre.getText().trim();
            String passwd = String.valueOf(campoPasswd.getPassword()).trim();
            String rol = (String) campoRol.getSelectedItem();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoNombre, errNombre);
            limpiarError(campoPasswd, errPasswd);
            limpiarError(campoRol, errRol);

            boolean hayError = false;

            if (!Usuario.validarUsername(nombre, 3, 20)) {

                mostrarError(campoNombre, errNombre, "Mínimo 3 y máximo 20 letras.");
                hayError = true;

            } else {

                try {

                    if (DataManager.comprobarUsername(nombre)) {

                        mostrarError(campoNombre, errNombre, "¡ Ese nombre de usuario ya existe !");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);
                    return;

                }

            }

            if (!Usuario.validarPasswd(passwd)) {

                mostrarError(campoPasswd, errPasswd, "Requisitos: 8 carácteres, 1 mayúscula, 1 carácter especial y 1 número");
                hayError = true;

            }

            if (rol.equals("-- Selecciona un rol --")) {

                mostrarError(campoRol, errRol, "¡ Selecciona un rol !");
                hayError = true;

            }

            if (hayError) return; // si hay algún error no continuamos por lo que salimos del action listener

            try {

                boolean insertado = UsuarioController.insertarUsuario(new Usuario(nombre, passwd, rol)); // Intento insertar el usuario con los datos proporcionados

                if (insertado) {

                    // En caso de que se inserte muestro un dialog y cuando le de a OK salgo del dialog principal,
                    JOptionPane.showMessageDialog(dialog, "Usuario insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    // Actualizo la tabla con los nuevos registros una vez insertado el usuario
                    mostrarTabla(obtenerModeloUsuarios());

                } else {

                    // En caso de que no se haya podido insertar el usuario muestro un error en un dialog
                    JOptionPane.showMessageDialog(dialog, "No se pudo insertar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                // En caso de que haya habido algún error SQL o con la conexión a la base de datos lo muestro en un dialog
                mostrarErrorBD(ex);

            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogoInsertarDepartamento() {

        // Me creo el dialog principal con sus respectivas características para la insercción del departamento
        JDialog dialog = new JDialog(this, "Insertar Departamento", true);
        dialog.setSize(280, 240);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);

        JLabel campoId = new JLabel();
        JTextField campoNombre = new JTextField();

        // Labels de error para cada campo
        JLabel rellenoId = crearLabelError();
        JLabel errNombre = crearLabelError();

        // ---- ID ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoId, gbc);

        try {

            campoId.setText(String.valueOf(DataManager.getUltimoNumDep() + 1));

        } catch (SQLException e) {

            mostrarErrorBD(e);
            return;

        }

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(rellenoId, gbc);

        // ---- Nombre ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errNombre, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recogo los campos introducidos por el usuario
            String nombre = campoNombre.getText().trim();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoNombre, errNombre);

            boolean hayError = false;

            if (!DataManager.validarNombre(nombre, 2, 50)) {

                mostrarError(campoNombre, errNombre, "Mínimo 2 y máximo 50 letras.");
                hayError = true;

            } else {

                try {

                    if (DataManager.comprobarNombreDepartamento(nombre)) {

                        mostrarError(campoNombre, errNombre, "¡ Ese departamento YA existe !");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);

                }

            }

            if (hayError) return; // si hay algún error no continuamos, el return sale el action listener

            try {

                boolean insertado = DepartamentoController.insertarDepartamento(new Departamento(nombre));  // Intento insertar el departamento con los datos proporcionados

                if (insertado) {

                    // En caso de que se inserte muestro un dialog y cuando le de a OK salgo del dialog principal,
                    JOptionPane.showMessageDialog(dialog, "Departamento insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    // Actualizo la tabla con los nuevos registros una vez insertado el departamento
                    mostrarTabla(obtenerModeloDepartamentos());

                } else {

                    // En caso de que no se haya podido insertar el departamento muestro un error en un dialog
                    JOptionPane.showMessageDialog(dialog, "No se pudo insertar el departamento.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                // En caso de que haya habido algún error SQL o con la conexión a la base de datos lo muestro en un dialog
                mostrarErrorBD(ex);

            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogoInsertarEmpleado() {

        // Me creo el dialog principal con sus respectivas características para la insercción del empleado
        JDialog dialog = new JDialog(this, "Insertar Empleado", true);
        dialog.setSize(450, 410);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);

        // Configuración del campo de fecha para que la edad solo pueda estar comprendida entre 100 y 16 años
        DatePickerSettings config = new DatePickerSettings();

        JLabel numEmp = new JLabel();
        JTextField campoNombre = new JTextField();
        JTextField campoApellidos = new JTextField();
        JTextField campoTelef = new JTextField();
        DatePicker campoFechaNacimiento = new DatePicker(config);
        JComboBox<String> campoGerente = new JComboBox<>();
        JComboBox<String> campoDep = new JComboBox<>();
        JTextField campoIdUsuario = new JTextField();

        // Tengo que aplicar la configuración después de construir el DatePicker con el config porque si no me da error
        config.setDateRangeLimits(LocalDate.now().minusYears(100), LocalDate.now().minusYears(16));
        config.setDefaultYearMonth(YearMonth.now().minusYears(26));

        campoGerente.addItem("-- Selecciona un gerente --");
        try {

            for (Empleado e : DataManager.getGerentes()) {

                campoGerente.addItem(e.getNumEmpleado() + " | " + e.getNombre() + " " + e.getApellidos());

            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        } catch (NullPointerException e) {

            dialogError("¡ No hay gerentes disponibles !");
            dispose();

        }

        campoDep.addItem("-- Selecciona un departamento --");
        try {

            for (Departamento e : DepartamentoController.verDepartamentos()) {

                campoDep.addItem(e.getNumDep() + " | " + e.getNombre());

            }

        } catch (SQLException e) {

            mostrarErrorBD(e);

        } catch (NullPointerException e) {

            dialogError("¡ No hay departamentos disponibles !");
            dispose();

        }

        // Labels de error para cada campo
        JLabel rellenoNumEmp = crearLabelError();
        JLabel errNombre = crearLabelError();
        JLabel errApellidos = crearLabelError();
        JLabel errTelef = crearLabelError();
        JLabel errFecha = crearLabelError();
        JLabel errGerente = crearLabelError();
        JLabel errDep = crearLabelError();
        JLabel errIdUsuario = crearLabelError();

        // ---- Nombre ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(errNombre, gbc);

        // ---- Apellidos ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoApellidos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errApellidos, gbc);

        // ---- Telefono ----
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoTelef, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelForm.add(errTelef, gbc);

        // ---- Fecha de nacimiento ----
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Fecha de nacimiento:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoFechaNacimiento, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panelForm.add(errFecha, gbc);

        // ---- Num gerente ----
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Gerente:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoGerente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panelForm.add(errGerente, gbc);

        // ---- Num departamento ----
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Departamento:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoDep, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        panelForm.add(errDep, gbc);

        // ---- ID Usuario ----
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 0;
        panelForm.add(new JLabel("ID Usuario:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoIdUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        panelForm.add(errIdUsuario, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recogo los campos introducidos por el usuario
            String nombre = campoNombre.getText().trim();
            String apellidos = campoApellidos.getText().trim();
            String telefono = campoTelef.getText().trim();
            LocalDate fechaNacimiento = campoFechaNacimiento.getDate();
            String gerente = (String) campoGerente.getSelectedItem();
            String dep = (String) campoDep.getSelectedItem();
            String idUsuario = campoIdUsuario.getText().trim();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoNombre, errNombre);
            limpiarError(campoApellidos, errApellidos);
            limpiarError(campoTelef, errTelef);
            limpiarError(errFecha);
            limpiarError(campoGerente, errGerente);
            limpiarError(campoDep, errDep);
            limpiarError(campoIdUsuario, errIdUsuario);

            boolean hayError = false;

            if (!DataManager.validarNombre(nombre, 3, 20)) {

                mostrarError(campoNombre, errNombre, "Mínimo 3 y máximo 20 letras.");
                hayError = true;

            }

            if (!DataManager.validarApellidos(apellidos)) {

                mostrarError(campoApellidos, errApellidos, "Mínimo 3 y máximo 50 letras.");
                hayError = true;

            }

            if (!DataManager.validartelefono(telefono)) {

                mostrarError(campoTelef, errTelef, "Formato inválido. Tiene que ser 9 Números");
                hayError = true;

            }

            if (campoFechaNacimiento.getDate() == null || !DataManager.validarFechaNacimiento(campoFechaNacimiento.getDate())) {

                mostrarError(errFecha, "La edad debe estar comprendida entre 16 y 100 años");
                hayError = true;

            }

            Integer numGerente = 0;
            if (gerente.equals("-- Selecciona un gerente --")) {

                mostrarError(campoGerente, errGerente, "Selecciona un gerente");
                hayError = true;

            } else {

                Matcher encontrarNum = Pattern.compile("^(\\d+)").matcher(gerente);

                if (encontrarNum.find()) {

                    numGerente = Integer.parseInt(encontrarNum.group());

                }

            }

            Integer numDep = 0;
            if (dep.equals("-- Selecciona un departamento --")) {

                mostrarError(campoDep, errDep, "Selecciona un departamento");
                hayError = true;

            } else {

                Matcher encontrarNum = Pattern.compile("^(\\d+)").matcher(dep);

                if (encontrarNum.find()) {

                    numDep = Integer.parseInt(encontrarNum.group());

                }


            }

            Integer idUsuarioInt = 0;
            try {

                idUsuarioInt = Integer.parseInt(idUsuario);

                try {

                    if (!DataManager.comprobarIdUsuario(idUsuarioInt)) {

                        mostrarError(campoIdUsuario, errIdUsuario, "Ese ID de usuario NO existe");
                        hayError = true;

                    } else if (DataManager.comprobarIdUsuarioEmpleado(idUsuarioInt)) {

                        mostrarError(campoIdUsuario, errIdUsuario, "Ese ID de usuario YA está asignado");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);
                    return;

                }

            } catch (NumberFormatException ex) {

                mostrarError(campoIdUsuario, errIdUsuario, "Introduce un número válido");
                hayError = true;

            }

            if (hayError) return; // si hay algún error no continuamos, el return sale el action listener

            try {

                boolean insertado = EmpleadoController.insertarEmpleado(new Empleado(nombre, apellidos, telefono, Date.valueOf(fechaNacimiento), numGerente, numDep, idUsuarioInt)); // Intento insertar el Empleado con los datos proporcionados

                if (insertado) {

                    // En caso de que se inserte muestro un dialog y cuando le de a OK salgo del dialog principal,
                    JOptionPane.showMessageDialog(dialog, "Empleado insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    // Actualizo la tabla con los nuevos registros una vez insertado el empleado
                    mostrarTabla(obtenerModeloEmpleados());

                } else {

                    // En caso de que no se haya podido insertar el empleado muestro un error en un dialog
                    JOptionPane.showMessageDialog(dialog, "No se pudo insertar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                // En caso de que haya habido algún error SQL o con la conexión a la base de datos lo muestro en un dialog
                mostrarErrorBD(ex);

            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogoInsertarVehiculo() {

        // Me creo el dialog principal con sus respectivas características para la insercción del vehículo
        JDialog dialog = new JDialog(this, "Insertar Vehículo", true);
        dialog.setSize(450, 410);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);


        JTextField campoMatricula = new JTextField();

        JComboBox<String> campoMarca = new JComboBox<>(new String[]{"-- Selecciona una marca --","Toyota", "Volkswagen", "Ford", "Honda", "Chevrolet", "Nissan",
                "Hyundai", "Kia", "Mercedes-Benz", "BMW", "Audi", "Peugeot",
                "Renault", "Citroën", "Fiat", "Jeep", "Dodge", "Chrysler",
                "Tesla", "Volvo", "Mazda", "Subaru", "Mitsubishi", "Suzuki",
                "Lexus", "Infiniti", "Acura", "Porsche", "Ferrari", "Lamborghini",
                "Bentley", "Rolls-Royce", "Aston Martin", "Jaguar", "Land Rover",
                "Mini", "Alfa Romeo", "Maserati", "Bugatti", "McLaren",
                "Pagani", "Koenigsegg", "Cupra", "SEAT", "Skoda", "Dacia",
                "Opel", "Vauxhall", "Genesis", "Rivian", "Lucid Motors",
                "BYD", "Geely", "Chery", "Great Wall", "Haval", "NIO",
                "XPeng", "Polestar", "Saab"});

        JTextField campoModelo = new JTextField();
        JComboBox<String> campoTipoCombust = new JComboBox<>(new String[]{"-- Selecciona un combustible --","Gasolina", "Diésel","GLP", "GNC", "Eléctrico", "Hidrógeno", "Biocombustibles"});
        JTextField campoPrecio = new JTextField();
        JTextField campoDniCliente = new JTextField();
        JTextField campoNumEmp = new JTextField();

        // Labels de error para cada campo
        JLabel errMatricula = crearLabelError();
        JLabel errMarca = crearLabelError();
        JLabel errModelo = crearLabelError();
        JLabel errTipoCombust = crearLabelError();
        JLabel errPrecio = crearLabelError();
        JLabel errDniCliente = crearLabelError();
        JLabel errNumEmp = crearLabelError();

        // ---- Matrícula ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Matrícula:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoMatricula, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(errMatricula, gbc);

        // ---- Marca ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Marca:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoMarca, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errMarca, gbc);

        // ---- Modelo ----
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Modelo:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoModelo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelForm.add(errModelo, gbc);

        // ---- Tipo combustible----
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Tipo combustible:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoTipoCombust, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panelForm.add(errTipoCombust, gbc);

        // ---- Precio ----
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoPrecio, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panelForm.add(errPrecio, gbc);

        // ---- DNI Cliente ----
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0;
        panelForm.add(new JLabel("DNI Cliente:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoDniCliente, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        panelForm.add(errDniCliente, gbc);

        // ---- Num Empleado ----
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Num Empleado:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNumEmp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        panelForm.add(errNumEmp, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recojo los campos introducidos por el usuario
            String matricula = campoMatricula.getText().trim();
            String marca = (String) campoMarca.getSelectedItem();
            String modelo = campoModelo.getText().trim();
            String combustible = (String) campoTipoCombust.getSelectedItem();
            String precio  = campoPrecio.getText().trim();
            String dniCliente = campoDniCliente.getText().trim();
            String numEmp = campoNumEmp.getText().trim();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoMatricula, errMatricula);
            limpiarError(campoMarca, errMarca);
            limpiarError(campoModelo, errModelo);
            limpiarError(campoTipoCombust, errTipoCombust);
            limpiarError(campoPrecio, errPrecio);
            limpiarError(campoDniCliente, errDniCliente);
            limpiarError(campoNumEmp, errNumEmp);

            boolean hayError = false;

            try {

                if (!Vehiculo.validarMatricula(matricula)) {

                    mostrarError(campoMatricula, errMatricula, "Formato de matrícula inválido Ej: 1234-BCD");
                    hayError = true;

                } else if (!DataManager.comprobarMatricula(matricula)) {

                    mostrarError(campoMatricula, errMatricula, "Esa matrícula ya está registrada en la base de datos");
                    hayError = true;
                }

            } catch (SQLException ex) {

                mostrarErrorBD(ex);
                return;

            }

            if (marca.equals("-- Selecciona una marca --")) {

                mostrarError(campoMarca, errMarca, "Selecciona una marca");
                hayError = true;

            }

            if (!Vehiculo.validarModelo(modelo)) {

                mostrarError(campoModelo, errModelo, "Mínimo 3 y máximo 30 letras.");
                hayError = true;

            }

            if (combustible.equals("-- Selecciona un combustible --")) {

                mostrarError(campoTipoCombust, errTipoCombust, "Selecciona un combustible");
                hayError = true;

            }

            double precioDouble = 0.0;
            try {

                precioDouble = Double.parseDouble(precio);

                if (precioDouble < 0) {

                    mostrarError(campoPrecio, errPrecio, "El precio debe de ser un número positivo");
                    hayError = true;

                } else if (!DataManager.validarPrecio(precioDouble)) {

                    mostrarError(campoPrecio, errPrecio, "Mínimo 1, máximo 10 dígitos y máximo 2 decimales");
                    hayError = true;

                }

            } catch (NumberFormatException ex) {

                mostrarError(campoPrecio, errPrecio, "Introduce un número decimal");
                hayError = true;

            }

            try {

                if (!Cliente.validarDni(dniCliente)) {

                    mostrarError(campoDniCliente, errDniCliente, "Formato de DNI incorrecto. Ej: 12345678A");
                    hayError = true;

                } else if (DataManager.comprobarDni(dniCliente)) {

                    mostrarError(campoDniCliente, errDniCliente, "Ese DNI NO está registrado");
                    hayError = true;

                }

            } catch (SQLException ex) {

                mostrarErrorBD(ex);
                return;

            }

            Integer numEmpInt = 0;
            try {

                numEmpInt = Integer.parseInt(numEmp);

                try {

                    if (!DataManager.comprobarNumEmpleado(numEmpInt)) {

                        mostrarError(campoNumEmp, errNumEmp, "No existe ningún empleado con ese número");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);
                    return;
                }

            } catch (NumberFormatException ex) {

                mostrarError(campoNumEmp, errNumEmp, "Introduce un número");
                hayError = true;

            }

            if (hayError) return; // si hay algún error no continuamos, el return sale el action listener

            try {

                boolean insertado =  VehiculoController.insertarVehiculo(new Vehiculo(matricula,marca,modelo,combustible,precioDouble,dniCliente,numEmpInt)); // Intento insertar el Empleado con los datos proporcionados

                if (insertado) {

                    // En caso de que se inserte muestro un dialog y cuando le de a OK salgo del dialog principal,
                    JOptionPane.showMessageDialog(dialog, "Vehículo insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                    // Actualizo la tabla con los nuevos registros una vez insertado el vehículo
                    mostrarTabla(obtenerModeloVehiculos());

                } else {

                    // En caso de que no se haya podido insertar el vehículo muestro un error en un dialog
                    JOptionPane.showMessageDialog(dialog, "No se pudo insertar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } catch (SQLException ex) {

                // En caso de que haya habido algún error SQL o con la conexión a la base de datos lo muestro en un dialog
                mostrarErrorBD(ex);

            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogoModificarCliente(){

        // Compruebo que hay una tabla/entidad seleccionada
        // En caso de que no la haya muestro una ventana de aviso
        if (tablaActual == null || entidadActual == null) {

            JOptionPane.showMessageDialog(this, "Selecciona una entidad primero.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;

        }

        // Si la tupla seleccionada es -1 significa que no hay ninguna seleccionada por lo que muestro un aviso
        int filaSeleccionada = tablaActual.getSelectedRow();
        if (filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;

        }

        // Cojo la clave primaria que está en la primera columna de cada entidad
        Object clavePrimaria = tablaActual.getValueAt(filaSeleccionada, 0);

        Cliente clienteBuscar = new Cliente();
        boolean encontrado = false;

        try {

            for (Cliente e : ClienteController.verClientes()) {

                if (e.getDni().equals((String) clavePrimaria)) {

                    encontrado = true;
                    break;

                }

            }

            if (!encontrado) {

                dialogError("¡ NO se ha encontrado el cliente !");
                return;

            }

        } catch (SQLException e) {

            mostrarErrorBD(e);
            return;

        } catch (NullPointerException e) {

            dialogError("¡ No hay clientes en la base de datos !");
            return;

        }

        final Cliente cliente = clienteBuscar;

        // Me creo el dialog principal con sus respectivas características para la insercción del ciente
        JDialog dialog = new JDialog(this, "Insertar Cliente", true);
        dialog.setSize(420, 380);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setLayout(new BorderLayout());

        // Me creo el panel donde va a ir el formulario con los campos a insertar
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20)); // Padding para el formulario

        GridBagConstraints gbc = new GridBagConstraints(); // Me creo el objeto GridBagConstraints para poder posicionar cada elemento en el panel del formulario
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 0, 5);

        JTextField campoDni = new JTextField();
        JTextField campoNombre = new JTextField();
        JTextField campoApellidos = new JTextField();
        JTextField campoTelefono = new JTextField();

        campoDni.setText(cliente.getDni());
        campoNombre.setText(cliente.getNombre());
        campoApellidos.setText(cliente.getApellidos());
        campoTelefono.setText(cliente.getTelefono());

        // Labels de error para cada campo
        JLabel errDni = crearLabelError();
        JLabel errNombre = crearLabelError();
        JLabel errApellidos = crearLabelError();
        JLabel errTelefono = crearLabelError();

        // ---- DNI ----
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(new JLabel("DNI:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoDni, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(errDni, gbc);

        // ---- Nombre ----
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panelForm.add(errNombre, gbc);

        // ---- Apellidos ----
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoApellidos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panelForm.add(errApellidos, gbc);

        // ---- Teléfono ----
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        panelForm.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panelForm.add(campoTelefono, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        panelForm.add(errTelefono, gbc);

        // ---- Botones ----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAceptar);

        dialog.getRootPane().setDefaultButton(btnAceptar);

        dialog.add(panelForm, BorderLayout.CENTER);
        dialog.add(panelBotones, BorderLayout.SOUTH);

        btnCancelar.addActionListener(e -> dialog.dispose()); // En caso de que cancele cierro el dialog

        btnAceptar.addActionListener(e -> {

            // Recogo los campos introducidos por el usuario
            String dni = campoDni.getText().trim();
            String nombre = campoNombre.getText().trim();
            String apellidos = campoApellidos.getText().trim();
            String telefono = campoTelefono.getText().trim();

            // Antes de volver a validar reseto cualquier error anterior que pudiera haber
            limpiarError(campoDni, errDni);
            limpiarError(campoNombre, errNombre);
            limpiarError(campoApellidos, errApellidos);
            limpiarError(campoTelefono, errTelefono);

            boolean hayError = false;
            boolean modificado = false;

            if (!Cliente.validarDni(dni)) {

                mostrarError(campoDni, errDni, "Formato inválido. Ej: 12345678A");
                hayError = true;

            } else {

                try {

                    if (!DataManager.comprobarDni(dni)) {

                        mostrarError(campoDni, errDni, "Ya existe un cliente con ese DNI.");
                        hayError = true;

                    }

                } catch (SQLException ex) {

                    mostrarErrorBD(ex);
                    return;

                }
            }

            if (!DataManager.validarNombre(nombre, 3, 20)) {

                mostrarError(campoNombre, errNombre, "Mínimo 3 y máximo 20 letras.");
                hayError = true;

            }

            if (!DataManager.validarApellidos(apellidos)) {

                mostrarError(campoApellidos, errApellidos, "Mínimo 3 y máximo 50 letras.");
                hayError = true;

            }

            if (!DataManager.validartelefono(telefono)) {

                mostrarError(campoTelefono, errTelefono, "Formato inválido. Tiene que ser 9 números");
                hayError = true;

            }

            if (hayError) return; // si hay algún error no continuamos, el return sale el action listener

            if (!nombre.equals(cliente.getNombre())) {

                cliente.setNombre(nombre);

            }

            if (!apellidos.equals(cliente.getApellidos())) {

                cliente.setApellidos(apellidos);

            }

            if (!telefono.isEmpty()) {

                cliente.setTelefono(telefono);

            }

            try {

                if (!dni.isEmpty()) {

                    modificado = ClienteController.modificarCliente(cliente, cliente.getDni());
                    cliente.setDni(dni);

                } else {

                    modificado = ClienteController.modificarCliente(cliente, cliente.getDni());

                }

            } catch (SQLException ex) {

                mostrarErrorBD(ex);
                return;

            }


            // En caso de que se modifique correcatmente muestro una ventana indicandolo y vuelvo a construir la tabla con los nuevos registros
            if (modificado) {

                JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Actualización de la tabla:
                mostrarTabla(obtenerModeloClientes());

            } else {

                // En caso de que por algún motivo no se haya podido borrar la entidad muestro un panel indicándolo
                JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        });

        dialog.setVisible(true);

    }

    // Crea un JLabel de error vacío con estilo rojo y cursiva
    private JLabel crearLabelError() {

        // Label vacío para poder mostrar el error luego
        JLabel label = new JLabel(" ");

        // El error lo muestro de color rojo y en cursiva
        label.setForeground(Color.RED);
        label.setFont(label.getFont().deriveFont(Font.ITALIC, 11f));
        return label;

    }

    // Muestra el error en el label y marca el campo en rojo
    private void mostrarError(JTextField campo, JLabel labelError, String mensaje) {

        labelError.setText(mensaje); // Establezco el mensaje del error al label correspondiente
        campo.setBorder(BorderFactory.createLineBorder(Color.RED)); // Le cambio el color del borde al input

    }

    // Función para restablecer el label y el input a su color y forma normal
    private void limpiarError(JTextField campo, JLabel labelError) {

        labelError.setText(" ");
        campo.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));

    }

    private void limpiarError(JLabel labelError) {

        labelError.setText(" ");

    }

    // Gestión del error pero para el combobox en vez de para un JTextlabel
    private void mostrarError(JComboBox<?> campo, JLabel labelError, String mensaje) {

        labelError.setText(mensaje);
        campo.setBorder(BorderFactory.createLineBorder(Color.RED));

    }

    private void mostrarError(JLabel labelError, String mensaje) {

        labelError.setText(mensaje);

    }

    private void limpiarError(JComboBox<?> campo, JLabel labelError) {

        labelError.setText(" ");
        campo.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("ComboBox.border"));

    }

    private void resaltarBoton(JButton botonActivo) {

        // Quitar el color de resaltado a todos
        for (JButton btn : new JButton[]{btnEmpleados, btnDepartamentos, btnVehiculos, btnClientes, btnUsuarios}) {

            btn.setBackground(null);    // color por defecto
            btn.setForeground(null);    // texto por defecto

        }
        // Resaltar botón activo
        botonActivo.setBackground(new Color(70, 130, 180)); // Color azul
        botonActivo.setForeground(Color.WHITE);

    }

}