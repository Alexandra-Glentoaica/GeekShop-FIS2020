package Models;

public class Book extends Product {
    private String author;
    private String language;
    private String publisher;

    public Book(String name, int price, String type, String author, String language, String publisher) {
        super(name, price, type);
        this.author = author;
        this.language = language;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;

        if(!author.equals(((Book) o).author)) return false;
        if(!language.equals(((Book) o).language)) return false;
        return publisher.equals(((Book) o).publisher);
    }

    @Override
    public int hashCode() {
        int result = 31* author.hashCode();
        result = 31*result + language.hashCode();
        result = 31*result + publisher.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
