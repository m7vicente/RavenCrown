package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.EnderecoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.EnderecoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoBussiness bussiness;

    private ModelMapper mapper;

    public EnderecoController(){
        this.mapper = new ModelMapper();
    }

    @PutMapping("/endereco/")
    public ResponseEntity<Boolean> AtualizarEndereco(@RequestBody EnderecoModel enderecoModel){
        EnderecoEntity enderecoEntity = mapper.map(enderecoModel,EnderecoEntity.class);
        enderecoEntity.setUsuario(bussiness.GetEndereco(enderecoModel.getId_Endereco()).getUsuario());
        Boolean sucess = bussiness.UpdateEndereco(enderecoEntity);
        return ResponseEntity.ok(sucess);
    }


    @GetMapping("/endereco")
    public ResponseEntity<EnderecoModel> ObterEndereco(@RequestParam("id") int id){
        try{
            EnderecoModel enderecoModel = mapper.map(bussiness.GetEndereco(id),EnderecoModel.class);
            return ResponseEntity.ok(enderecoModel);

        }catch(Exception ex){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
