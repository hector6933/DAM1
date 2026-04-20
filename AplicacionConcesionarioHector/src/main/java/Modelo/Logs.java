package Modelo;

import java.time.LocalDateTime;

public final class Logs {

    private Usuario user;
    private LocalDateTime fechaYHora;
    private String accion;

    public Logs(Usuario user, LocalDateTime fechaYHora, String accion) {
        this.user = user;
        this.fechaYHora = fechaYHora;
        this.accion = accion;
    }
}
