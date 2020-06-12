package Models;

import java.util.Objects;

public abstract class Product {
    private String name;
    private int price;
    private String type;
    private int quantity;

    public Product(String name, int price, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\''
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        if (!name.equals(((Product) o).name)) return false;
        if (!type.equals(((Product) o).type)) return false;
        if (quantity!=((Product)o).quantity) return false;
        return price == ((Product) o).price;
    }

    @Override
    public int hashCode() {
        int result = 31*name.hashCode();
        result = 31*result + price;
        result = 31*result + type.hashCode();
        result = 31*result + quantity;
        return result;
    }
}
