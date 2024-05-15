package org.kcastillo.conversormonedas.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObtenerFechaActual {

    public String ObtenerFecha(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        String formato = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return formato;
    }
}
