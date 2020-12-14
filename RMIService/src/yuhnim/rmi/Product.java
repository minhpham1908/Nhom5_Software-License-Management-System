package yuhnim.rmi;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ID;
    private String name;

    public Product(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Product() {

    }

    public Product(Integer ID){
        this.ID = ID;
    }

    public Product(String name){
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIDAndName(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return ID.equals(product.ID) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}