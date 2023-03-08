package logica;

public class ConversorMoneda {

    private static final double COP_USD = 0.00021;
    private static final double COP_EUR = 0.00020;
    private static final double COP_GBP = 0.00018;
    private static final double COP_JPY = 0.029;
    private static final double COP_KRW = 0.28;
    private static final double USD_COP = 4761.00;
    private static final double EUR_COP = 5014.38;
    private static final double GBP_COP = 5628.76;
    private static final double JPY_COP = 34.57;
    private static final double KRW_COP = 3.60;
    private static final double COP_COP = 1;

    public static double convertir(double cantidad, String de, String a) {
        // Definimos las tasas de conversión según las monedas
        double tasa = switch (de) {
            case "COP" -> getTasaConversion(a);
            case "USD" -> USD_COP;
            case "EUR" -> EUR_COP;
            case "GBP" -> GBP_COP;
            case "JPY" -> JPY_COP;
            case "KRW" -> KRW_COP;
            default -> 0.0;
        };
        // Calculamos la cantidad convertida y la devolvemos
        return cantidad * tasa;
    }

    private static double getTasaConversion(String moneda) {
        double tasa = switch (moneda) {
            case "COP" -> COP_COP;
            case "USD" -> COP_USD;
            case "EUR" -> COP_EUR;
            case "GBP" -> COP_GBP;
            case "JPY" -> COP_JPY;
            case "KRW" -> COP_KRW;
            default -> 0.0;
        };
        return  tasa;
    }




//   public static void main(String[] args) {
//        ConversorMoneda conversorMoneda = new ConversorMoneda();
//            System.out.println(conversorMoneda.convertir(1,"COP", "EUR"));
//    }
}


