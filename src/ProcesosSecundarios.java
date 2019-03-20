
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Italtel
 */
public class ProcesosSecundarios {

    public String caracterizarTexto(String texto, String cadena, ArrayList<Integer> capturas) {
        String resultado = texto;
        for (int i = 0; i < capturas.size(); i++) {
            int indice = i * 25;
            resultado = resultado.substring(0, (capturas.get(i) + indice)) + "<font color=\"red\">" + resultado.substring((capturas.get(i) + indice), (capturas.get(i) + indice + cadena.length())) + "</font>" + resultado.substring((capturas.get(i) + indice + cadena.length()));
        }
        return resultado;
    }

    public String invertirTexto(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado = resultado + texto.charAt(i);
        }
        return resultado;
    }

    public String invertirCadaPalabraDeUnTexto(String texto) {
        String palabras[] = texto.split(" ");

        String resultados[] = new String[palabras.length];
        for (int i = 0; i < resultados.length; i++) {
            resultados[i] = "";
        }
        for (int i = 0; i < palabras.length; i++) {
            for (int j = palabras[i].length() - 1; j >= 0; j--) {
                resultados[i] = resultados[i] + palabras[i].charAt(j);
            }
        }
        String resultado = "";
        for (String resultado1 : resultados) {
            resultado = resultado + resultado1 + " ";
        }
        return resultado;
    }
}
