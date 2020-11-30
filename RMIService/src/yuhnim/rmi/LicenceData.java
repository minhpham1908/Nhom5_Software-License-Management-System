package yuhnim.rmi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LicenceData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String licenceID;
    private Date validThough;
    private ArrayList<String> productName;

    public LicenceData() {
    }

    public LicenceData(String licenceID, Date validThough, ArrayList<String> productName) {
        this.licenceID = licenceID;
        this.validThough = validThough;
        this.productName = productName;
    }

    public String getLicenceID() {
        return this.licenceID;
    }

    public void setLicenceID(String licenceID) {
        this.licenceID = licenceID;
    }

    public Date getValidThough() {
        return this.validThough;
    }

    public void setValidThough(Date validThough) {
        this.validThough = validThough;
    }

    public ArrayList<String> getProductName() {
        return this.productName;
    }

    public void setProductName(ArrayList<String> productName) {
        this.productName = productName;
    }

    public LicenceData licenceID(String licenceID) {
        this.licenceID = licenceID;
        return this;
    }

    public LicenceData validThough(Date validThough) {
        this.validThough = validThough;
        return this;
    }

    public LicenceData productName(ArrayList<String> productName) {
        this.productName = productName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LicenceData)) {
            return false;
        }
        LicenceData licenceData = (LicenceData) o;
        return Objects.equals(licenceID, licenceData.licenceID) && Objects.equals(validThough, licenceData.validThough) && Objects.equals(productName, licenceData.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceID, validThough, productName);
    }

    @Override
    public String toString() {
        return "{" +
            " licenceID='" + getLicenceID() + "'" +
            ", validThough='" + getValidThough() + "'" +
            ", productName='" + getProductName() + "'" +
            "}";
    }
    
    
    
}