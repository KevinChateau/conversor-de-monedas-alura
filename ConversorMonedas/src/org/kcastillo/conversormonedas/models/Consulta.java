package org.kcastillo.conversormonedas.models;

import java.time.LocalDateTime;

public class Consulta {

    private String fechaConsulta;
    private double cantidad;
    private String monedaActual;
    private String monedaAConvertir;
    private double cantidadConvertida;
    private double tasaCambio;
    private String ultimaActualización;

    public Consulta() {
    }


    public Consulta(String fechaConsulta, double cantidad) {
        this.fechaConsulta = fechaConsulta;
        this.cantidad = cantidad;
    }

    public String getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(String fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMonedaActual() {
        return monedaActual;
    }

    public void setMonedaActual(String monedaActual) {
        this.monedaActual = monedaActual;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public String getUltimaActualización() {
        return ultimaActualización;
    }

    public void setUltimaActualización(String ultimaActualización) {
        this.ultimaActualización = ultimaActualización;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fechaConsulta='" + fechaConsulta + '\'' +
                ", cantidad=" + cantidad +
                ", monedaActual='" + monedaActual + '\'' +
                ", monedaAConvertir='" + monedaAConvertir + '\'' +
                ", cantidadConvertida='" + cantidadConvertida + '\'' +
                ", tasaCambio=" + tasaCambio +
                ", ultimaActualización=" + ultimaActualización +
                '}';
    }
}
