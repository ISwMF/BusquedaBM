
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

    public class ItemPalindromo {

        public char caracter;
        public int posicionTexto;
        public int posicionPalindromo;

        public ItemPalindromo(char caracter, int posicionTexto, int posicionPalindromo) {
            this.caracter = caracter;
            this.posicionTexto = posicionTexto;
            this.posicionPalindromo = posicionPalindromo;
        }
    }

    public String caracterizarTextoPalindromo(String texto, String cadena, ArrayList<Integer> capturas) {
        String resultado = texto;
        ArrayList<ItemPalindromo> Items = obtenerListaItems(texto);
        for (int i = 0; i < Items.size(); i++) {
            System.out.println("----");
            System.out.println(Items.get(i).caracter);
            System.out.println(Items.get(i).posicionPalindromo);
            System.out.println(Items.get(i).posicionTexto);
        }
        for (int i = 0; i < capturas.size(); i++) {
            int indice = i * 25;
            if ((capturas.get(i) + cadena.length()) >= Items.size()) {
                System.out.println(resultado.substring(12, 18));
                System.out.println(resultado);
                System.out.println("aaaa " + resultado.charAt(Items.get(Items.size() - 1).posicionTexto));
                resultado = resultado.substring(0, (Items.get(capturas.get(i)).posicionTexto + indice)) + "<font color=\"red\">" + resultado.substring((Items.get(capturas.get(i)).posicionTexto + indice), (Items.get(Items.size() - 1).posicionTexto + indice) + 1) + "</font>" + resultado.substring(Items.get(Items.size() - 1).posicionTexto + indice + 1);
            } else {
                resultado = resultado.substring(0, (Items.get(capturas.get(i)).posicionTexto + indice)) + "<font color=\"red\">" + resultado.substring((Items.get(capturas.get(i)).posicionTexto + indice), (Items.get(capturas.get(i) + cadena.length()).posicionTexto + indice)) + "</font>" + resultado.substring((Items.get(capturas.get(i) + cadena.length()).posicionTexto + indice));
            }
        }
        System.out.println(resultado);
        return resultado;
    }

    public String quitarCaracteresEspecialesDeUnTexto(String texto) {
        texto = texto.replace(" ", "");
        texto = texto.replace(",", "");
        texto = texto.replace("?", "");
        texto = texto.replace("¿", "");
        texto = texto.replace("!", "");
        texto = texto.replace("¡", "");
        texto = texto.replace("\"", "");
        texto = texto.replace("(", "");
        texto = texto.replace(")", "");
        texto = texto.replace("´", "");
        texto = texto.replace("'", "");
        texto = texto.replace(".", "");
        return texto;
    }

    public ArrayList<ItemPalindromo> obtenerListaItems(String texto) {
        String textoLimpio = "";
        ArrayList<ItemPalindromo> Items = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ' || texto.charAt(i) == ',' || texto.charAt(i) == '?' || texto.charAt(i) == '¿' || texto.charAt(i) == '!' || texto.charAt(i) == '¡' || texto.charAt(i) == '\"' || texto.charAt(i) == '(' || texto.charAt(i) == ')' || texto.charAt(i) == '´' || texto.charAt(i) == '\'' || texto.charAt(i) == '.') {

            } else {
                Items.add(new ItemPalindromo(texto.charAt(i), i, textoLimpio.length()));
                textoLimpio = textoLimpio + texto.charAt(i);

            }
        }
        return Items;
    }

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
