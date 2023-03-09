package persistencia;

import logica.ConversorTemperatura;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class TemperaturePanel extends JFrame implements conversorSetings {
    private JPanel temperaturePanel;
    private JComboBox comboBoxTemperaturaOrigen;
    private JComboBox comboBoxTemperaturaDestino;
    private JLabel textTemperaturaOrigen;
    private JFormattedTextField valor;
    private JButton convertButton;
    private JButton menuButton;
    private JButton salirButton;
    private JLabel textValorTemperatura;
    private final ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
    private JLabel textResult;
    private JLabel textTemperaturaDestino;
    private JSeparator separator2;
    private JSeparator separator1;


    public TemperaturePanel(){
        configurarVentana();
        mostrarPanel();
        configBtns();
        configValor();
    }

    /**
     se crea este metodo para que el campo valor solo pueda recibir numeros entre 0 9 positivos
     */
    private void configValor (){
        valor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int Key = e.getKeyChar();
                boolean numero = Key >= 48 && Key <= 57;
                if(!numero){
                    e.consume();
                }

            }
        });

    }
    @Override
    public void configurarVentana() {
        setTitle("Temperature Converter");
        setSize(300,400);
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
        getContentPane().add(temperaturePanel);
        revalidate();
        repaint();
    }

    @Override
    public void configBtns() {
        convertButton.addActionListener(e -> {
            try {
                // Obtener los datos de valor y guardarlos en una variable
                double temperaturaValor = Double.parseDouble(valor.getText());
                String temperaturaOrigenSeleccionada = Objects.requireNonNull(comboBoxTemperaturaOrigen.getSelectedItem()).toString();
                String temperaturaDestinoSeleccionada = Objects.requireNonNull(comboBoxTemperaturaDestino.getSelectedItem()).toString();

                // Realizar la conversión utilizando el conversor de temperatura mediante el metodo convertir
                double resultado = conversorTemperatura.convertir(temperaturaValor,temperaturaOrigenSeleccionada,temperaturaDestinoSeleccionada);
                // Mostrar el resultado en el JLabel
                textResult.setText("Result: "+String.valueOf(resultado));
            } catch (NumberFormatException ex) {
                // Manejar la excepción si el monto no es un número válido
                textResult.setText("Error: monto inválido");
            }
        });

        menuButton.addActionListener(e -> {
            MenuPanel1 menuPanel11 = new MenuPanel1();
            menuPanel11.setVisible(true);
            temperaturePanel.setVisible(false);
            dispose();
        });

        salirButton.addActionListener(e -> System.exit(0));
    }
}
