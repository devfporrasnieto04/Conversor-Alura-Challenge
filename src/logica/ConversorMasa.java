package logica;

public class ConversorMasa {
    public double convertir (double valor, String de, String a){
       double masaConvertida = 0.0;
        switch (de){
            case "G" ->{
                double G_K = valor*0.001;
                double G_MG = valor*1000;
                double G_T = valor*0.000001;
                double G_LB = valor*0.00220462;
                double G_OZ = valor*0.035274;
                switch (a) {
                    case "K" -> masaConvertida = G_K;
                    case "MG" -> masaConvertida = G_MG;
                    case "T" -> masaConvertida = G_T;
                    case "LB" -> masaConvertida = G_LB;
                    case "OZ" -> masaConvertida = G_OZ;
                }
            }
            case "K" -> {
                double K_G = valor*1000;
                double K_MG = valor*1000000;
                double K_T = valor*0.001;
                double K_LB = valor*2.20462;
                double K_OZ = valor*35.274;
                masaConvertida = switch (a) {
                    case "G" -> K_G;
                    case "MG" -> K_MG;
                    case "T" -> K_T;
                    case "LB" -> K_LB;
                    case "OZ" -> K_OZ;
                    default -> masaConvertida;
                };

            }
            default -> System.out.println("Tipo de medida no soportado.");
        }
        return masaConvertida;
    }
}
