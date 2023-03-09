package logica;

public class ConversorMasa {
    public double convertir (double valor, String de, String a){
       double masaConvertida = 0.0;
        switch (de) {
            case "G" -> {
                double G_K = valor * 0.001;
                double G_MG = valor * 1000;
                double G_T = valor * 0.000001;
                double G_LB = valor * 0.00220462;
                double G_OZ = valor * 0.035274;
               masaConvertida= switch (a) {
                    case "K" -> G_K;
                    case "MG" -> G_MG;
                    case "T" -> G_T;
                    case "LB" -> G_LB;
                    case "OZ" -> G_OZ;
                   default -> masaConvertida;
                };
            }
            case "K" -> {
                double K_G = valor * 1000;
                double K_MG = valor * 1000000;
                double K_T = valor * 0.001;
                double K_LB = valor * 2.20462;
                double K_OZ = valor * 35.274;
                masaConvertida = switch (a) {
                    case "G" -> K_G;
                    case "MG" -> K_MG;
                    case "T" -> K_T;
                    case "LB" -> K_LB;
                    case "OZ" -> K_OZ;
                    default -> masaConvertida;
                };

            }
            case "MG" -> {
                double MG_K = valor / 1000000;
                double MG_G = valor / 1000;
                double MG_OZ = valor / 28349.52;
                double MG_T = valor / 1000000000;
                double MG_LB = valor / 453592.37;
                masaConvertida = switch (a){
                    case "K" -> MG_K;
                    case "G" -> MG_G;
                    case "OZ" -> MG_OZ;
                    case "T" -> MG_T;
                    case "LB" -> MG_LB;
                    default -> masaConvertida;
                };
            }

            case "LB" -> {
                double LB_K = valor / 2.2046 ;
                double LB_G = valor / 0.0022046 ;
                double LB_OZ = valor * 16 ;
                double LB_T = valor / 2204.6 ;
                double LB_MG = valor  / 0.0000022046 ;
                masaConvertida = switch (a){
                    case "K" -> LB_K;
                    case "G" -> LB_G;
                    case "OZ" -> LB_OZ;
                    case "T" -> LB_T;
                    case "MG" -> LB_MG;
                    default -> masaConvertida;
                };
            }
            case "T" -> {
                double T_K = valor * 1000;
                double T_G = valor * 1000000;
                double T_OZ = valor * 35273.96195;
                double T_LB = valor * 2204.62262;
                double T_MG = valor * 1000000000;
                masaConvertida = switch (a){
                    case "K" -> T_K;
                    case "G" -> T_G;
                    case "OZ" -> T_OZ;
                    case "LB" -> T_LB;
                    case "MG" -> T_MG;
                    default -> masaConvertida;
                };
            }
            case "OZ" ->{
                double OZ_K = valor * 0.0283495;
                double OZ_G = valor * 28.3495;
                double OZ_LB = valor * 0.0625;
                double OZ_T = valor * 0.0000283495;
                double OZ_MG = valor * 28349.5;
                masaConvertida = switch (a){
                    case "K" -> OZ_K;
                    case "G" -> OZ_G;
                    case "LB" -> OZ_LB;
                    case "T" -> OZ_T;
                    case "MG" -> OZ_MG;
                    default -> masaConvertida;
                };
            }
            default -> System.out.println("Tipo de medida no soportado.");
        }
        return masaConvertida;
    }
}
