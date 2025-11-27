public class Estudiante extends Personas{

    private Integer numExpediente;
    private Integer faltasAsistencia;
    private Integer examenes;

    public Estudiante() {

    }

    public Estudiante(String nombre, Double peso, Double altura, Integer edad, String dni, Integer numExpediente, Integer faltasAsistencia, Integer examenes) {

        super(nombre, peso, altura, edad, dni);
        this.numExpediente = numExpediente;
        this.faltasAsistencia = faltasAsistencia;
        this.examenes = examenes;

    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getFaltasAsistencia() {
        return faltasAsistencia;
    }

    public void setFaltasAsistencia(Integer faltasAsistencia) {
        this.faltasAsistencia = faltasAsistencia;
    }

    public Integer getExamenes() {
        return examenes;
    }

    public void setExamenes(Integer examenes) {
        this.examenes = examenes;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" +
                "numExpediente=" + numExpediente +
                ", faltasAsistencia=" + faltasAsistencia +
                ", examenes=" + examenes +
                '}';
    }

    @Override
    public String info() {
        return super.info() + ", numExpediente=" + numExpediente;
    }
}
