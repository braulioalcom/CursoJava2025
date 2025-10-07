package org.interfaz;

import org.interfaz.crud.ProductosCRUD;
import org.interfaz.entities.Productos;
import org.interfaz.entities.audit;
import org.interfaz.util.StringTable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductosCRUD crud = new ProductosCRUD();
        boolean salir = false;

        imprimirBanner();

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarAlta(scanner, crud);
                    break;
                case "2":
                    realizarBaja(scanner, crud);
                    break;
                case "3":
                    realizarConsulta(crud);
                    break;
                case "4":
                    audit a = new audit();
                    a.setFecha(LocalDateTime.now());
                    a.setAccion("Saliendo de la aplicación");
                    System.out.println(a.toString());
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void imprimirBanner() {
        System.out.println("====================================");
        System.out.println("   Sistema de Productos (Consola)   ");
        System.out.println("====================================");
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("  1) Alta de producto");
        System.out.println("  2) Baja de producto");
        System.out.println("  3) Consultar productos");
        System.out.println("  4) Salir");
    }

    private static void realizarAlta(Scanner scanner, ProductosCRUD crud) {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine().trim();
            System.out.print("Precio Proveedor: ");
            double precioProveedor = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Precio Cliente: ");
            double precioCliente = Double.parseDouble(scanner.nextLine().trim());

            ProductosCRUD.altaOModificacion(id, nombre, descripcion, precioProveedor, precioCliente);

            audit a = new audit();
            a.setFecha(LocalDateTime.now());
            a.setAccion("Alta realizada para producto ID: " + id);
            System.out.println(a.toString());
        } catch (NumberFormatException ex) {
            System.out.println("Precio inválido. Operación cancelada.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void realizarBaja(Scanner scanner, ProductosCRUD crud) {
        System.out.print("Ingrese el ID a eliminar: ");
        String id = scanner.nextLine().trim();
        crud.eliminar(id);
    }

    private static void realizarConsulta(ProductosCRUD crud) {
        List<Productos> lista = ProductosCRUD.getListProductos();
        audit a = new audit();
        a.setFecha(LocalDateTime.now());
        a.setAccion("Consulta de productos (" + lista.size() + ")");
        System.out.println(a.toString());

        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        StringTable.addRows(lista);
    }

    private static String safe(Object v) {
        return v == null ? "-" : v.toString();
    }
}
