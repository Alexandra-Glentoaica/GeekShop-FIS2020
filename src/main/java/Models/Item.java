package Models;

import java.util.Objects;

public class Item extends Product {
    private String material;
    private String culoare;
    private String dimensiune;

    public Item(String name, int price, String material, String culoare, String dimensiune) {
        super(name, price);
        this.material = material;
        this.culoare = culoare;
        this.dimensiune = dimensiune;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;

        if(!material.equals(((Item) o).material)) return false;
        if(!culoare.equals(((Item) o).culoare)) return false;
        return dimensiune.equals(((Item) o).dimensiune);
    }

    @Override
    public int hashCode() {
        int result = 31*material.hashCode();
        result = 31*result + culoare.hashCode();
        result = 31*result + dimensiune.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "material='" + material + '\'' +
                ", culoare='" + culoare + '\'' +
                ", dimensiune='" + dimensiune + '\'' +
                '}';
    }
}
