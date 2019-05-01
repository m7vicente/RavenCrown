package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicoController {

    @Autowired
    private ServicoBussines servicoBussines;

}
