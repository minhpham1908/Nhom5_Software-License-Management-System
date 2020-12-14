package yuhnim.rmi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Licence implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer licenceID;
    private String title;
    private Date validThough;
    private ArrayList<Product> products;

    public Licence() {
    }

    public Licence(Integer licenceID, Date validThough, ArrayList<Product> products) {
        this.licenceID = licenceID;
        this.validThough = validThough;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLicenceID() {
        return this.licenceID;
    }

    public void setLicenceID(Integer licenceID) {
        this.licenceID = licenceID;
    }

    public Date getValidThough() {
        return this.validThough;
    }

    public void setValidThough(Date validThough) {
        this.validThough = validThough;
    }

    public ArrayList<Product> getProductName() {
        return this.products;
    }

    public void setProductName(ArrayList<Product> products) {
        this.products = products;
    }

    public Licence licenceID(Integer licenceID) {
        this.licenceID = licenceID;
        return this;
    }

    public Licence validThough(Date validThough) {
        this.validThough = validThough;
        return this;
    }

    //Add More

    public void setTitleAndlicenceID(String title, Integer licenceID){
        // Gan gia tri Title
        // Title co gia tri mac dinh la string
        this.title = title;

        // Gan gia tri licenceID
        // licenceID co gia tri mac dinh la integer
        this.licenceID = licenceID;
    }

    public void setValidThoughAndProductName(Date validThough, ArrayList<Product> products){
        // Gan gia tri cho validThogh
        // validThough co kieu du lieu mac dinh la Date
        this.validThough = validThough;

        // Gan gia tri cho products
        // products co gia tri mac dinh la mot mang bao gom list cac product
        this.products = products;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Licence)) {
            return false;
        }
        Licence licenceData = (Licence) o;
        return Objects.equals(licenceID, licenceData.licenceID) && Objects.equals(validThough, licenceData.validThough) && Objects.equals(products, licenceData.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceID, validThough, products);
    }

    @Override
    public String toString() {
        return "Licence{" +
                "licenceID='" + licenceID + '\'' +
                ", title='" + title + '\'' +
                ", validThough=" + validThough +
                ", products=" + products +
                '}';
    }
}