package presentacion;


import logica.ConversorMoneda;
import persistencia.CurrencyPanel1;
import persistencia.MenuPanel1;

public class ConversorApp {

    private final MenuPanel1 menuPanel1;


    public ConversorApp(MenuPanel1 menuPanel11) {
        this.menuPanel1 = menuPanel11;

        menuPanel1.setVisible(true);


    }

    public static void main(String[] args) {

        MenuPanel1 MenuPanel1 = new MenuPanel1();
        MenuPanel1.setVisible(true);
    }
}
