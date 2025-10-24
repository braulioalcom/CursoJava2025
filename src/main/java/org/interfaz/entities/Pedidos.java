package org.interfaz.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedidos {

        private Long id;
        private String cliente;
        private LocalDate fecha;
        private String detalle;
        private double montoTotal;
        private String estado;

        public Pedidos() {}


        public Pedidos(Long id, String cliente, LocalDate fecha, String detalle, Double montoTotal, String estado) {
            this.id = id;
            this.cliente = cliente;
            this.fecha = fecha;
            this.detalle = detalle;
            this.montoTotal = montoTotal;
            this.estado = estado;
        }

        // Getters
        public Long getId() {
            return id;
        }

        public String getCliente() {
            return cliente;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public String getDetalle() {
            return detalle;
        }

        public Double getMontoTotal() {
            return montoTotal;
        }

        public String getEstado() {
            return estado;
        }

        // Setters
        public void setId(Long id) {
            this.id = id;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public void setDetalle(String detalle) {
            this.detalle = detalle;
        }

        public void setMontoTotal(Double montoTotal) {
            this.montoTotal = montoTotal;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
}
