package org.interfaz.crud;

import org.interfaz.entities.Audit;
import org.interfaz.entities.Clientes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientesCRUD {
    static List<Clientes> listClientes = new ArrayList<>();

    public ClientesCRUD() {
        // Sin datos iniciales por ahora
    }

    /**
     * Alta o Modificación de un cliente. Si ya existe un cliente con el mismo ID, se reemplaza.
     */
    public static void altaOModificacion(String id, String nombre, String email, String telefono, String direccion) {
        Clientes c = new Clientes();
        c.setId(id);
        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(telefono);
        c.setDireccion(direccion);

        // Si ya existe el ID, lo quitamos para reemplazarlo
        listClientes.removeIf(cli -> id.equals(cli.getId()));
        listClientes.add(c);

        new Audit()
                .setFecha(LocalDateTime.now())
                .setAccion("Se agregó o modificó el cliente: " + c.toString())
                .print();
    }

    /**
     * Eliminación por ID de cliente
     */
    public void eliminar(String id) {
        boolean removed = listClientes.removeIf(c -> id != null && id.equals(c.getId()));
        if (removed) {
            new Audit()
                    .setFecha(LocalDateTime.now())
                    .setAccion("Se ha eliminado el cliente con ID: " + id)
                    .print();
        } else {
            new Audit()
                    .setFecha(LocalDateTime.now())
                    .setAccion("No se encontró cliente con ID: " + id)
                    .print();
        }
    }

    public static List<Clientes> getListClientes() {
        return listClientes;
    }

    public int size() {
        return listClientes.size();
    }
}
