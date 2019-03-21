
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Italtel
 */
public class Mostrador {

    JFrame VentanaGeneral = new JFrame();

    public void mostrar() {
        JPanel PanelGeneral = new JPanel(new GridLayout(3, 0));

        JPanel Buscador = new JPanel(new GridLayout(0, 2));
        JLabel mensaje = new JLabel();
        mensaje.setText("Ingrese la cadena");
        JTextField cadena = new JTextField();
        Buscador.add(mensaje);
        Buscador.add(cadena);

        JTextArea texto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(texto, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        texto.setEditable(true);

        JPanel Botones = new JPanel(new GridLayout(0, 4));
        JButton button1 = new JButton("Buscar");
        button1.addActionListener((ActionEvent e) -> {
            editor.setText("");
            editor2.setText("");
            String CadenaAEvaluar = cadena.getText();
            String TextoAevaluar = texto.getText();
            if (CadenaAEvaluar.equals("") || CadenaAEvaluar.length() == 1 || TextoAevaluar.equals("") || TextoAevaluar.length() == 1) {
                JOptionPane.showMessageDialog(null, "La cadena no es válida");
            } else {
                AlgortimoBM ABM = new AlgortimoBM(CadenaAEvaluar, TextoAevaluar);
                ArrayList<Integer> posiciones = ABM.realizarBusqueda();
                System.out.println(posiciones);
                ProcesosSecundarios PS = new ProcesosSecundarios();
                mostrarResultado(PS.caracterizarTexto(TextoAevaluar, CadenaAEvaluar, posiciones));
                mostrarCantidadDePalabras(posiciones.size());
                cadena.setForeground(Color.red);
            }
        });

        JButton button2 = new JButton("Invertir texto");
        button2.addActionListener((ActionEvent e) -> {
            editor.setText("");
            String CadenaAEvaluar = cadena.getText();
            String TextoAevaluar = texto.getText();
            if (CadenaAEvaluar.equals("") || CadenaAEvaluar.length() == 1 || TextoAevaluar.equals("") || TextoAevaluar.length() == 1) {

                JOptionPane.showMessageDialog(null, "La cadena no es válida");
            } else {
                ProcesosSecundarios A = new ProcesosSecundarios();
                mostrarResultado(A.invertirTexto(TextoAevaluar));
            }
        });
        JButton button3 = new JButton("Invertir palabras");
        button3.addActionListener((ActionEvent e) -> {
            editor.setText("");
            String CadenaAEvaluar = cadena.getText();
            String TextoAevaluar = texto.getText();
            if (CadenaAEvaluar.equals("") || CadenaAEvaluar.length() == 1 || TextoAevaluar.equals("") || TextoAevaluar.length() == 1) {
                JOptionPane.showMessageDialog(null, "La cadena no es válida");
            } else {
                ProcesosSecundarios A = new ProcesosSecundarios();
                mostrarResultado(A.invertirCadaPalabraDeUnTexto(TextoAevaluar));
            }
        });

        JButton button4 = new JButton("\"Palindroma\"");
        button4.addActionListener((ActionEvent e) -> {
            editor.setText("");
            editor2.setText("");
            String CadenaAEvaluar = cadena.getText();
            String TextoAevaluar = texto.getText();
            if (CadenaAEvaluar.equals("") || CadenaAEvaluar.length() == 1 || TextoAevaluar.equals("") || TextoAevaluar.length() == 1) {
                JOptionPane.showMessageDialog(null, "La cadena no es válida");
            } else {
                ProcesosSecundarios PS = new ProcesosSecundarios();
                String TextoCambiado = PS.quitarCaracteresEspecialesDeUnTexto(TextoAevaluar);
                String PalabraCambiada = PS.invertirTexto(CadenaAEvaluar);
                AlgortimoBM ABM = new AlgortimoBM(PalabraCambiada, TextoCambiado);
                ArrayList<Integer> posiciones = ABM.realizarBusqueda();
                System.out.println(posiciones);
                mostrarResultado(PS.caracterizarTextoPalindromo(TextoAevaluar, CadenaAEvaluar, posiciones));
                mostrarCantidadDePalabras(posiciones.size());
                cadena.setForeground(Color.blue);
            }
        });

        Botones.add(button1);
        Botones.add(button2);
        Botones.add(button3);
        Botones.add(button4);

        PanelGeneral.add(Buscador, BorderLayout.NORTH);
        PanelGeneral.add(scrollPane, BorderLayout.CENTER);
        PanelGeneral.add(Botones, BorderLayout.SOUTH);
        VentanaGeneral.add(PanelGeneral);
        VentanaGeneral.setBounds(10, 10, 600, 159);
        VentanaGeneral.setBackground(Color.red);
        VentanaGeneral.setLocationRelativeTo(null);
        VentanaGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        VentanaGeneral.setVisible(true);
    }

    JFrame VentanaResultado = new JFrame();
    JEditorPane editor = new JEditorPane();

    JFrame VentanaNumeros = new JFrame();
    JEditorPane editor2 = new JEditorPane();

    public void mostrarResultado(String texto) {
        texto = "<b>" + texto + "</b>";
        editor.setContentType("text/html");
        editor.setText(texto);
        VentanaResultado.add(editor);
        VentanaResultado.setBounds(10, 10, 375, 159);
        VentanaResultado.setBackground(Color.red);
        VentanaResultado.setLocationRelativeTo(null);
        VentanaResultado.setVisible(true);

    }

    public void mostrarCantidadDePalabras(int num) {
        editor2.setText("La cantidad de palabras que aparece en el texto es de " + num);
        VentanaNumeros.add(editor2);
        VentanaNumeros.setBounds(10, 10, 375, 159);
        VentanaNumeros.setBackground(Color.red);
        VentanaNumeros.setLocationRelativeTo(null);
        VentanaNumeros.setVisible(true);
    }

}
