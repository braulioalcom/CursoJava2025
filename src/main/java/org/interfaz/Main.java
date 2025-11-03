package org.interfaz;

import org.interfaz.crud.ProductosCRUD;
import org.interfaz.crud.ClientesCRUD;
import org.interfaz.entities.Productos;
import org.interfaz.entities.Clientes;
import org.interfaz.entities.Audit;
import org.interfaz.util.StringTable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductosCRUD crudProductos = new ProductosCRUD();
        ClientesCRUD crudClientes = new ClientesCRUD();
        boolean salir = false;

        imprimirBanner();

        while (!salir) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarAltaProducto(scanner, crudProductos);
                    break;
                case "2":
                    realizarBajaProducto(scanner, crudProductos);
                    break;
                case "3":
                    realizarConsultaProductos(crudProductos);
                    break;
                case "5":
                    realizarAltaCliente(scanner, crudClientes);
                    break;
                case "6":
                    realizarBajaCliente(scanner, crudClientes);
                    break;
                case "7":
                    realizarConsultaClientes(crudClientes);
                    break;
                case "4":
                    Audit a = new Audit();
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
        System.out.println("   Sistema de Productos y Clientes   ");
        System.out.println("====================================");
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("  1) Alta de producto");
        System.out.println("  2) Baja de producto");
        System.out.println("  3) Consultar productos");
        System.out.println("  4) Salir");
        System.out.println("  5) Alta de cliente");
        System.out.println("  6) Baja de cliente");
        System.out.println("  7) Consultar clientes");
    }

    private static void realizarAltaProducto(Scanner scanner, ProductosCRUD crud) {
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

            Audit a = new Audit();
            a.setFecha(LocalDateTime.now());
            a.setAccion("Alta realizada para producto ID: " + id);
            System.out.println(a.toString());
        } catch (NumberFormatException ex) {
            System.out.println("Precio inválido. Operación cancelada.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void realizarBajaProducto(Scanner scanner, ProductosCRUD crud) {
        System.out.print("Ingrese el ID a eliminar: ");
        String id = scanner.nextLine().trim();
        crud.eliminar(id);
    }

    private static void realizarConsultaProductos(ProductosCRUD crud) {
        List<Productos> lista = ProductosCRUD.getListProductos();
        Audit a = new Audit();
        a.setFecha(LocalDateTime.now());
        a.setAccion("Consulta de productos (" + lista.size() + ")");
        System.out.println(a.toString());

        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        StringTable.addRows(lista);
    }

    // ====== CLIENTES ======
    private static void realizarAltaCliente(Scanner scanner, ClientesCRUD crud) {
        try {
            System.out.print("ID Cliente: ");
            String id = scanner.nextLine().trim();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine().trim();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine().trim();

            ClientesCRUD.altaOModificacion(id, nombre, email, telefono, direccion);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void realizarBajaCliente(Scanner scanner, ClientesCRUD crud) {
        System.out.print("Ingrese el ID de cliente a eliminar: ");
        String id = scanner.nextLine().trim();
        crud.eliminar(id);
    }

    private static void realizarConsultaClientes(ClientesCRUD crud) {
        List<Clientes> lista = ClientesCRUD.getListClientes();
        Audit a = new Audit();
        a.setFecha(LocalDateTime.now());
        a.setAccion("Consulta de clientes (" + lista.size() + ")");
        System.out.println(a.toString());

        if (lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        // Imprimir una tabla sencilla de clientes
        final int anchoId = 12;
        final int anchoNombre = 25;
        final int anchoEmail = 30;
        final int anchoTelefono = 15;
        final int anchoDireccion = 30;
        String header = String.format("%-" + anchoId + "s %-" + anchoNombre + "s %-" + anchoEmail + "s %-" + anchoTelefono + "s %-" + anchoDireccion + "s%n",
                "ID", "Nombre", "Email", "Teléfono", "Dirección");
        String sep = "-".repeat(anchoId + 1 + anchoNombre + 1 + anchoEmail + 1 + anchoTelefono + 1 + anchoDireccion) + System.lineSeparator();
        System.out.print(header);
        System.out.print(sep);
        for (Clientes c : lista) {
            System.out.printf("%-" + anchoId + "s %-" + anchoNombre + "s %-" + anchoEmail + "s %-" + anchoTelefono + "s %-" + anchoDireccion + "s%n",
                    safe(c.getId()), safeOrEmpty(c.getNombre()), safeOrEmpty(c.getEmail()), safeOrEmpty(c.getTelefono()), safeOrEmpty(c.getDireccion()));
        }
    }

    private static String safe(Object v) {
        return v == null ? "-" : v.toString();
    }

    private static String safeOrEmpty(Object v) {
        return v == null ? "" : v.toString();
    }
}
