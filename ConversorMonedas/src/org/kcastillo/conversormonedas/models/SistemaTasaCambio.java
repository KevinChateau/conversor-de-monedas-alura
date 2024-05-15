package org.kcastillo.conversormonedas.models;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaTasaCambio {
    private Instant ultimaActualizacion;
    private String codigoBase;
    private TasaCambiosInd tasaDeCambios;

    public SistemaTasaCambio(TasaCambiosRecord tasaCambiosRecord) {
        this.ultimaActualizacion = Instant.ofEpochSecond(tasaCambiosRecord.time_last_update_unix());
        this.codigoBase = tasaCambiosRecord.base_code();
        this.tasaDeCambios = tasaCambiosRecord.conversion_rates();
    }

    public Instant getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public String getUltimaActualizacionString() {
        // Convertir Instant a ZonedDateTime en la zona horaria predeterminada (UTC)
        ZonedDateTime zonedDateTime = ultimaActualizacion.atZone(ZoneId.of("UTC"));
        // Formatear el ZonedDateTime en formato personalizado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return formatter.format(zonedDateTime);
    }

    public String getCodigoBase() {
        return codigoBase;
    }

    public TasaCambiosInd getTasaDeCambios() {
        return tasaDeCambios;
    }

    public double convertirTasaCambios(double cantidad, String codigoMoneda, boolean dolarAMoneda){

        double valorConvertido = -1.0;

        switch (codigoMoneda.toUpperCase()){
            case "ARS":
                //Si la conversión es de dólar a una moneda específica, el valor se multiplica
                valorConvertido = dolarAMoneda? cantidad*tasaDeCambios.ARS(): cantidad/tasaDeCambios.ARS();
                break;
            case "CLP": //Peso chileno
                valorConvertido =  dolarAMoneda? cantidad*tasaDeCambios.CLP():cantidad/tasaDeCambios.CLP();
                break;
            case "COP": //Peso colombiano
                valorConvertido =  dolarAMoneda? cantidad*tasaDeCambios.COP(): cantidad/tasaDeCambios.COP();
                break;
            default:
                valorConvertido = 0.0;
        }

        return valorConvertido;
    }

    @Override
    public String toString() {
        return "SistemaTasaCambio{" +
                "ultimaActualizacion='" + ultimaActualizacion + '\'' +
                ", codigoBase='" + codigoBase + '\'' +
                ", tasaDeCambios=" + tasaDeCambios +
                '}';
    }
}
