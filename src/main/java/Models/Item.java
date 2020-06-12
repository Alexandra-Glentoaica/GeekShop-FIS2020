package Models;

public class Item extends Product {
    private String material;
    private String color;
    private String size;

    public Item(String name, int price, String type, int quantity, String material, String color, String size) {
        super(name, price, type, quantity);
        this.material = material;
        this.color = color;
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;

        if(!material.equals(((Item) o).material)) return false;
        if(!color.equals(((Item) o).color)) return false;
        return size.equals(((Item) o).size);
    }

    @Override
    public int hashCode() {
        int result = 31*material.hashCode();
        result = 31*result + color.hashCode();
        result = 31*result + size.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
