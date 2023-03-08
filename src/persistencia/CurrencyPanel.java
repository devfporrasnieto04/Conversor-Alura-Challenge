package persistencia;

import logica.ConversorMoneda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CurrencyPanel extends JFrame implements conversorSetings{
    private MenuPanel1 menuPanel1;
    private JPanel currencyPanel;
    private JSeparator separator1;
    private JLabel textMonto;
    private JFormattedTextField monto;
    private JLabel textMonedaOrigen;
    private JComboBox <String> monedaOrigen;
    private JLabel textMonedaDestino;
    private JComboBox <String> monedaDestino;
    private JButton Convert;
    private JLabel resultLabel;
    private JSeparator separator2;
    private JButton menuButton;
    private JButton salirBtn;

//private static ConversorMoneda conversorMoneda;



    public CurrencyPanel() {
       configurarVentana();
        agregarPanel();
        mostrarPanel();
        configBtns();
        configMonto();
        //this.conversorMoneda = conversorMoneda;
    }

    private void configMonto (){
        monto.addKeyListener(new KeyAdapter() {
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

    public static void main(String[] args) {
        CurrencyPanel currencyPanel = new CurrencyPanel();
        currencyPanel.setVisible(true);
    }


  @Override
    public void configurarVentana() {
        setTitle("Currency Converter");
        setSize(400,328);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }



    @Override
    public void agregarPanel() {
       // getContentPane().add(currencyPanel, BorderLayout.NORTH);
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
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPanel1 menuPanel11 = new MenuPanel1();
                menuPanel11.setVisible(true);
                currencyPanel.setVisible(false);
                dispose();
            }
        });
    }


}


