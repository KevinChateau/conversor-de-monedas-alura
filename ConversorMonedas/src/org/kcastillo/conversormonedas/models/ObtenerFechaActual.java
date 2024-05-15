package org.kcastillo.conversormonedas.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObtenerFechaActual {

    public String ObtenerFecha(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        return fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }

    public String obtenerSoloFecha(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        return fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
