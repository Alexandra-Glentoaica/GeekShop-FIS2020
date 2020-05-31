package Models;

import java.util.Objects;

public class Book extends Product {
    private String autor;
    private String limba;
    private String editor;

    public Book(String name, int price, String type, String autor, String limba, String editor) {
        super(name, price, type);
        this.autor = autor;
        this.limba = limba;
        this.editor = editor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLimba() {
        return limba;
    }

    public void setLimba(String limba) {
        this.limba = limba;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;

        if(!autor.equals(((Book) o).autor)) return false;
        if(!limba.equals(((Book) o).limba)) return false;
        return editor.equals(((Book) o).editor);
    }

    @Override
    public int hashCode() {
        int result = 31*autor.hashCode();
        result = 31*result + limba.hashCode();
        result = 31*result + editor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", limba='" + limba + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}
