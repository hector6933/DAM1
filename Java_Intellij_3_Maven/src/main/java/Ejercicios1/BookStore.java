package Ejercicios1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class BookStore {

    private ArrayList<Book> libros;
    private ArrayList<Author> autores;

    public BookStore(){

        libros = new ArrayList<>();
        autores = new ArrayList<>();

    }

    public ArrayList<Book> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Book> libros) {
        this.libros = libros;
    }

    public ArrayList<Author> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Author> autores) {
        this.autores = autores;
    }
}
