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