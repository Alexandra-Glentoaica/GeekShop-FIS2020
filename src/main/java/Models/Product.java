package Models;

import java.util.Objects;

public abstract class Product {
    private String name;
    private int price;
    private String type;

    public Product(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        if (!name.equals(((Product) o).name)) return false;
        if (!type.equals(((Product) o).type)) return false;
        return price == ((Product) o).price;
    }

    @Override
    public int hashCode() {
        int result = 31*name.hashCode();
        result = 31*result + price;
        result = 31*result + type.hashCode();
        return result;
    }
}
