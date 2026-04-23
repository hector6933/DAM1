package Vista;

import Controlador.*;
import Modelo.*;
import Vista.DataManager;
import Vista.FrameLogin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class FrameMenu extends JFrame {

    private JPanel panelTabla;

    public FrameMenu() {

        setTitle("Menú");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton btnEmpleados = new JButton("Empleados");
        JButton btnDepartamentos = new JButton("Departamentos");
        JButton btnVehiculos = new JButton("Vehículos");
        JButton btnClientes = new JButton("Clientes");
        JButton btnUsuarios = new JButton("Usuarios");

        panelBotones.add(btnEmpleados);
        panelBotones.add(btnDepartamentos);
        panelBotones.add(btnVehiculos);
        panelBotones.add(btnClientes);
        panelBotones.add(btnUsuarios);

        add(panelBotones, BorderLayout.NORTH);

        panelTabla = new JPanel(new BorderLayout());
        add(panelTabla, BorderLayout.CENTER);


        btnEmpleados.addActionListener(e -> mostrarTabla(obtenerModeloEmpleados()));
        btnDepartamentos.addActionListener(e -> mostrarTabla(obtenerModeloDepartamentos()));
        btnVehiculos.addActionListener(e -> mostrarTabla(obtenerModeloVehiculos()));
        btnClientes.addActionListener(e -> mostrarTabla(obtenerModeloClientes()));
        btnUsuarios.addActionListener(e -> mostrarTabla(obtenerModeloUsuarios()));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new FrameLogin().setVisible(true);
            }
        });
    }

    private void mostrarTabla(DefaultTableModel modelo) {
        panelTabla.removeAll();

        if (modelo.getRowCount() == 0) {

            JLabel sinDatos = new JLabel("¡ No hay registros en la base de datos !", SwingConstants.CENTER);
            sinDatos.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
            panelTabla.add(sinDatos, BorderLayout.CENTER);

        } else {

            JTable tabla = new JTable(modelo);
            tabla.setEnabled(false);
            JScrollPane scroll = new JScrollPane(tabla);
            scroll.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            panelTabla.add(scroll, BorderLayout.CENTER);

        }

        panelTabla.revalidate(); // Esto es para que vuelva a construir el layout de una nueva tabla
        panelTabla.repaint(); // Para que visualmente se actualize a la nueva tabla
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

    private void mostrarErrorBD(SQLException ex) {
        JOptionPane.showMessageDialog(
                this,
                "Error al conectar con la base de datos:\n" + ex.getMessage(),
                "Error BD",
                JOptionPane.ERROR_MESSAGE
        );
    }
}