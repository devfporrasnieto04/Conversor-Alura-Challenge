package persistencia;

import logica.ConversorMoneda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MenuPanel1 extends JFrame {

    private final String[] opciones = {"Conversor de moneda", "Conversor de temperatura", "Conversor de unidades"};
    private JComboBox<String> comboBoxOpciones;
    private JPanel panelMenu;
    private JLabel textField1;
    private JSeparator separator1;
    private CurrencyPanel currencyPanel;
    private ConversorMoneda conversorMoneda;
    private TemperaturePanel temperaturePanel;
    private MasaPanel masaPanel;

    public MenuPanel1() {

        configurarVentana();
        agregarPanelMenu();
        mostrarPanelMenu();
        configComboboxOpciones();
    }

    private void configurarVentana() {

        setTitle("Conversor Alura Challenge");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
    }

    private void agregarPanelMenu() {
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.add(Box.createVerticalStrut(10));
        textField1.setText("Seleccione una opción");
        textField1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        panelMenu.add(textField1);
        panelMenu.add(Box.createVerticalStrut(10));
        separator1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMenu.add(separator1);
        comboBoxOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(comboBoxOpciones);
        panelMenu.add(Box.createVerticalGlue());
        getContentPane().add(panelMenu, BorderLayout.NORTH);
    }

    private void mostrarPanelMenu() {
        getContentPane().removeAll();
        getContentPane().add(panelMenu, BorderLayout.NORTH);
        revalidate();
        repaint();
    }

    private void configComboboxOpciones() {
        comboBoxOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = Objects.requireNonNull(comboBoxOpciones.getSelectedItem()).toString();
                switch (opcionSeleccionada) {
                    case "Conversor de moneda" -> {
                        currencyPanel = new CurrencyPanel();
                        panelMenu.setVisible(false);
                        currencyPanel.setVisible(true);
                        dispose();
                    }
                    case "Conversor de temperatura" -> {
                        //Lógica para el conversor de temperatura
                        temperaturePanel = new TemperaturePanel();
                        panelMenu.setVisible(false);
                        temperaturePanel.setVisible(true);
                        dispose();
                    }
                    case "Conversor de unidades de masa" -> {
                        //Lógica para el conversor de unidades
                        masaPanel = new MasaPanel();
                        panelMenu.setVisible(false);
                        masaPanel.setVisible(true);
                        dispose();
                    }
                }
            }
        });
    }



}

