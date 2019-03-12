
import java.util.ArrayList;

public class AlgortimoBM {

    public String texto;
    public String cadena;
    public ArrayList<Integer> posiciones;

    public AlgortimoBM(String cad, String tex) {
        this.cadena = cad;
        this.texto = tex;
        this.posiciones = new ArrayList<>();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public ArrayList<Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Integer> posiciones) {
        this.posiciones = posiciones;
    }

    public class Item {

        public char Caracter;
        public int Posicion;

        public Item(char carac, int pos) {
            this.Caracter = carac;
            this.Posicion = pos;
        }
    }

    public ArrayList<Integer> realizarBusqueda() {
        int CadenaRecorrido = getCadena().length() - 1;
        int TextoRecorrido = getCadena().length() - 1;
        System.out.println("El recorrido empieza con " + getCadena().length());
        ArrayList<Item> ListaD1 = obtenerListaD1();

        while (TextoRecorrido < getTexto().length()) {
            System.out.println("Comparación máxima: " + getCadena().charAt(CadenaRecorrido) + " en " + CadenaRecorrido + ", " + getTexto().charAt(TextoRecorrido) + " en " + TextoRecorrido);
            if (getCadena().charAt(CadenaRecorrido) == getTexto().charAt(TextoRecorrido)) {
                System.out.println("El caracter es igual en " + CadenaRecorrido + " y " + TextoRecorrido);
                //Recorre la cadena en busca de un carácter diferente
                for (int j = 0; j < getCadena().length() - 1; j++) {
                    CadenaRecorrido--;
                    TextoRecorrido--;
                    System.out.println("Se comparan: " + getCadena().charAt(CadenaRecorrido) + " con " + getTexto().charAt(TextoRecorrido));
                    if (getCadena().charAt(CadenaRecorrido) != getTexto().charAt(TextoRecorrido)) {
                        Boolean visto = false;
                        for (int k = 1; k < ListaD1.size(); k++) {
                            if (ListaD1.get(k).Caracter == getTexto().charAt(TextoRecorrido)) {
                                visto = true;
                                TextoRecorrido = TextoRecorrido + ListaD1.get(k).Posicion;
                                System.out.println(TextoRecorrido);
                                break;
                            }
                        }
                        if (!visto) {
                            TextoRecorrido = TextoRecorrido + ListaD1.get(ListaD1.size() - 1).Posicion;
                        }
                        CadenaRecorrido = getCadena().length() - 1;
                        break;
                    } else if (j == getCadena().length() - 2) {
                        System.out.println("Se encontró en " + TextoRecorrido);
                        posiciones.add(TextoRecorrido);
                        TextoRecorrido = TextoRecorrido + (getCadena().length() - 1) + getCadena().length();
                        CadenaRecorrido = getCadena().length() - 1;
                        System.out.println("Texto recorrido: " + TextoRecorrido);
                        System.out.println("Cadena recorrido: " + CadenaRecorrido);

                    }

                }
            } else {
                Boolean visto = false;
                for (int j = 1; j < ListaD1.size(); j++) {
                    System.out.println(ListaD1.get(j).Caracter + ", " + getTexto().charAt(TextoRecorrido));
                    if (ListaD1.get(j).Caracter == getTexto().charAt(TextoRecorrido)) {
                        visto = true;
                        TextoRecorrido = TextoRecorrido + ListaD1.get(j).Posicion;
                        break;
                    }
                }
                if (!visto) {
                    TextoRecorrido = TextoRecorrido + ListaD1.get(ListaD1.size() - 1).Posicion;
                }
            }
        }
        return posiciones;
    }

    public ArrayList<Item> obtenerListaD1() {
        ArrayList<Item> Caracteres = new ArrayList<>();
        Caracteres.add(new Item(getCadena().charAt(getCadena().length() - 1), 0));
        boolean visto;
        for (int i = (getCadena().length() - 1); i >= 0; i--) {
            visto = false;
            for (int j = 0; j < Caracteres.size(); j++) {
                if (Caracteres.get(j).Caracter == getCadena().charAt(i)) {
                    visto = true;
                    break;
                }
            }
            if (!visto) {
                Caracteres.add(new Item(getCadena().charAt(i), (getCadena().length() - i - 1)));
            }
        }
        Caracteres.add(new Item('-', getCadena().length()));
        imprimirListaD1(Caracteres);
        return Caracteres;
    }

    public void imprimirListaD1(ArrayList<Item> Caracteres) {
        for (int i = 0; i < Caracteres.size(); i++) {
            System.out.println(Caracteres.get(i).Caracter + ", " + Caracteres.get(i).Posicion);
        }
    }
}
