package webserver.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LicenceInfoController {
    @GetMapping("/licenceInfo")
    public  String licenceInfo(Model model){
        model.addAttribute("numOfLicences",10);
        System.out.println(model);
        return "LicenceInfo";
    }
}
