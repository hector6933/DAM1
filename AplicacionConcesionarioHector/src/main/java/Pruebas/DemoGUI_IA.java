package Pruebas;

import Controlador.*;
import Modelo.*;
import Config.Conexion;
import Vista.DataManager;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * DemoGUI – Interfaz gráfica Swing para el Concesionario.
 * Sustituye a DemoConsola manteniendo exactamente la misma lógica de backend.
 *
 * NOTA: Si algún getter de los Modelos difiere de la convención usada aquí
 * (ej. getNumEmpleado() vs getNum()) ajústalo en la región del panel correspondiente.
 * Los nombres de columna SQL (CAMPO_MOD, etc.) deben coincidir con los que
 * usa DataManager.pedirColumnaXxx() – revísalos en la región COLUMNAS.
 */
public class DemoGUI_IA {

    // =========================================================
    //  TEMA VISUAL
    // =========================================================
    static final Color C_BG      = new Color(22, 27, 36);
    static final Color C_SURFACE = new Color(30, 38, 52);
    static final Color C_SIDEBAR = new Color(15, 20, 28);
    static final Color C_ACCENT  = new Color(79, 172, 254);
    static final Color C_SUCCESS = new Color(56, 193, 114);
    static final Color C_DANGER  = new Color(239, 98, 98);
    static final Color C_WARN    = new Color(247, 183, 51);
    static final Color C_TEXT    = new Color(230, 237, 247);
    static final Color C_MUTED   = new Color(140, 158, 180);
    static final Color C_BORDER  = new Color(45, 58, 78);
    static final Color C_ROW     = new Color(30, 38, 52);
    static final Color C_ROW_ALT = new Color(25, 32, 44);
    static final Color C_HDR     = new Color(20, 26, 38);

    static final Font F_TITLE  = new Font("Segoe UI", Font.BOLD, 20);
    static final Font F_LABEL  = new Font("Segoe UI", Font.BOLD, 13);
    static final Font F_BODY   = new Font("Segoe UI", Font.PLAIN, 13);
    static final Font F_SMALL  = new Font("Segoe UI", Font.PLAIN, 11);
    static final Font F_NAV    = new Font("Segoe UI", Font.PLAIN, 14);
    static final Font F_BTN    = new Font("Segoe UI", Font.BOLD, 13);

    // =========================================================
    //  NOMBRES DE COLUMNAS SQL
    //  ¡ Ajusta estos valores para que coincidan con tu DataManager !
    // =========================================================
    static final String[] COLS_CLIENTE     = {"DNI", "NOMBRE", "APELLIDOS", "TELEFONO"};
    static final String[] COLS_VEHICULO    = {"MATRICULA", "MARCA", "MODELO", "TIPO_COMBUSTIBLE", "PRECIO", "DNI_CLIENTE", "NUM_EMPLEADO"};
    static final String[] COLS_EMPLEADO    = {"NOMBRE", "APELLIDOS", "TELEFONO", "FECHA_NACIMIENTO", "NUM_GERENTE", "NUM_DEP", "ID_USUARIO"};
    static final String[] COLS_DEPARTAMENTO= {"NUM_DEP", "NOMBRE"};
    static final String[] COLS_USUARIO     = {"NOMBRE", "PASSWD", "ROL"};

    // =========================================================
    //  ESTADO GLOBAL
    // =========================================================
    static Integer idUsuarioActual;
    static String  rolActual;
    static JFrame  ventanaPrincipal;

    // =========================================================
    //  MAIN
    // =========================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
            catch (Exception ignored) {}
            mostrarLogin();
        });
    }

    // =========================================================
    //  LOGIN
    // =========================================================
    static void mostrarLogin() {
        JFrame f = new JFrame("Concesionario · Inicio de sesión");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(430, 560);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(C_BG);

        // --- Cabecera ---
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(C_SIDEBAR);
        header.setBorder(new EmptyBorder(40, 0, 38, 0));

        JLabel icoLbl = new JLabel("🚗");
        icoLbl.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 52));
        icoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titulo = new JLabel("Concesionario");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setForeground(C_TEXT);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel sub = new JLabel("Sistema de Gestión");
        sub.setFont(F_SMALL);
        sub.setForeground(C_MUTED);
        sub.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(icoLbl);
        header.add(Box.createVerticalStrut(10));
        header.add(titulo);
        header.add(Box.createVerticalStrut(5));
        header.add(sub);

        // --- Formulario ---
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(C_BG);
        form.setBorder(new EmptyBorder(38, 55, 38, 55));

        JTextField  txtUser = styledField();
        JPasswordField txtPass = new JPasswordField();
        applyFieldStyle(txtPass);

        JButton btnLogin = accentBtn("  Iniciar sesión  ");
        btnLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        JLabel errLbl = new JLabel(" ");
        errLbl.setFont(F_SMALL);
        errLbl.setForeground(C_DANGER);
        errLbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        form.add(sectionLabel("Usuario"));    form.add(Box.createVerticalStrut(6));
        form.add(txtUser);                    form.add(Box.createVerticalStrut(18));
        form.add(sectionLabel("Contraseña")); form.add(Box.createVerticalStrut(6));
        form.add(txtPass);                    form.add(Box.createVerticalStrut(28));
        form.add(btnLogin);                   form.add(Box.createVerticalStrut(12));
        form.add(errLbl);

        ActionListener doLogin = e -> {
            String user   = txtUser.getText().trim();
            String passwd = new String(txtPass.getPassword());
            if (user.isEmpty() || passwd.isEmpty()) { errLbl.setText("Rellena usuario y contraseña."); return; }
            if (!DataManager.comprobarCredencialesUsuario(user, passwd)) {
                errLbl.setText("Credenciales incorrectas."); txtPass.setText(""); return;
            }
            try {
                idUsuarioActual = UsuarioController.getIdUsuario(user);
                if (idUsuarioActual == null) throw new SQLException("ID nulo");
                rolActual = DataManager.devolverRolUsuario(idUsuarioActual);
                if (rolActual == null) throw new SQLException("Rol nulo");
                f.dispose();
                mostrarVentanaPrincipal();
            } catch (SQLException ex) { errLbl.setText("Error al obtener datos del usuario."); }
        };
        btnLogin.addActionListener(doLogin);
        txtPass.addActionListener(doLogin);

        root.add(header, BorderLayout.NORTH);
        root.add(form,   BorderLayout.CENTER);
        f.setContentPane(root);
        f.setVisible(true);
    }

    // =========================================================
    //  VENTANA PRINCIPAL
    // =========================================================
    static void mostrarVentanaPrincipal() {
        String rolCap = capFirst(rolActual);
        ventanaPrincipal = new JFrame("Concesionario · " + rolCap);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(1150, 720);
        ventanaPrincipal.setMinimumSize(new Dimension(900, 580));
        ventanaPrincipal.setLocationRelativeTo(null);

        // Comprobar conexión al arrancar
        try (Connection c = Conexion.conexion()) {
            // OK
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "⚠️ Error al conectar con la base de datos.",
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(C_BG);

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(C_BG);
        content.add(panelBienvenida(), BorderLayout.CENTER);

        JPanel sidebar = buildSidebar(content);
        root.add(sidebar, BorderLayout.WEST);
        root.add(content, BorderLayout.CENTER);

        ventanaPrincipal.setContentPane(root);
        ventanaPrincipal.setVisible(true);
    }

    static JPanel buildSidebar(JPanel content) {
        JPanel sb = new JPanel();
        sb.setLayout(new BoxLayout(sb, BoxLayout.Y_AXIS));
        sb.setBackground(C_SIDEBAR);
        sb.setPreferredSize(new Dimension(210, 0));

        // Marca
        JPanel brand = new JPanel(new GridLayout(2, 1, 0, 4));
        brand.setOpaque(false);
        brand.setBorder(new EmptyBorder(22, 18, 22, 18));
        JLabel bName = new JLabel("🚗  Concesionario");
        bName.setFont(new Font("Segoe UI", Font.BOLD, 15));
        bName.setForeground(C_TEXT);
        JLabel bRole = new JLabel("   " + rolActual.toUpperCase());
        bRole.setFont(F_SMALL);
        bRole.setForeground(C_ACCENT);
        brand.add(bName); brand.add(bRole);
        sb.add(brand);
        sb.add(hSep());
        sb.add(Box.createVerticalStrut(8));

        // Secciones comunes
        addNavBtn(sb, "👥  Clientes",      content, () -> panelClientes());
        addNavBtn(sb, "🚙  Vehículos",     content, () -> panelVehiculos());
        addNavBtn(sb, "👷  Empleados",     content, () -> panelEmpleados());
        addNavBtn(sb, "🏢  Departamentos", content, () -> panelDepartamentos());

        // Usuarios → solo admin
        if (rolActual.equalsIgnoreCase("admin")) {
            addNavBtn(sb, "🔑  Usuarios", content, () -> panelUsuarios());
        }

        sb.add(Box.createVerticalGlue());
        sb.add(hSep());

        JButton btnSalir = navBtn("🚪  Cerrar sesión");
        btnSalir.setForeground(C_DANGER);
        btnSalir.addActionListener(e -> {
            idUsuarioActual = null; rolActual = null;
            ventanaPrincipal.dispose();
            mostrarLogin();
        });
        sb.add(btnSalir);
        sb.add(Box.createVerticalStrut(14));
        return sb;
    }

    static void addNavBtn(JPanel sb, String label, JPanel content, Supplier<JPanel> panelFn) {
        JButton btn = navBtn(label);
        btn.addActionListener(e -> swapCenter(content, panelFn.get()));
        sb.add(btn);
        sb.add(Box.createVerticalStrut(2));
    }

    static void swapCenter(JPanel container, JPanel next) {
        BorderLayout bl = (BorderLayout) container.getLayout();
        Component old = bl.getLayoutComponent(BorderLayout.CENTER);
        if (old != null) container.remove(old);
        container.add(next, BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
    }

    // =========================================================
    //  PANEL BIENVENIDA
    // =========================================================
    static JPanel panelBienvenida() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(C_BG);
        JLabel lbl = new JLabel("👈  Selecciona una sección del menú lateral");
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lbl.setForeground(C_MUTED);
        p.add(lbl);
        return p;
    }

    // =========================================================
    //  PANEL CLIENTES  (todos los roles: CRUD completo)
    // =========================================================
    static JPanel panelClientes() {
        String[] headers = {"DNI", "Nombre", "Apellidos", "Teléfono"};

        Supplier<Object[][]> loader = () -> {
            try {
                ArrayList<Cliente> list = ClienteController.verClientes();
                if (list == null) return new Object[0][];
                Object[][] d = new Object[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    Cliente c = list.get(i);
                    d[i] = new Object[]{c.getDni(), c.getNombre(), c.getApellidos(), c.getTelefono()};
                }
                return d;
            } catch (SQLException e) { return new Object[0][]; }
        };

        return buildEntityPanel("Clientes", headers, loader,
                t -> dialogInsertarCliente(t),
                t -> dialogModificarGenerico(t, "Cliente", headers, COLS_CLIENTE, 0, (campo, val, condCol, condVal) -> {
                    try { ClienteController.modificarCliente(campo, val, condCol, condVal); }
                    catch (SQLException ex) { throw new RuntimeException(ex); }
                }),
                t -> {
                    int row = t.getSelectedRow();
                    if (row < 0) { showError("Selecciona un cliente de la tabla."); return; }
                    String dni = t.getValueAt(row, 0).toString();
                    if (!confirm("¿Eliminar cliente con DNI " + dni + "?")) return;
                    try {
                        if (ClienteController.borrarCliente(dni)) showSuccess("Cliente borrado correctamente.");
                        else showError("No se pudo borrar el cliente.");
                    } catch (SQLException e) { showError("Error de base de datos: " + e.getMessage()); }
                    refreshTable(t, loader);
                }
        );
    }

    static void dialogInsertarCliente(JTable table) {
        JDialog d = createDialog("Insertar Cliente", 420, 380);
        JTextField tDni = styledField(), tNom = styledField(),
                tApe = styledField(), tTel = styledField();
        d.add(buildForm(
                new String[]{"DNI", "Nombre", "Apellidos", "Teléfono"},
                new JComponent[]{tDni, tNom, tApe, tTel}
        ), BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            String dni = tDni.getText().trim();
            if (dni.isEmpty()) { showError(d, "El DNI no puede estar vacío."); return; }
            try {
                if (!DataManager.comprobarDni(dni)) { showError(d, "Ya existe un cliente con ese DNI."); return; }
                ArrayList<Cliente> lista = new ArrayList<>();
                lista.add(new Cliente(dni, tNom.getText().trim(), tApe.getText().trim(), tTel.getText().trim()));
                int rows = ClienteController.insertarClientes(lista);
                showSuccess(d, rows + " cliente(s) insertado(s).");
            } catch (SQLException ex) { showError(d, "Error de base de datos: " + ex.getMessage()); return; }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  PANEL VEHÍCULOS  (todos los roles: CRUD completo)
    // =========================================================
    static JPanel panelVehiculos() {
        String[] headers = {"Matrícula", "Marca", "Modelo", "Combustible", "Precio", "DNI Cliente", "Nº Empleado"};

        Supplier<Object[][]> loader = () -> {
            try {
                ArrayList<Vehiculo> list = VehiculoController.verVehiculos();
                if (list == null) return new Object[0][];
                Object[][] d = new Object[list.size()][7];
                for (int i = 0; i < list.size(); i++) {
                    Vehiculo v = list.get(i);
                    d[i] = new Object[]{v.getMatricula(), v.getMarca(), v.getModelo(),
                            v.getTipoCombustible(), v.getPrecio(), v.getDniCliente(), v.getNumEmpleado()};
                }
                return d;
            } catch (SQLException e) { return new Object[0][]; }
        };

        return buildEntityPanel("Vehículos", headers, loader,
                t -> dialogInsertarVehiculo(t),
                t -> dialogModificarGenerico(t, "Vehículo", headers, COLS_VEHICULO, 0, (campo, val, condCol, condVal) -> {
                    try { VehiculoController.modificarVehiculos(campo, val, condCol, condVal); }
                    catch (SQLException ex) { throw new RuntimeException(ex); }
                }),
                t -> {
                    int row = t.getSelectedRow();
                    if (row < 0) { showError("Selecciona un vehículo de la tabla."); return; }
                    String mat = t.getValueAt(row, 0).toString();
                    if (!confirm("¿Eliminar vehículo con matrícula " + mat + "?")) return;
                    try {
                        if (VehiculoController.borrarVehiculo(mat)) showSuccess("Vehículo borrado correctamente.");
                        else showError("No se pudo borrar el vehículo.");
                    } catch (SQLException e) { showError("Error de base de datos: " + e.getMessage()); }
                    refreshTable(t, loader);
                }
        );
    }

    static void dialogInsertarVehiculo(JTable table) {
        JDialog d = createDialog("Insertar Vehículo", 440, 500);
        JTextField tMat = styledField(), tMarca = styledField(), tModelo = styledField(),
                tComb = styledField(), tPrecio = styledField(),
                tDniC = styledField(), tNumEmp = styledField();
        d.add(buildForm(
                new String[]{"Matrícula", "Marca", "Modelo", "Tipo combustible",
                        "Precio", "DNI del cliente", "Nº de empleado"},
                new JComponent[]{tMat, tMarca, tModelo, tComb, tPrecio, tDniC, tNumEmp}
        ), BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            String mat = tMat.getText().trim();
            if (mat.isEmpty()) { showError(d, "La matrícula no puede estar vacía."); return; }
            try {
                if (!DataManager.comprobarMatricula(mat)) { showError(d, "Esa matrícula ya está registrada."); return; }
                String dniC = tDniC.getText().trim();
                if (DataManager.comprobarDni(dniC)) { showError(d, "No existe ningún cliente con ese DNI."); return; }
                Integer numEmp = Integer.parseInt(tNumEmp.getText().trim());
                if (!DataManager.comprobarNumEmpleado(numEmp)) { showError(d, "No existe ningún empleado con ese número."); return; }
                Double precio  = Double.parseDouble(tPrecio.getText().trim());
                ArrayList<Vehiculo> lista = new ArrayList<>();
                lista.add(new Vehiculo(mat, tMarca.getText().trim(), tModelo.getText().trim(),
                        tComb.getText().trim(), precio, dniC, numEmp));
                int rows = VehiculoController.insertarVehiculos(lista);
                showSuccess(d, rows + " vehículo(s) insertado(s).");
            } catch (NumberFormatException ex) { showError(d, "Precio y nº de empleado deben ser numéricos."); return; }
            catch (SQLException ex) { showError(d, "Error de base de datos: " + ex.getMessage()); return; }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  PANEL EMPLEADOS
    //    empleado → solo ver | gerente+admin → CRUD
    // =========================================================
    static JPanel panelEmpleados() {
        String[] headers = {"Nº Emp.", "Nombre", "Apellidos", "Teléfono", "Fecha Nac.", "Nº Gerente", "Nº Dep.", "ID Usuario"};

        Supplier<Object[][]> loader = () -> {
            try {
                ArrayList<Empleado> list = EmpleadoController.verEmpleados();
                if (list == null) return new Object[0][];
                Object[][] d = new Object[list.size()][8];
                for (int i = 0; i < list.size(); i++) {
                    Empleado e = list.get(i);
                    // NOTA: ajusta los getters si difieren en tu modelo
                    d[i] = new Object[]{e.getNumEmpleado(), e.getNombre(), e.getApellidos(),
                            e.getTelefono(), e.getFechaNacimiento(), e.getNumGerente(), e.getNumDep(), e.getId_usuario()};
                }
                return d;
            } catch (SQLException e) { return new Object[0][]; }
        };

        boolean puedeCrud = rolActual.equalsIgnoreCase("gerente") || rolActual.equalsIgnoreCase("admin");

        return buildEntityPanel("Empleados", headers, loader,
                puedeCrud ? t -> dialogInsertarEmpleado(t) : null,
                puedeCrud ? t -> dialogModificarGenerico(t, "Empleado", headers, COLS_EMPLEADO, 0, (campo, val, condCol, condVal) -> {
                    try { EmpleadoController.modificarEmpleados(campo, val, condCol, condVal); }
                    catch (SQLException ex) { throw new RuntimeException(ex); }
                }) : null,
                puedeCrud ? t -> {
                    int row = t.getSelectedRow();
                    if (row < 0) { showError("Selecciona un empleado de la tabla."); return; }
                    Object numObj = t.getValueAt(row, 0);
                    if (numObj == null) return;
                    Integer num = Integer.parseInt(numObj.toString());
                    if (!confirm("¿Eliminar empleado nº " + num + "?")) return;
                    try {
                        if (EmpleadoController.borrarEmpleado(num)) showSuccess("Empleado borrado correctamente.");
                        else showError("No se pudo borrar el empleado.");
                    } catch (SQLException e) { showError("Error de base de datos: " + e.getMessage()); }
                    refreshTable(t, loader);
                } : null
        );
    }

    static void dialogInsertarEmpleado(JTable table) {
        JDialog d = createDialog("Insertar Empleado", 440, 540);
        JTextField tNom = styledField(), tApe = styledField(), tTel = styledField(),
                tFec = styledField(), tGer = styledField(), tDep = styledField();
        tFec.setToolTipText("Formato: YYYY-MM-DD");

        JPanel camposPanel = buildForm(
                new String[]{"Nombre", "Apellidos", "Teléfono",
                        "Fecha nacimiento (YYYY-MM-DD)", "Nº Gerente", "Nº Departamento"},
                new JComponent[]{tNom, tApe, tTel, tFec, tGer, tDep}
        );

        // Sección usuario (solo admin puede crear usuario nuevo)
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setLayout(new BoxLayout(usuarioPanel, BoxLayout.Y_AXIS));
        usuarioPanel.setBackground(C_SURFACE);
        usuarioPanel.setBorder(new EmptyBorder(10, 16, 16, 16));

        JLabel usuLbl = sectionLabel("ID de Usuario existente");
        JTextField tIdUsu = styledField();
        usuarioPanel.add(usuLbl); usuarioPanel.add(Box.createVerticalStrut(6)); usuarioPanel.add(tIdUsu);

        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(C_BG);
        centro.add(camposPanel, BorderLayout.CENTER);
        centro.add(usuarioPanel, BorderLayout.SOUTH);

        d.add(centro, BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            try {
                Integer numGer = Integer.parseInt(tGer.getText().trim());
                Integer numDep = Integer.parseInt(tDep.getText().trim());
                Integer idUsu  = Integer.parseInt(tIdUsu.getText().trim());
                if (!DataManager.comprobarNumEmpleado(numGer)) { showError(d, "No existe ningún empleado con ese número de gerente."); return; }
                if (!DataManager.comprobarNumDep(numDep)) { showError(d, "No existe ese número de departamento."); return; }
                if (!DataManager.comprobarIdUsuario(idUsu)) { showError(d, "El ID de usuario no existe."); return; }
                if (DataManager.comprobarIdUsuarioEmpleado(idUsu)) { showError(d, "Ese usuario ya tiene un empleado asignado."); return; }
                java.sql.Date fecha = java.sql.Date.valueOf(tFec.getText().trim());
                ArrayList<Empleado> lista = new ArrayList<>();
                lista.add(new Empleado(tNom.getText().trim(), tApe.getText().trim(),
                        tTel.getText().trim(), fecha, numGer, numDep, idUsu));
                int rows = EmpleadoController.insertarEmpleados(lista);
                showSuccess(d, rows + " empleado(s) insertado(s).");
            } catch (NumberFormatException ex) { showError(d, "Nº Gerente, Nº Dpto. e ID Usuario deben ser numéricos."); return; }
            catch (IllegalArgumentException ex) { showError(d, "Fecha inválida. Usa el formato YYYY-MM-DD."); return; }
            catch (SQLException ex) { showError(d, "Error de base de datos: " + ex.getMessage()); return; }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  PANEL DEPARTAMENTOS
    //    empleado/gerente → solo ver | admin → CRUD
    // =========================================================
    static JPanel panelDepartamentos() {
        // NOTA: ajusta los headers/getters según tu modelo Departamento
        String[] headers = {"Nº Dpto.", "Nombre"};

        Supplier<Object[][]> loader = () -> {
            try {
                ArrayList<Departamento> list = DepartamentoController.verDepartamentos();
                if (list == null) return new Object[0][];
                Object[][] d = new Object[list.size()][2];
                for (int i = 0; i < list.size(); i++) {
                    Departamento dep = list.get(i);
                    d[i] = new Object[]{dep.getNumDep(), dep.getNombre()};
                }
                return d;
            } catch (SQLException e) { return new Object[0][]; }
        };

        boolean puedeCrud = rolActual.equalsIgnoreCase("admin");

        return buildEntityPanel("Departamentos", headers, loader,
                puedeCrud ? t -> dialogInsertarDepartamento(t) : null,
                puedeCrud ? t -> dialogModificarGenerico(t, "Departamento", headers, COLS_DEPARTAMENTO, 0, (campo, val, condCol, condVal) -> {
                    try { DepartamentoController.modificarDepartamento(campo, val, condCol, condVal); }
                    catch (SQLException ex) { throw new RuntimeException(ex); }
                }) : null,
                puedeCrud ? t -> {
                    int row = t.getSelectedRow();
                    if (row < 0) { showError("Selecciona un departamento de la tabla."); return; }
                    Object numObj = t.getValueAt(row, 0);
                    Integer numDep = Integer.parseInt(numObj.toString());
                    if (!confirm("¿Eliminar departamento nº " + numDep + "?")) return;
                    try {
                        if (DepartamentoController.borrarDepartamento(numDep)) showSuccess("Departamento borrado correctamente.");
                        else showError("No se pudo borrar el departamento.");
                    } catch (SQLException e) { showError("Error de base de datos: " + e.getMessage()); }
                    refreshTable(t, loader);
                } : null
        );
    }

    static void dialogInsertarDepartamento(JTable table) {
        JDialog d = createDialog("Insertar Departamento", 380, 240);
        JTextField tNom = styledField();
        d.add(buildForm(new String[]{"Nombre del departamento"}, new JComponent[]{tNom}), BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            String nom = tNom.getText().trim();
            if (nom.isEmpty()) { showError(d, "El nombre no puede estar vacío."); return; }
            try {
                ArrayList<Departamento> lista = new ArrayList<>();
                lista.add(new Departamento(nom));
                int rows = DepartamentoController.insertarDepartamentos(lista);
                showSuccess(d, rows + " departamento(s) insertado(s).");
            } catch (SQLException ex) { showError(d, "Error de base de datos: " + ex.getMessage()); return; }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  PANEL USUARIOS  (solo admin)
    // =========================================================
    static JPanel panelUsuarios() {
        String[] headers = {"ID", "Nombre de usuario", "Rol"};

        Supplier<Object[][]> loader = () -> {
            try {
                ArrayList<Usuario> list = UsuarioController.verUsuarios();
                if (list == null) return new Object[0][];
                Object[][] d = new Object[list.size()][3];
                for (int i = 0; i < list.size(); i++) {
                    Usuario u = list.get(i);
                    // NOTA: ajusta el getter del ID según tu modelo Usuario
                    // Prueba: u.getId()  /  u.getIdUsuario()  /  u.getIdUsu()
                    d[i] = new Object[]{u.getId(), u.getNombre(), u.getRol()};
                }
                return d;
            } catch (SQLException e) { return new Object[0][]; }
        };

        return buildEntityPanel("Usuarios", headers, loader,
                t -> dialogInsertarUsuario(t),
                t -> dialogModificarGenerico(t, "Usuario", headers, COLS_USUARIO, 0, (campo, val, condCol, condVal) -> {
                    try { UsuarioController.modificarUsuario(campo, val, condCol, condVal); }
                    catch (SQLException ex) { throw new RuntimeException(ex); }
                }),
                t -> {
                    int row = t.getSelectedRow();
                    if (row < 0) { showError("Selecciona un usuario de la tabla."); return; }
                    Object idObj = t.getValueAt(row, 0);
                    Integer id = Integer.parseInt(idObj.toString());
                    if (!confirm("¿Eliminar usuario con ID " + id + "?")) return;
                    try {
                        if (UsuarioController.borrarUsuario(id)) showSuccess("Usuario borrado correctamente.");
                        else showError("No se pudo borrar el usuario.");
                    } catch (SQLException e) { showError("Error de base de datos: " + e.getMessage()); }
                    refreshTable(t, loader);
                }
        );
    }

    static void dialogInsertarUsuario(JTable table) {
        JDialog d = createDialog("Insertar Usuario", 400, 360);
        JTextField    tNom = styledField();
        JPasswordField tPas = new JPasswordField(); applyFieldStyle(tPas);
        String[] roles = {"admin", "gerente", "empleado"};
        JComboBox<String> cbRol = styledCombo(roles);

        JPanel form = buildForm(
                new String[]{"Nombre de usuario", "Contraseña", "Rol"},
                new JComponent[]{tNom, tPas, cbRol}
        );
        d.add(form, BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            String nom    = tNom.getText().trim();
            String passwd = new String(tPas.getPassword());
            String rol    = (String) cbRol.getSelectedItem();
            if (nom.isEmpty() || passwd.isEmpty()) { showError(d, "Rellena todos los campos."); return; }
            try {
                if (DataManager.comprobarUsername(nom)) { showError(d, "Ese nombre de usuario ya existe."); return; }
                ArrayList<Usuario> lista = new ArrayList<>();
                lista.add(new Usuario(nom, passwd, rol));
                int rows = UsuarioController.insertarUsuarios(lista);
                showSuccess(d, rows + " usuario(s) insertado(s).");
            } catch (SQLException ex) { showError(d, "Error de base de datos: " + ex.getMessage()); return; }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  DIÁLOGO MODIFICAR GENÉRICO
    //  Replica la lógica consola: campo → nuevo valor → condición
    // =========================================================
    @FunctionalInterface
    interface ModifyAction {
        void execute(String campo, String val, String condCol, String condVal);
    }

    static void dialogModificarGenerico(JTable table, String entityName,
                                        String[] displayHeaders, String[] sqlCols, int pkColIndex,
                                        ModifyAction action) {

        JDialog d = createDialog("Modificar " + entityName, 440, 370);

        JComboBox<String> cbCampo   = styledCombo(displayHeaders);
        JTextField        tValor    = styledField();
        JComboBox<String> cbCondCol = styledCombo(displayHeaders);
        JTextField        tCondVal  = styledField();

        // Pre-seleccionar fila si hay una seleccionada
        int selRow = table.getSelectedRow();
        if (selRow >= 0) {
            tCondVal.setText(table.getValueAt(selRow, pkColIndex) != null
                    ? table.getValueAt(selRow, pkColIndex).toString() : "");
        }

        JPanel form = buildForm(
                new String[]{
                        "Campo a modificar",
                        "Nuevo valor",
                        "Columna de condición (WHERE)",
                        "Valor de la condición"
                },
                new JComponent[]{cbCampo, tValor, cbCondCol, tCondVal}
        );
        d.add(form, BorderLayout.CENTER);
        d.add(dialogBtns(() -> {
            int campoIdx   = cbCampo.getSelectedIndex();
            int condIdx    = cbCondCol.getSelectedIndex();
            String campo   = sqlCols[campoIdx];
            String val     = tValor.getText().trim();
            String condCol = sqlCols[condIdx];
            String condVal = tCondVal.getText().trim();
            if (val.isEmpty() || condVal.isEmpty()) { showError(d, "Rellena todos los campos."); return; }
            try {
                action.execute(campo, val, condCol, condVal);
                showSuccess(d, "Registro(s) actualizado(s) correctamente.");
            } catch (RuntimeException ex) {
                showError(d, "Error al actualizar: " + ex.getCause().getMessage());
                return;
            }
            d.dispose();
        }, () -> d.dispose()), BorderLayout.SOUTH);
        d.setVisible(true);
    }

    // =========================================================
    //  CONSTRUCTOR GENÉRICO DE PANEL ENTIDAD
    // =========================================================
    @FunctionalInterface
    interface TableAction { void run(JTable table); }

    static JPanel buildEntityPanel(String title, String[] headers,
                                   Supplier<Object[][]> loader,
                                   TableAction onInsert, TableAction onModify, TableAction onDelete) {

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(C_BG);

        // ---- Cabecera ----
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(C_BG);
        header.setBorder(new EmptyBorder(22, 26, 14, 26));

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(F_TITLE);
        titleLbl.setForeground(C_TEXT);
        header.add(titleLbl, BorderLayout.WEST);

        // ---- Tabla ----
        DefaultTableModel model = new DefaultTableModel(loader.get(), headers) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable table = buildTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(C_BG);
        scroll.setBorder(BorderFactory.createLineBorder(C_BORDER));
        scroll.getViewport().setBackground(C_ROW);

        // ---- Barra de herramientas ----
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        toolbar.setBackground(C_BG);
        toolbar.setBorder(new EmptyBorder(0, 20, 8, 20));

        JButton btnRefresh = toolBtn("🔄  Actualizar", C_BORDER);
        btnRefresh.addActionListener(e -> refreshTable(table, loader));
        toolbar.add(btnRefresh);

        if (onInsert != null) {
            JButton btn = toolBtn("➕  Insertar", C_SUCCESS);
            btn.addActionListener(e -> { onInsert.run(table); refreshTable(table, loader); });
            toolbar.add(btn);
        }
        if (onModify != null) {
            JButton btn = toolBtn("✏️  Modificar", C_ACCENT);
            btn.addActionListener(e -> { onModify.run(table); refreshTable(table, loader); });
            toolbar.add(btn);
        }
        if (onDelete != null) {
            JButton btn = toolBtn("🗑️  Eliminar", C_DANGER);
            btn.addActionListener(e -> onDelete.run(table));
            toolbar.add(btn);
        }

        // Solo lectura si no hay acciones de edición
        if (onInsert == null && onModify == null && onDelete == null) {
            JLabel soloLectura = new JLabel("  👁  Solo lectura para tu rol");
            soloLectura.setFont(F_SMALL);
            soloLectura.setForeground(C_MUTED);
            toolbar.add(soloLectura);
        }

        JPanel body = new JPanel(new BorderLayout());
        body.setBackground(C_BG);
        body.setBorder(new EmptyBorder(0, 22, 22, 22));
        body.add(scroll, BorderLayout.CENTER);

        root.add(header,  BorderLayout.NORTH);
        root.add(toolbar, BorderLayout.CENTER);
        root.add(body,    BorderLayout.SOUTH);

        // Reorganizar layout para que la tabla ocupe el espacio central
        root.removeAll();
        root.setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(C_BG);
        top.add(header,  BorderLayout.NORTH);
        top.add(toolbar, BorderLayout.SOUTH);

        root.add(top,  BorderLayout.NORTH);
        root.add(body, BorderLayout.CENTER);
        body.removeAll();
        body.add(scroll, BorderLayout.CENTER);

        return root;
    }

    // =========================================================
    //  UTILIDADES UI
    // =========================================================

    /** Construye una JTable con el estilo oscuro del tema. */
    static JTable buildTable(DefaultTableModel model) {
        JTable t = new JTable(model);
        t.setBackground(C_ROW);
        t.setForeground(C_TEXT);
        t.setFont(F_BODY);
        t.setRowHeight(30);
        t.setShowGrid(false);
        t.setIntercellSpacing(new Dimension(0, 0));
        t.setSelectionBackground(C_ACCENT.darker());
        t.setSelectionForeground(C_TEXT);
        t.setFocusable(false);

        // Fondo alternado
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) c.setBackground(row % 2 == 0 ? C_ROW : C_ROW_ALT);
                c.setForeground(isSelected ? C_TEXT : C_TEXT);
                setBorder(new EmptyBorder(0, 10, 0, 10));
                return c;
            }
        });

        // Cabecera
        JTableHeader hdr = t.getTableHeader();
        hdr.setBackground(C_HDR);
        hdr.setForeground(C_MUTED);
        hdr.setFont(new Font("Segoe UI", Font.BOLD, 12));
        hdr.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, C_ACCENT));
        hdr.setReorderingAllowed(false);

        return t;
    }

    static void refreshTable(JTable table, Supplier<Object[][]> loader) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[][] data = loader.get();
        for (Object[] row : data) model.addRow(row);
    }

    /** Crea un diálogo modal centrado en la ventana principal. */
    static JDialog createDialog(String title, int w, int h) {
        JDialog d = new JDialog(ventanaPrincipal, title, true);
        d.setSize(w, h);
        d.setLocationRelativeTo(ventanaPrincipal);
        d.setResizable(false);
        d.setLayout(new BorderLayout());
        d.getContentPane().setBackground(C_BG);
        return d;
    }

    /** Panel de formulario de etiqueta + campo vertical. */
    static JPanel buildForm(String[] labels, JComponent[] fields) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(C_BG);
        p.setBorder(new EmptyBorder(20, 24, 10, 24));
        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = sectionLabel(labels[i]);
            lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            fields[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            fields[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
            p.add(lbl);
            p.add(Box.createVerticalStrut(5));
            p.add(fields[i]);
            if (i < labels.length - 1) p.add(Box.createVerticalStrut(14));
        }
        return p;
    }

    /** Panel con botones Aceptar / Cancelar. */
    static JPanel dialogBtns(Runnable onOk, Runnable onCancel) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT, 14, 12));
        p.setBackground(C_SURFACE);
        p.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, C_BORDER));
        JButton ok  = accentBtn("Aceptar");
        JButton can = grayBtn("Cancelar");
        ok.addActionListener(e -> onOk.run());
        can.addActionListener(e -> onCancel.run());
        p.add(can); p.add(ok);
        return p;
    }

    static void showError(String msg) {
        JOptionPane.showMessageDialog(ventanaPrincipal, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    static void showError(JDialog parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    static void showSuccess(String msg) {
        JOptionPane.showMessageDialog(ventanaPrincipal, msg, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    static void showSuccess(JDialog parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    static boolean confirm(String msg) {
        return JOptionPane.showConfirmDialog(ventanaPrincipal, msg, "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION;
    }

    // =========================================================
    //  COMPONENTES ESTILIZADOS
    // =========================================================

    static JLabel sectionLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(F_LABEL);
        l.setForeground(C_MUTED);
        return l;
    }

    static JTextField styledField() {
        JTextField f = new JTextField();
        applyFieldStyle(f);
        return f;
    }

    static void applyFieldStyle(JTextField f) {
        f.setBackground(C_SURFACE);
        f.setForeground(C_TEXT);
        f.setFont(F_BODY);
        f.setCaretColor(C_ACCENT);
        f.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(C_BORDER),
                new EmptyBorder(6, 10, 6, 10)
        ));
        f.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
    }

    static <T> JComboBox<T> styledCombo(T[] items) {
        JComboBox<T> cb = new JComboBox<>(items);
        cb.setBackground(C_SURFACE);
        cb.setForeground(C_TEXT);
        cb.setFont(F_BODY);
        cb.setBorder(BorderFactory.createLineBorder(C_BORDER));
        cb.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        return cb;
    }

    static JButton accentBtn(String text) {
        JButton b = new JButton(text);
        b.setBackground(C_ACCENT);
        b.setForeground(Color.WHITE);
        b.setFont(F_BTN);
        b.setBorder(new EmptyBorder(10, 22, 10, 22));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    static JButton grayBtn(String text) {
        JButton b = new JButton(text);
        b.setBackground(C_BORDER);
        b.setForeground(C_TEXT);
        b.setFont(F_BTN);
        b.setBorder(new EmptyBorder(10, 22, 10, 22));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    static JButton toolBtn(String text, Color color) {
        JButton b = new JButton(text);
        b.setBackground(color.darker());
        b.setForeground(C_TEXT);
        b.setFont(F_BODY);
        b.setBorder(new EmptyBorder(8, 16, 8, 16));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    static JButton navBtn(String text) {
        JButton b = new JButton(text);
        b.setBackground(C_SIDEBAR);
        b.setForeground(C_TEXT);
        b.setFont(F_NAV);
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setBorder(new EmptyBorder(11, 20, 11, 20));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        b.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { b.setBackground(C_SURFACE); }
            @Override public void mouseExited(MouseEvent e)  { b.setBackground(C_SIDEBAR); }
        });
        return b;
    }

    static JSeparator hSep() {
        JSeparator s = new JSeparator(SwingConstants.HORIZONTAL);
        s.setForeground(C_BORDER);
        s.setBackground(C_BORDER);
        s.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        return s;
    }

    static String capFirst(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    // Getter para compatibilidad con DemoConsola
    public static Integer getIdUsuarioActual() { return idUsuarioActual; }
}