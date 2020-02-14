package edu.eci.arem.parcial;

import static spark.Spark.get;
import static spark.Spark.port;

import spark.Request;
import spark.Response;

/**
 * Función principal de la WebApp
 */
public class SparkWebApp {
    public static void main(String[] args) {
        port(getPort());
        get("/ingresarDatos", (req, res) -> inputDataPage(req,res));
        get("/results", (req, res) -> resultsPage(req,res));
    }

    /**
     * Muestra la pagina principal que se le muestra al usuario
     * @param req Solicitud de petición
     * @param res solicitud de respuesta
     * @return Devuelve un String que contiene el código html de la página principal
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "<meta http-equiv='X-UA-Compatible' content='ie=edge'>"
                + "<title>Document</title>"
                +"<style>"
                +"body{"
                +"    background-color: azure;"
                +"}"
                +"h1{"
                +   "text-align: center;"
                +   "color: darkgrey;"
                +"}"
                +"</style>"
                + "</head>"
                + "<body>"
                + "<h1>WebApp with spark framework</h2>"
                + "<form action=\"/results\">"
                + "  <h2 style='text-align: center;'>Hola mundo</h2>"
                + "<div style='text-align: center;'>"
                + "  <input style='text-align: center;' type=\"text\" name=\"Datos\">"
                + "</div>"
                + "  <br><br>"
                + "<div style='text-align: center;'>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</div>"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    /**
     * 
     * @param req Solicitud de petición
     * @param res   Solicitud de respuesta
     * @return Devuelve un Strin que contiene la pagina que contiene las respuestas de la desviacion y media
     */
    private static String resultsPage(Request req, Response res) {

        String response
            = "<!DOCTYPE html>"
            + "<html lang='en'>"
            + "<head>"
            +    "<meta charset='UTF-8'>"
            +    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            +    "<meta http-equiv='X-UA-Compatible' content='ie=edge'>"
            +"<style>"
            +"body{"
            +    "background-color:rgb(143, 142, 142);"
            +"}"
            +"h2{"
            +    "text-align: center;"
            +    "color: azure;"
            +"}"
            +"h1{"
            +    "text-align: center;"
            +    "or:burlywood;"
            +"}"
            +"</style>"
            +    "<title>Respuesta</title>"
            +"</head>"
            + "<body>"
            + "<h1>Resultados Obtenidos</h1>"
            + "<h2>La desviación estandar de los datos es: " + "</h2>"
            + "<h2>La media de los datos ingresados es: " + "</h2>"
            + "</body>"
            + "</html>";
        return response;
    }

    /**
     * Se encarga de brindar el puerto, donde se encuatra la aplicación
     * @return El puerto donde se desplegará la aplicación
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
