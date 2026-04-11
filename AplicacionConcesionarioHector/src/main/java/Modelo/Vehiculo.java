package Modelo;

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String tipoCombustible;
    private Double precio;
    private String dniCliente;
    private Integer numEmpleado;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, String tipoCombustible, Double precio, String dniCliente, Integer numEmpleado) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.precio = precio;
        this.dniCliente = dniCliente;
        this.numEmpleado = numEmpleado;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", precio=" + precio +
                ", dniCliente='" + dniCliente + '\'' +
                ", numEmpleado=" + numEmpleado +
                '}';
    }
}
