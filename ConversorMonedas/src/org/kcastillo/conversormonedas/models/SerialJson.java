package org.kcastillo.conversormonedas.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerialJson {

    public TasaCambiosRecord recibirJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = new ConexionExchangeRateApi().crearConexion();

        TasaCambiosRecord tasaCambiosRecord = gson.fromJson(json, TasaCambiosRecord.class);
        return tasaCambiosRecord;
    }
}
