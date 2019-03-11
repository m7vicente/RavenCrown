package br.com.Bandtec.RavenCrown.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    public final static String INDEX_URL = "index.html";

    @GetMapping("/index")
    public String IndexController(Model model){
        model.addAttribute("title", "CarnaVral");
        return INDEX_URL;
    }

    public String LoginController(Model model){
        //model
        return INDEX_URL;
    }

}
