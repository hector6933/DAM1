package Ejercicios1;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.TreeMap;

@XmlRootElement
public class LibraryCatalog {

    private HashMap<Book, Author> mapa;

    public LibraryCatalog(){

        mapa = new HashMap<>();

    }

    public HashMap<Book, Author> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<Book, Author> mapa) {
        this.mapa = mapa;
    }
}
