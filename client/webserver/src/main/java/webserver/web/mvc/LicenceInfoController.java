package webserver.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yuhnim.client.Client;
import yuhnim.rmi.Licence;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

@Controller
public class LicenceInfoController {
    @Autowired
    Client client;
    @GetMapping("/licenceInfo")
    public  String licenceInfo(Model model) throws RemoteException, NotBoundException {
        List<Licence> licences = client.getLicences();
        model.addAttribute("licences", client.getLicences());
        model.addAttribute("numOfLicences",licences.size());
        System.out.println(model);
        return "LicenceInfo";
    }
}
