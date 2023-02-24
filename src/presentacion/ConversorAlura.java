package presentacion;

import logica.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorAlura extends JFrame {

    private JButton okButton;
    private JButton exitButton;
    private JComboBox<String> comboBoxOpciones;
    private JComboBox<String> comboBoxOpcionesMoneda;
    private JPanel panelMenu;
    private ConversorMoneda conversorMoneda;

    public ConversorAlura() {
        crearConversorMoneda();
        configurarVentana();
        agregarPanelMenu();
        configurarBotones();
        mostrarPanelMenu();
        comboBoxOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboBoxOpciones.getSelectedItem();
                getContentPane().removeAll();
                agregarPanelMenu();
                if (opcionSeleccionada.equals("Convertidor de moneda")) {
                    mostrarOpcionConvertidorMoneda();

                }
                // Agregar más opciones aquí...
                configurarBotones();
                revalidate();
            }
        });


    }

    private void crearConversorMoneda() {
        conversorMoneda = new ConversorMoneda();
    }

    private void configurarVentana() {
        setTitle("Conversor Alura");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void agregarPanelMenu() {
        panelMenu = new JPanel();
        panelMenu.setLayout(new FlowLayout());

        String[] opciones = {"Convertidor de moneda", "Convertidor de temperatura", "Convertidor de unidades"};

        comboBoxOpciones = new JComboBox<>(opciones);
        panelMenu.add(comboBoxOpciones);

        getContentPane().add(panelMenu, BorderLayout.NORTH);
    }

    private void mostrarPanelMenu() {
        getContentPane().removeAll();
        getContentPane().add(panelMenu, BorderLayout.NORTH);
        revalidate();
        repaint();
    }

private void mostrarOpcionConvertidorMoneda() {
    JPanel panelOpcionMonedas = new JPanel();
    panelOpcionMonedas.setLayout(new GridLayout());

    // ComboBox para seleccionar la moneda de origen
    JLabel labelMonedaOrigen = new JLabel("Moneda de origen:");
    panelOpcionMonedas.add(labelMonedaOrigen);
    JComboBox<String> comboBoxMonedaOrigen = new JComboBox<>(conversorMoneda.getMonedas());
    panelOpcionMonedas.add(comboBoxMonedaOrigen);

    // ComboBox para seleccionar la moneda de destino
    JLabel labelMonedaDestino = new JLabel("Moneda de destino:");
    panelOpcionMonedas.add(labelMonedaDestino);
    JComboBox<String> comboBoxMonedaDestino = new JComboBox<>(conversorMoneda.getMonedas());
    panelOpcionMonedas.add(comboBoxMonedaDestino);

    // Etiqueta para mostrar el resultado de la conversión
    JLabel labelResultado = new JLabel("");
    panelOpcionMonedas.add(labelResultado);

    // Botón para iniciar la conversión
    JButton convertirButton = new JButton("Convertir");
    panelOpcionMonedas.add(convertirButton);

    // Agregar el panel al JFrame
    getContentPane().removeAll();
    getContentPane().add(panelOpcionMonedas, BorderLayout.NORTH);
    revalidate();

    // Acción del botón "Convertir"
    convertirButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener la moneda de origen y la moneda de destino seleccionadas
            double monedaOrigen = conversorMoneda.getValorMoneda((String) comboBoxMonedaOrigen.getSelectedItem());
            String monedaDestino = (String) comboBoxMonedaDestino.getSelectedItem();

            // Crear una nueva ventana para ingresar el monto a convertir
            JFrame ventanaMonto = new JFrame("Ingresar monto a convertir");
            JPanel panelMonto = new JPanel();
            panelMonto.setLayout(new FlowLayout());

            JLabel labelMonto = new JLabel("Monto a convertir:");
            panelMonto.add(labelMonto);

            JTextField textFieldMonto = new JTextField(10);
            panelMonto.add(textFieldMonto);

            JButton convertirButton = new JButton("Convertir");
            panelMonto.add(convertirButton);




            ventanaMonto.add(panelMonto);
            ventanaMonto.setSize(300, 300);
            ventanaMonto.setLocationRelativeTo(null);
            ventanaMonto.setVisible(true);

            // Acción del botón "Convertir" de la ventana del monto
            convertirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtener el monto a convertir
                    double monto = Double.parseDouble(textFieldMonto.getText());

                    // Realizar la conversión y mostrar el resultado en la etiqueta JLabel
                    double resultado = conversorMoneda.convertir(monedaOrigen, monedaDestino, String.valueOf(monto));
                    DecimalFormat formato = new DecimalFormat("#.## " + monedaDestino);
                    // Cerrar la ventana del monto
                    ventanaMonto.dispose();
                }
            });
        }
    });
}


    private void configurarBotones() {
        okButton = new JButton("ok");
        exitButton = new JButton("exit");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para procesar la opción seleccionada en el JComboBox
                String opcionSeleccionada = (String) comboBoxOpciones.getSelectedItem();
                JOptionPane.showMessageDialog(null, opcionSeleccionada);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(okButton);
        panelBotones.add(exitButton);

        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ConversorAlura conversorAlura = new ConversorAlura();
        conversorAlura.setVisible(true);
    }
}
