import java.util.ArrayList;
import java.util.Date;

/**
 * LicenceServiceImp
 */
public class LicenceServiceImp implements LicenceService {

    public LicenceServiceImp() {
    }
    
    @Override
    public LicenceData getLicence(User user) {
        Date now =  new Date();
        ArrayList<String> products = new ArrayList<String>();
        products.add("some product");
        LicenceData licenceData = new LicenceData("1234AD",now , products);
        return licenceData;
    }
    
    
}