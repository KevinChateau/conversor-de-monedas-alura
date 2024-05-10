import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.kcastillo.conversormonedas.models.ConexionExchangeRateApi;
import org.kcastillo.conversormonedas.models.TasaCambiosRecord;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = new ConexionExchangeRateApi().crearConexion();

        TasaCambiosRecord tasaCambiosRecord = gson.fromJson(json, TasaCambiosRecord.class);

        System.out.println(tasaCambiosRecord);
    }
}
