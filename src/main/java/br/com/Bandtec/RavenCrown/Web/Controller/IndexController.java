package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {

    public final static String INDEX_URL = "index.html";

    @GetMapping("/index")
    public String IndexController(@ModelAttribute UsuarioModel model){
        return INDEX_URL;
    }

    public String LoginController(Model model){
        return INDEX_URL;
    }

}
