package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemServicoBussines;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
public class ServicoController {

    @Autowired
    private ServicoBussiness servicoBussines;
    @Autowired
    private ImagemServicoBussines imagemBussines;
    @Autowired
    private UsuarioBusiness userBussines;
    @Autowired
    TodosCategoriasDAL categoriasDAL;

    private ModelMapper mapper;

    public ServicoController(){
        mapper = new ModelMapper();

        mapper.addMappings(new PropertyMap<ServicoModel, ServicoEntity>() {
            @Override
            protected void configure() {
                //map().setPrestador(userBussines.getUser(source.getIdUsuario()));
                //map().setCategoria(categoriasDAL.getOne(source.getIdCategoria()));
                map().setNome_Servico(source.getNomeServico());
                map().setPreco_Servico(source.getPrecoServico());
                map().setLocalizacao_Fixa(source.isLocalizacaoFixa());
                map().setDescricao_Servico(source.getDescricaoServico());
                map().setTempo_Execucao(source.getTempoExecucao());
            }
        });
    }

    @GetMapping("/Servico")
    public ResponseEntity<ServicoModel> getServico(@RequestParam("id") int id){
        ModelMapper mapper = new ModelMapper();

        ServicoModel model = mapper.map(servicoBussines.getById(id),ServicoModel.class);
        model.setImagem(imagemBussines.getServiceImages(model.getIdServico()));
        return ResponseEntity.ok(model);
    }

    @PostMapping("/Servico")
    public ResponseEntity<ServicoModel> insertServico(@RequestBody ServicoModel model){


        ServicoEntity servicoEntity = mapper.map(model, ServicoEntity.class);

        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));

        servicoEntity = servicoBussines.insertService(servicoEntity);
        model = mapper.map(servicoEntity, ServicoModel.class);
        model.setIdUsuario(servicoEntity.Prestador.getId_Usuario());
        return ResponseEntity.ok(model);
    }

    @PutMapping("/Servico")
    public ResponseEntity<ServicoModel> updateServico(@RequestBody ServicoModel model){
        ServicoEntity servicoEntity = mapper.map(model, ServicoEntity.class);
        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));
        servicoBussines.UpdateService(servicoEntity);
        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/Servico")
    public ResponseEntity<String> deleteServico(@RequestBody ServicoModel model){
        servicoBussines.DeleteService(mapper.map(model,ServicoEntity.class));
        return ResponseEntity.ok("Apagado com sucesso");
    }
}
