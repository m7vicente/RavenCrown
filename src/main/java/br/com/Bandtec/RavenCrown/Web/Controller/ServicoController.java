package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServicoController {

    @Autowired
    private ServicoBussiness servicoBussines;

    @GetMapping("/Servico")
    public ServicoModel getServico(@RequestParam("id") int id){
        return new ServicoModel(servicoBussines.getById(id));
    }

    @PostMapping("/Servico")
    public ServicoModel insertServico(@RequestBody ServicoModel model){
        return servicoBussines.insertService(model);
    }

}
