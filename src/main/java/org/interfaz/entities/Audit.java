package org.interfaz.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Esta clase sirve para registrar los cambios realizados a nivel consola.
 */
public class Audit {
    private Integer id;
    private LocalDateTime fecha;
    private String accion;

    /**
     * Audita segun los parametros seteados.
     */
    public Audit() {}

    public Audit(Integer id, LocalDateTime fecha, String accion) {
        this.id = id;
        this.fecha = fecha;
        this.accion = accion;
    }


    public Audit setId(Integer id) {
        this.id = id;
        return this;
    }


    public Audit setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }


    public Audit setAccion(String accion) {
        this.accion = accion;
        return this;
    }

    /**
     * Imprime en consola los resultados.
     */
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String f = fecha != null ? fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "";
        String a = accion != null ? accion : "";
        String i = id != null ? ("#" + id + " ") : "";
        return String.format("%s[%s] %s", i, f, a).trim();
    }
}
