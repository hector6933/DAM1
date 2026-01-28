package prob4_SobrecargaDeOperadores;

public class Punto {

    private Double x;
    private Double y;

    public Punto(){

    }

    public Punto(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public void mostrarPos(){

        System.out.println("X: " + x + " | Y: " + y);

    }

    public Punto sumarPuntos(Punto punto1){
        return new Punto(punto1.getX() + this.x, punto1.getY() + this.y);

    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
}
