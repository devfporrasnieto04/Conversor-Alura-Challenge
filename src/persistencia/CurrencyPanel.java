package persistencia;

import logica.ConversorMoneda;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Objects;


public class CurrencyPanel extends JFrame implements conversorSetings{
    private MenuPanel1 menuPanel1;
    private JPanel currencyPanel;
    private JSeparator separator1;
    private JLabel textMonto;
    private JFormattedTextField monto;
    private JLabel textMonedaOrigen;
    private final ConversorMoneda conversorMoneda = new ConversorMoneda();
    private JComboBox <String> monedaOrigen;
    private JLabel textMonedaDestino;
    private JComboBox <String> monedaDestino;
    private JButton convert;
    private JLabel resultLabel;
    private JSeparator separator2;
    private JButton menuButton;
    private JButton salirBtn;




    public CurrencyPanel() {
        configurarVentana();
        mostrarPanel();
        configBtns();
        configMonto();

    }

    private void configMonto (){
        monto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                if (!Character.isDigit(key) && key != '.') {
                    e.consume();
                }
            }
        });

    }
    @Override
    public void configurarVentana() {
        setTitle("Currency Converter");
        setSize(300,428);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void agregarPanel() {

    }


    @Override
    public void mostrarPanel() {
        getContentPane().removeAll();
        getContentPane().add(currencyPanel);
        revalidate();
        repaint();
    }

    @Override
    public void configBtns() {
       convert.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   // Obtener los valores del monto y las monedas seleccionadas
                   double montoValor = Double.parseDouble(monto.getText());
                   String monedaOrigenSeleccionada = Objects.requireNonNull(monedaOrigen.getSelectedItem()).toString();
                   String monedaDestinoSeleccionada = Objects.requireNonNull(monedaDestino.getSelectedItem()).toString();
                   // Realizar la conversión utilizando el conversor de moneda
                   double resultado = ConversorMoneda.convertir(montoValor, monedaOrigenSeleccionada, monedaDestinoSeleccionada);
                    // Obtener el Locale correspondiente a la moneda de destino
                   Locale locale = switch (monedaDestinoSeleccionada) {
                       case "COP" -> new Locale("es", "CO","$");
                       case "USD" -> new Locale("en", "US","usd $");
                       case "EUR" -> new Locale("es", "ES","€");
                       case "GBP" -> new Locale("en", "GB","£");
                       case "JPY" -> new Locale("ja", "JP","¥");
                       case "KRW" -> new Locale("ko", "KR","₩");
                       default -> Locale.getDefault(); // Si no se reconoce la moneda, se utiliza el Locale por defecto del sistema
                   };
                   // Dar formato al número utilizando DecimalFormat
                   DecimalFormat df = new DecimalFormat("#,###.##");
                   String resultadoFormateado = df.format(resultado);
                   // Mostrar el resultado en el JLabel
                   resultLabel.setText("Result: " + locale.getVariant() +" "+ resultadoFormateado);
               } catch (NumberFormatException ex) {
                   // Manejar la excepción si el monto no es un número válido
                   resultLabel.setText("Error: monto inválido");

               }
           }
       });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPanel1 menuPanel11 = new MenuPanel1();
                menuPanel11.setVisible(true);
                currencyPanel.setVisible(false);
                dispose();
            }
        });

        salirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


