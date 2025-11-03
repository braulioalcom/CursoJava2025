package org.interfaz.entities;

/**
 * Entidad Clientes para gestionar altas, bajas y modificaciones (ABM).
 */
public class Clientes {
    public Clientes() {}

    private String id;          // ID interno o documento
    private String nombre;      // Nombre o razón social
    private String email;       // Email de contacto
    private String telefono;    // Teléfono de contacto
    private String direccion;   // Dirección

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("El ID de cliente no puede ser nulo ni vacío");
        this.id = id.trim();
    }

    public String getNombre() {
        if (nombre == null)
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo");
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
