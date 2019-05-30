package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemServicoBussines;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ServicoController {

    @Autowired
    private ServicoBussiness servicoBussines;
    @Autowired
    private ImagemServicoBussines imagemBussines;
    @Autowired
    private UsuarioBusiness userBussines;

    @Autowired
    private TodosCategoriasDAL categoriasDAL;

    private ModelMapper modelMapper;

    public ServicoController(){
        modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ServicoModel, ServicoEntity>() {
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
        ServicoModel model = modelMapper.map(servicoBussines.getById(id),ServicoModel.class);
        model.setImagem(imagemBussines.getServiceImages(model.getIdServico()));
        return ResponseEntity.ok(model);
    }

    @GetMapping("/Servicos/Categoria")
    public ResponseEntity<List<ServicoModel>> getServicoByCategory(@RequestParam("categoria") int id){
        try {
            List<ServicoModel> services = new ArrayList<>();
            servicoBussines.GetByCategory(id).forEach(x -> {
                ServicoModel servico = modelMapper.map(x, ServicoModel.class);
                servico.setIdUsuario(x.getPrestador().getId_Usuario());
                try {
                    servico.setImagem(imagemBussines.getServiceImages(x.getId_Servico()));
                }catch (Exception ex){
                    System.out.println("Error: "+ex.toString());
                    servico.setImagem(null);
                }
                services.add(servico);
            });
            return ResponseEntity.ok(services);
        }catch (Exception x){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Servico")
    public ResponseEntity<ServicoModel> insertServico(@RequestBody ServicoModel model){


        ServicoEntity servicoEntity = modelMapper.map(model, ServicoEntity.class);

        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));

        servicoEntity = servicoBussines.insertService(servicoEntity);

        if(!model.getImagem().isEmpty()){
            for(ImagemServicoModel x : model.getImagem()){
                imagemBussines.SaveImage(x,servicoEntity);
            };
        }

        model = modelMapper.map(servicoEntity, ServicoModel.class);
        model.setIdUsuario(servicoEntity.Prestador.getId_Usuario());
        return ResponseEntity.ok(model);
    }

    @PutMapping("/Servico")
    public ResponseEntity<ServicoModel> updateServico(@RequestBody ServicoModel model){
        ServicoEntity servicoEntity = modelMapper.map(model, ServicoEntity.class);
        servicoEntity.setPrestador(userBussines.getUser(model.getIdUsuario()));
        servicoEntity.setCategoria(categoriasDAL.getOne(model.getIdCategoria()));
        servicoBussines.UpdateService(servicoEntity);
        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/Servico")
    public ResponseEntity<String> deleteServico(@RequestBody ServicoModel model){
        servicoBussines.DeleteService(modelMapper.map(model,ServicoEntity.class));
        return ResponseEntity.ok("Apagado com sucesso");
    }
}
