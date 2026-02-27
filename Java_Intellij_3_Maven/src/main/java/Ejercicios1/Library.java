package Ejercicios1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Library {

    ArrayList<Book> libreria;

    public Library() {

        libreria = new ArrayList<>();

    }

    public Library(ArrayList<Book> libreria) {
        this.libreria = libreria;
    }

    public ArrayList<Book> getLibreria() {
        return libreria;
    }

    public void setLibreria(ArrayList<Book> libreria) {
        this.libreria = libreria;
    }


}
