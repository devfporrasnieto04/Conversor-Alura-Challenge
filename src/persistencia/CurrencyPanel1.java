package persistencia;

import logica.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class CurrencyPanel1 extends JFrame implements conversorSetings{

    private JButton convertirButton = new JButton("Convertir");
    private JComboBox<String> comboBoxMonedaOrigen;
    private JComboBox<String> comboBoxMonedaDestino;
    private ConversorMoneda conversorMoneda;
    private JButton okButton = new JButton("ok");
    private JButton exitButton = new JButton("exit");

    public CurrencyPanel1(ConversorMoneda conversorMoneda) {

        configurarVentana();
        this.conversorMoneda = conversorMoneda;
        mostrarOpcionConvertidorMoneda();
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la moneda de origen y la moneda de destino seleccionadas
                double monedaOrigen = conversorMoneda.getValorMoneda((String)
                        Objects.requireNonNull(comboBoxMonedaOrigen.getSelectedItem()));
                String monedaDestino = (String) comboBoxMonedaDestino.getSelectedItem();

                // Acción del botón "Convertir" de la ventana del monto
            }
        });


    }



    protected Component crearConversorMoneda() {
        conversorMoneda = new ConversorMoneda();
        return null;
    }


    protected void mostrarOpcionConvertidorMoneda() {
        JPanel panelOpcionMonedas = new JPanel();
        panelOpcionMonedas.setLayout(new GridLayout());
        add(panelOpcionMonedas);
        // ComboBox para seleccionar la moneda de origen
        JLabel labelMonedaOrigen = new JLabel("Moneda de origen:");
        panelOpcionMonedas.add(labelMonedaOrigen);
        comboBoxMonedaOrigen = new JComboBox<>(conversorMoneda.getMonedas());
        panelOpcionMonedas.add(comboBoxMonedaOrigen);

        // ComboBox para seleccionar la moneda de destino
        JLabel labelMonedaDestino = new JLabel("Moneda de destino:");
        panelOpcionMonedas.add(labelMonedaDestino);
        comboBoxMonedaDestino = new JComboBox<>(conversorMoneda.getMonedas());
        panelOpcionMonedas.add(comboBoxMonedaDestino);


        JTextField textFieldMonto = new JTextField(10);
        panelOpcionMonedas.add(textFieldMonto);

        JButton convertirButton = new JButton("Convertir");
        panelOpcionMonedas.add(convertirButton);


        JLabel labelMonto = new JLabel("Monto a convertir:");
        panelOpcionMonedas.add(labelMonto);
        // Etiqueta para mostrar el resultado de la conversión
        JLabel labelResultado = new JLabel("");
        panelOpcionMonedas.add(labelResultado);

        // Botón para iniciar la conversión

        panelOpcionMonedas.add(convertirButton);


        // Agregar el panel al JFrame


        // Acción del botón "Convertir"

    }

    private void configBotones() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        ConversorMoneda ConversorMoneda = new ConversorMoneda();
        CurrencyPanel1 currencyPanel1 = new CurrencyPanel1(ConversorMoneda);
    }
//Configuracion de la ventana del panel
    @Override
    public void configurarVentana() {
        setVisible(true);
        setLayout(new BorderLayout());
        setName("Currency converter");
    }

    @Override
    public void agregarPanel() {

    }

    @Override
    public void mostrarPanel() {

    }

    @Override
    public void configBtns() {

    }
}



