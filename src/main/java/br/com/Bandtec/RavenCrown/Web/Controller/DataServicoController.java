package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.DataServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.DataServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataServicoController {

    @Autowired
    DataServicoBussiness dataServicoBussiness;

    @PostMapping
    public ResponseEntity<String> validarData(@RequestParam("Datas") DataServicoModel data){

        try{
            boolean disponivel = dataServicoBussiness.ValidateDate(data);
            if(disponivel){
                return new ResponseEntity<>("Data de serviço Disponivel",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Data de serviço Indisponivel",HttpStatus.OK);
            }

        }catch (Exception ex){
            return new ResponseEntity<>(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
