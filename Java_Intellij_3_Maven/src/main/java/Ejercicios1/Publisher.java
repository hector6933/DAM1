package Ejercicios1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Publisher {

    private String name;
    private String address;
    ArrayList<Book> libros;

    public Publisher() {

        libros = new ArrayList<>();

    }

    public Publisher(String name, String address) {

        this.name = name;
        this.address = address;
        libros = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Book> libros) {
        this.libros = libros;
    }
}
