package org.interfaz;

import java.util.ArrayList;
import java.util.List;

import org.interfaz.entities.Productos;

/**
 * Clase utilitaria que proporciona un listado inicial de Productos a cargar.
 * No requiere instanciación: use el método estático obtener().
 */
public final class ListadoDeProductos {

    /**
     * Devuelve un listado de Productos de ejemplo para carga inicial.
     * @return lista de productos de ejemplo
     */
    public static List<Productos> dbInit() {
        List<Productos> lista = new ArrayList<>();

        Productos p1 = new Productos();
        p1.setId("P-001");
        p1.setNombre("Teclado Mecánico");
        p1.setDescripcion("Teclado mecánico con switches azules");
        p1.setPrecioProveedor(15000.0);
        p1.setPrecioCliente(100000.0);
        lista.add(p1);

        Productos p2 = new Productos();
        p2.setId("P-002");
        p2.setNombre("Mouse Inalámbrico");
        p2.setDescripcion("Mouse ergonómico 2.4G");
        p2.setPrecioProveedor(9800.0);
        p2.setPrecioCliente(5000.0);
        lista.add(p2);

        Productos p3 = new Productos();
        p3.setId("P-003");
        p3.setNombre("Monitor 24\"");
        p3.setDescripcion("Monitor Full HD 24 pulgadas");
        p3.setPrecioProveedor(700000.0);
        p3.setPrecioCliente(550000.0);
        lista.add(p3);

        Productos p4 = new Productos();
        p4.setId("P-004");
        p4.setNombre("Auriculares");
        p4.setDescripcion("Headset con cancelación de ruido");
        p4.setPrecioProveedor(24000.0);
        p4.setPrecioCliente(18000.0);
        lista.add(p4);

        Productos p5 = new Productos();
        p5.setId("P-005");
        p5.setNombre("Webcam HD");
        p5.setDescripcion("Cámara web 1080p con micrófono");
        p5.setPrecioProveedor(70000.0);
        p5.setPrecioCliente(50000.0);
        lista.add(p5);

        return lista;
    }

}
