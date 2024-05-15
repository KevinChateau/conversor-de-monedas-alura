import org.kcastillo.conversormonedas.models.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        List<Consulta> consultas = new ArrayList<>();

        int respuesta = 0;
        double cantidadConvertir = 0.0;
        double cantidadConvertida = 0.0;


        try {

            while (respuesta != 6) {
                SistemaTasaCambio sistemaTasaCambio = new SistemaTasaCambio(new SerialJson().recibirJson());


                System.out.println("**************************************");
                System.out.println("\tSea bienvenido/a al Conversor de Moneda");
                System.out.println("""
                        1) Dólar => Peso argentino.
                        2) Peso argentino => Dólar.
                        3) Dólar => Peso chileno.
                        4) Peso chileno => Dólar.
                        5) Dólar =>  Peso colombiano.
                        6) Peso colombiano => Dólar.
                        7) Salir.
                        """);
                System.out.println("**************************************");
                System.out.print("Elija una opción válida: ");
                respuesta = scanner.nextInt();
                if (respuesta == 7) {
                    break;
                }
                System.out.print("Ingrese el valor que deseas convertir: $");
                cantidadConvertir = scanner.nextDouble();

                Consulta consultaActual = new Consulta(new ObtenerFechaActual().ObtenerFecha(), cantidadConvertir);

                switch (respuesta) {
                    case 1:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "ARS", true);
                        System.out.println("Dolar a peso argentino: " + cantidadConvertida);

                        consultaActual.setMonedaActual("USD");
                        consultaActual.setMonedaAConvertir("ARS");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().ARS());

                        break;
                    case 2:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "ARS", false);
                        System.out.println("Peso argentino a dólar: " + cantidadConvertida);
                        consultaActual.setMonedaActual("ARS");
                        consultaActual.setMonedaAConvertir("USD");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().ARS());
                        break;
                    case 3:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "CLP", true);
                        System.out.println("Dolar a peso chileno: " + cantidadConvertida);
                        consultaActual.setMonedaActual("USD");
                        consultaActual.setMonedaAConvertir("CLP");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().CLP());
                        break;
                    case 4:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "CLP", false);
                        System.out.println("Peso chileno a dólar: " + cantidadConvertida);
                        consultaActual.setMonedaActual("CLP");
                        consultaActual.setMonedaAConvertir("USD");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().CLP());
                        break;
                    case 5:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "COP", true);
                        System.out.println("Dolar a peso colombiano: " + cantidadConvertida);
                        consultaActual.setMonedaActual("USD");
                        consultaActual.setMonedaAConvertir("COP");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().COP());
                        break;
                    case 6:
                        cantidadConvertida = sistemaTasaCambio
                                .convertirTasaCambios(cantidadConvertir, "COP", false);
                        System.out.println("Peso colombiano a dólar: " + cantidadConvertida);
                        consultaActual.setMonedaActual("COP");
                        consultaActual.setMonedaAConvertir("USD");
                        consultaActual.setCantidadConvertida(cantidadConvertida);
                        consultaActual.setTasaCambio(sistemaTasaCambio.getTasaDeCambios().COP());
                        break;
                }


                consultaActual.setUltimaActualización(sistemaTasaCambio.getUltimaActualizacionString());
                consultas.add(consultaActual);

                System.out.println(consultas);


            }
        }catch (RuntimeException e){
            System.out.println("Error al ejecutar el programa, intente más tarde");
            System.out.println(e.getMessage());
        }
        new EscribirConsulta().EscribirJson("Consulta-" + new ObtenerFechaActual().obtenerSoloFecha(), consultas);


//        System.out.println(sistemaTasaCambio);



    }
}
