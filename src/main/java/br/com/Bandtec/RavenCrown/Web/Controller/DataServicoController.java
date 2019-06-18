package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Infra.Business.DataServicoBussiness;
import br.com.Bandtec.RavenCrown.Web.Model.DataServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DataServicoController {

    @Autowired
    DataServicoBussiness dataServicoBussiness;

    @CrossOrigin
    @PostMapping("/Datas/Validar")
    public ResponseEntity<String> validarData(@RequestBody DataServicoModel data){

        try{
            boolean disponivel = dataServicoBussiness.ValidateDate(data);
            if(disponivel){
                return new ResponseEntity<>("Disponivel",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Indisponivel",HttpStatus.OK);
            }

        }catch (Exception ex){
            return new ResponseEntity<>(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
