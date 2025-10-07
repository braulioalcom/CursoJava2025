package org.interfaz.entities;

/**
 * Todo el proyecto se centrara en esta clase Producto.
 */
public class Productos {
    public Productos() {}

    private String id;
    private String nombre;
    private String descripcion;
    // Usamos Double para poder validar nulos de forma explícita
    private Double precioProveedor=0.0;
    private Double precioCliente=0.0;

    /**
     * Obtiene el ID Interno del producto
     * @return el ID del producto
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del producto
     * ID Interno
     * @param id el ID a establecer
     */
    public void setId(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {
        if (nombre == null) throw new IllegalArgumentException("El nombre no puede ser nulo");
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * @param nombre el nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto
     * @return la descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto
     * @param descripcion la descripción a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del proveedor
     * @return precio del proveedor (no nulo)
     */
    public Double getPrecioProveedor() {
        if (precioProveedor == null) throw new IllegalArgumentException("El precio del proveedor no puede ser nulo");
        return precioProveedor;
    }

    /**
     * Establece el precio del proveedor
     * @param precioProveedor precio a establecer (no nulo)
     */
    public void setPrecioProveedor(Double precioProveedor) {
        if (precioProveedor == null) throw new IllegalArgumentException("El precio del proveedor no puede ser nulo");
        this.precioProveedor = precioProveedor;
    }

    /**
     * Obtiene el precio para el cliente
     * @return precio del cliente (no nulo)
     */
    public Double getPrecioCliente() {
        if (precioCliente == null) throw new IllegalArgumentException("El precio del cliente no puede ser nulo");
        return precioCliente;
    }

    /**
     * Establece el precio para el cliente
     * @param precioCliente precio a establecer (no nulo)
     */
    public void setPrecioCliente(Double precioCliente) {
        if (precioCliente == null) throw new IllegalArgumentException("El precio del cliente no puede ser nulo");
        this.precioCliente = precioCliente;
    }
}
