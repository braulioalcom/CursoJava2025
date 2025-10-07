package org.interfaz.util;

public class Text {
    /**
     * Válida el formato de un texto.
     * Lo pasa a minuscula y elimina los espacios
     * @return String
     */
    public static String validFormat(String texto) {
        if(texto == null) throw  new IllegalArgumentException("El texto no puede ser nulo");
        return texto.toLowerCase().trim();
    }
}
