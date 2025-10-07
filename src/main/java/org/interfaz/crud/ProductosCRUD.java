package org.interfaz.crud;

import org.interfaz.ListadoDeProductos;
import org.interfaz.entities.Productos;
import org.interfaz.entities.audit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductosCRUD {
    static List<Productos> listProductos= new ArrayList<>();

    public ProductosCRUD  (){
        listProductos.addAll(ListadoDeProductos.dbInit());
    }

    /**
     * Elimina por producto seleccionado
     * @param id
     */
    public void eliminar (String id){
        for (Productos p: listProductos){
            if (p.getId().equals(id)){
                listProductos.remove(p);
                audit a = new audit();
                a.setFecha(LocalDateTime.now());
                a.setAccion("Se ha eliminado el producto con ID: " + id);
                System.out.println(a.toString());
                break;
            }
        }
    }

    // Helper para construir instancias de Productos de forma concisa
    public static void altaOModificacion(String id, String nombre, String descripcion, double precioProveedor, double precioCliente) {
        Productos p = new Productos();
        p.setId(id);
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecioProveedor(precioProveedor);
        p.setPrecioCliente(precioCliente);
        listProductos.add(p);
    }

    /**
     * Obtiene la lista de productos
     * @return List<Productos>
     */
    public static List<Productos> getListProductos() {
        
        return listProductos;
    }

    /**
     * Devuelve la cantidad de productos almacenados.
     * @return
     */
    public int size() {
        return listProductos.size();
    }

}
