package Ejercicios1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Author {

    private String name;

    private ArrayList<Book> booksWritten;

    public Author() {

        booksWritten = new ArrayList<>();

    }

    public Author(String name) {
        this.name = name;
        booksWritten = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(ArrayList<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
