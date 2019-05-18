package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemServicoBussines;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServicoController {

    @Autowired
    private ServicoBussiness servicoBussines;
    @Autowired
    private ImagemServicoBussines imagemBussines;

    @GetMapping("/Servico")
    public ServicoModel getServico(@RequestParam("id") int id){
        ModelMapper mapper = new ModelMapper();

        ServicoModel model = mapper.map(servicoBussines.getById(id),ServicoModel.class);
        model.setImagem(imagemBussines.getServiceImages(model.getId_Servico()));

        return model;
    }

    @PostMapping("/Servico")
    public ServicoModel insertServico(@RequestBody ServicoModel model){
        ModelMapper mapper = new ModelMapper();
        return mapper.map((servicoBussines.insertService(mapper.map(model, ServicoEntity.class))), ServicoModel.class);
    }

    @PutMapping("/Servico")
    public ServicoModel updateServico(@RequestBody ServicoModel model){
        servicoBussines.UpdateService(new ModelMapper().map(model, ServicoEntity.class));
        return model;
    }

    @DeleteMapping("/Servico")
    public ResponseEntity<String> deleteServico(@RequestBody ServicoModel model){
        servicoBussines.DeleteService(new ModelMapper().map(model,ServicoEntity.class));
        return ResponseEntity.ok("Apagado com sucesso");
    }
}
