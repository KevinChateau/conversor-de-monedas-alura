package org.kcastillo.conversormonedas.models;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscribirConsulta {

    public void EscribirJson(String nombreArchivo, List<Consulta> consultas) throws IOException {
        FileWriter escritura = new FileWriter(nombreArchivo + ".json");
        escritura.write(new Gson().toJson(consultas));
        escritura.close();
    }
}
