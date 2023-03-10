package persistencia;

import logica.ConversorMasa;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Objects;

public class MasaPanel extends JFrame implements conversorSetings {
    private JPanel masaPanel;
    private JFormattedTextField valor;
    private JLabel textValor;
    private JSeparator separator1;
    private JComboBox comboBoxMasaOrigen;
    private JLabel textComboBoxMasaOrigen;
    private JComboBox comboBoxMasaDestino;
    private JButton convertButton;
    private JLabel resultLabel;
    private JButton menuButton;
    private JButton salirButton;
    private JLabel textComoBoxMasaDestino;
    private JSeparator separator2;
    private final ConversorMasa conversorMasa = new ConversorMasa();


    public MasaPanel() {
        configurarVentana();
        mostrarPanel();
        configBtns();
        configValor();

    }

    private void configValor(){
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
        setTitle("Mass Unit Converter");
        setSize(300,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void mostrarPanel() {
        getContentPane().removeAll();
        getContentPane().add(masaPanel);
        revalidate();
        repaint();
    }

    @Override
    public void configBtns() {
        convertButton.addActionListener(e -> {
            try{
                //Obtener los datos de valor y guardarlos en una variable
                double masaValor = Double.parseDouble(valor.getText());
                String masaOrigenSeleccionada = Objects.requireNonNull(Objects.requireNonNull(comboBoxMasaOrigen.getSelectedItem()).toString());
                String masaDestinoSeleccionada = Objects.requireNonNull(Objects.requireNonNull(comboBoxMasaDestino.getSelectedItem()).toString());
                // Realizar la conversión utilizando el conversor de unidad de medida mediante el metodo convertir
                double resultado = conversorMasa.convertir(masaValor,masaOrigenSeleccionada,masaDestinoSeleccionada);
                // Dar formato al número utilizando DecimalFormat
                DecimalFormat df = new DecimalFormat("#,###.##");
                String resultadoFormateado = df.format(resultado);
                // Mostrar el resultado en el JLabel result
                resultLabel.setText("Result: "+masaDestinoSeleccionada+" "+resultadoFormateado);
            }catch (NumberFormatException ex){
                // Manejar la excepción si el valor no es un número válido
                resultLabel.setText("Error: valor inválido");
            }
        });

        menuButton.addActionListener(e -> {
            MenuPanel1 menuPanel1 = new MenuPanel1();
            menuPanel1.setVisible(true);
            masaPanel.setVisible(false);
            dispose();
        });

        salirButton.addActionListener(e -> System.exit(0));
    }
}
