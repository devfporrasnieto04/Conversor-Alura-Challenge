package logica;

public class ConversorMoneda {
    private static final double USD_RATE = 0.00028;
    private static final double EUR_RATE = 0.00023;
    private static final double GBP_RATE = 0.00020;
    private static final double JPY_RATE = 0.030;
    private static final double KRW_RATE = 0.00032;
    private static final double COP_RATE = 0.00027;

    private String[] monedas = {"USD", "EUR", "GBP", "JPY", "KRW"};

    public String[] getMonedas() {
        return monedas;
    }

    public double convertir(double monedaOrigen, String de, String a) {
        double tasaOrigen, tasaDestino;
        tasaOrigen = switch (de) {
            case "NULL" -> 1;

            case "USD" -> USD_RATE;
            case "EUR" -> EUR_RATE;
            case "GBP" -> GBP_RATE;
            case "JPY" -> JPY_RATE;
            case "KRW" -> KRW_RATE;
            default ->  COP_RATE;
        };

       tasaDestino = switch (a) {
           case "NULL" -> 1;

           case "USD" -> USD_RATE;
           case "EUR" -> EUR_RATE;
           case "GBP" -> GBP_RATE;
           case "JPY" -> JPY_RATE;
           case "KRW" -> KRW_RATE;
           default ->   COP_RATE;
        };

        return  tasaOrigen * tasaDestino;
    }

    public double getValorMoneda(String moneda) {
        double tasaOrigen;
        switch (moneda) {
            case "COP":
                tasaOrigen = 1;
                break;
            case "USD":
                tasaOrigen = USD_RATE;
                break;
            case "EUR":
                tasaOrigen = EUR_RATE;
                break;
            case "GBP":
                tasaOrigen = GBP_RATE;
                break;
            case "JPY":
                tasaOrigen = JPY_RATE;
                break;
            case "KRW":
                tasaOrigen = KRW_RATE;
                break;
            default:
                throw new IllegalArgumentException("Moneda de origen no válida");
        }
        return tasaOrigen;
    }
}
