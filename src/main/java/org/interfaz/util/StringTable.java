package org.interfaz.util;

import org.interfaz.entities.Productos;

import java.util.List;

/**
 * Esta clase es una personalizacion para mostrar distintas columnas en una tabla realizada manejando un String.
 */
public class StringTable {

    public StringTable() {
    }

    public static void addRows(List<Productos> productos) {
        StringBuilder sb = new StringBuilder();
        if (productos != null && !productos.isEmpty()) {
            // Encabezado (corregido para evitar advertencias de formato)
            int anchoNombre = 30;
            int anchoDescripcion = 60;
            int anchoPrecioProveedor = 10;
            int anchoPrecioCliente = 10;
            String headerFormat =
                    "%-" + anchoNombre + "s " +
                            "%-" + anchoDescripcion + "s " +
                            "%" + anchoPrecioProveedor + "s " +
                            "%" + anchoPrecioCliente + "s%n";
            sb.append(String.format(headerFormat,
                    "Nombre", "Descripción", "$$ Proveedor", "$$ Cliente"));

            // Separador
            String separator = "-".repeat(anchoNombre + 1 + anchoDescripcion + 1 + anchoPrecioProveedor + 1 + anchoPrecioCliente)
                    + System.lineSeparator();
            sb.append(separator);

            // Filas de datos (precios con 2 decimales)
            String rowFormat =
                    "%-" + anchoNombre + "s " +
                            "%-" + anchoDescripcion + "s " +
                            "%" + anchoPrecioProveedor + ".2f " +
                            "%" + anchoPrecioCliente + ".2f%n";
            for (Productos p : productos) {
                sb.append(String.format(rowFormat,
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getPrecioProveedor(),
                        p.getPrecioCliente()));
            }
        }

        // Imprimir resultado (opcional) y devolver this para permitir encadenamiento
        System.out.print(sb.toString());
    }
}
