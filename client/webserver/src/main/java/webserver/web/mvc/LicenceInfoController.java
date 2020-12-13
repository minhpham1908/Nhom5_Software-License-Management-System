package webserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yuhnim.client.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Controller
public class LicenceInfoController {
    @Autowired
    Client client;
    @GetMapping("/licenceInfo")
    public  String licenceInfo(Model model) throws RemoteException, NotBoundException {
        model.addAttribute("Licence", client.getLicences());
        model.addAttribute("numOfLicences",10);
        System.out.println(model);
        return "LicenceInfo";
    }
}
