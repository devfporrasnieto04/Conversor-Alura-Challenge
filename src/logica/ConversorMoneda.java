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
        double tasa;
        switch(de) {
            case "COP":
                tasa = getTasaConversion(a);
                break;
            case "USD":
                tasa = USD_COP;
                break;
            case "EUR":
                tasa = EUR_COP;
                break;
            case "GBP":
                tasa = GBP_COP;
                break;
            case "JPY":
                tasa = JPY_COP;
                break;
            case "KRW":
                tasa = KRW_COP;
                break;
            default:
                tasa = 0.0;
                break;
        }
        // Calculamos la cantidad convertida y la devolvemos
        return cantidad * tasa;
    }

    private static double getTasaConversion(String moneda) {
        double tasa;
        switch(moneda) {
            case "COP":
                tasa = COP_COP;
                break;
            case "USD":
                tasa = COP_USD;
                break;
            case "EUR":
                tasa = COP_EUR;
                break;
            case "GBP":
                tasa = COP_GBP;
                break;
            case "JPY":
                tasa = COP_JPY;
                break;
            case "KRW":
                tasa = COP_KRW;
                break;
            default:
                tasa = 0.0;
                break;
        }
        return  tasa;
    }




//   public static void main(String[] args) {
//        ConversorMoneda conversorMoneda = new ConversorMoneda();
//            System.out.println(conversorMoneda.convertir(1,"COP", "EUR"));
//    }
}


