package org.interfaz.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class audit {
    private Integer id;
    private LocalDateTime fecha;
    private String accion;

    public audit() {}

    public audit(Integer id, LocalDateTime fecha, String accion) {
        this.id = id;
        this.fecha = fecha;
        this.accion = accion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        String f = fecha != null ? fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "";
        String a = accion != null ? accion : "";
        String i = id != null ? ("#" + id + " ") : "";
        return String.format("%s[%s] %s", i, f, a).trim();
    }
}
