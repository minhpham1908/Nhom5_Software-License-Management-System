package webserver.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webserver.web.model.MyUserDetails;
import yuhnim.client.Client;
import yuhnim.rmi.Licence;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.Principal;
import java.util.List;

@Controller
public class LicenceInfoController {
    @Autowired
    Client client;

    @GetMapping("/licenceInfo")
    public String licenceInfo(Authentication authentication,Principal principal, Model model) throws RemoteException, NotBoundException {
        MyUserDetails user = (MyUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        List<Licence> licences = client.getLicences(user.getUserId());
        model.addAttribute("licences", licences);
        model.addAttribute("numOfLicences", licences.size());
        System.out.println(model);
        return "LicenceInfo";
    }
}
