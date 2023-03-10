package logica;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import org.json.JSONObject;
public class ConversorMoneda {
    private static final String PROPERTIES_FILE = "config.properties";
    private static String apikey;
    public ConversorMoneda() {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream(PROPERTIES_FILE);
            // Carga las propiedades del archivo de configuración
            propiedades.load(entrada);
            // Obtiene la clave de la API
           apikey = propiedades.getProperty("open_exchange_api_key");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static double convertir(double cantidad, String de, String a) throws IOException {
        double tasaDe = getTasaConversion(de);
        double tasaA = getTasaConversion(a);
        return cantidad * (1 / tasaDe) * tasaA;
    }

    private static double getTasaConversion(String moneda) throws IOException {
        URL url = new URL("https://api.exchangerate-api.com/v4/latest/COP");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        JSONObject jsonObject = new JSONObject(response.toString());
        JSONObject rates = jsonObject.getJSONObject("rates");
        double tasa = 0.0;
        switch (moneda) {
            case "COP" -> tasa = 1.0;
            case "USD" -> tasa = rates.getDouble("USD");
            case "EUR" -> tasa = rates.getDouble("EUR");
            case "GBP" -> tasa = rates.getDouble("GBP");
            case "JPY" -> tasa = rates.getDouble("JPY");
            case "KRW" -> tasa = rates.getDouble("KRW");
            default -> tasa = 0.0;
        }
        if (tasa == 0.0) {
            throw new IOException("No se encontró tasa de conversión para " + moneda);
        }
        return tasa;
    }

}



