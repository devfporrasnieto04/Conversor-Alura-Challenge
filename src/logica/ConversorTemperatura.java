package logica;

public class ConversorTemperatura {

    private double convertir(double valor, String de, String a){
        double temperaturaConvertida = 0.0;

        switch (de) {
            case "ºC" -> {
                double C_F = (valor * 9 / 5) + 32;
                double C_K = valor + 273.15;
                if (a.equals("ºF")) {
                    temperaturaConvertida = C_F;
                } else if (a.equals("K")) {
                    temperaturaConvertida = C_K;
                }
            }
            case "ºF" -> {
                double F_C = (valor - 32) * 5 / 9;
                double F_K = (valor - 32) * 5 / 9 + 273.15;
                if (a.equals("ºC")) {
                    temperaturaConvertida = F_C;
                } else if (a.equals("K")) {
                    temperaturaConvertida = F_K;
                }
            }
            case "K" -> {
                double K_C = valor - 273.15;
                double K_F = (valor - 273.15) * 9 / 5 + 32;
                if (a.equals("ºC")) {
                    temperaturaConvertida = K_C;
                } else if (a.equals("ºF")) {
                    temperaturaConvertida = K_F;
                }
            }
            default -> {
                System.out.println("Tipo de temperatura no soportada.");
            }
        }
        return temperaturaConvertida;
    }

}
