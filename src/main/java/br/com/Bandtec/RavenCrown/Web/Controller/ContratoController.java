package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ContratoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.ContratoModel;
import br.com.Bandtec.RavenCrown.Web.Model.DataServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.EnderecoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContratoController {

    @Autowired
    private ContratoBussiness contratoBussiness;

    @Autowired
    private ServicoBussiness servicoBussiness;

    @Autowired
    private UsuarioBusiness usuarioBusiness;


    @PostMapping("/Servico/Agendar")
    public ResponseEntity<ContratoModel>CreateServiceContract(@RequestBody ContratoModel contrato) {
        try {
            ContratoEntity contract = new ContratoEntity();

            contract.setServico(servicoBussiness.getById(contrato.getIdServico()));
            contract.setPrestador(contract.getServico().getPrestador());
            contract.setConsumidor(usuarioBusiness.getUser(contrato.getIdConsumidor()));
            contract.setAprovado_Prestador(false);
            contract.setAprovado_Consumidor(false);

            List<DataServicoEntity> datas = new ArrayList<>();
            for (DataServicoModel x : contrato.getDatas()) {
                DataServicoEntity data = new DataServicoEntity();
                data.setPrestador(contract.getPrestador());
                data.setConsumidor(contract.getConsumidor());
                data.setDt_Agendamento(x.getDtAgendamento());
                data.setTipo_Reserva(x.getTipoReserva());
                data.setDemanda(null);
                data.setServico(contract.getServico());
                datas.add(data);
            }

            contract.setDatas(datas);
            contract.setValor_Final(contrato.getValor_Final());
            contract.setEndereco(contrato.getEndereco() != null ? new ModelMapper().map(contrato.getEndereco(), EnderecoEntity.class) : null);

            contract = contratoBussiness.CreateContract(contract);

            contrato.setAprovado_Consumidor(contract.isAprovado_Consumidor());
            contrato.setAprovado_Prestador(contract.isAprovado_Prestador());
            contrato.setEndereco(contrato.getEndereco() != null ? new ModelMapper().map(contract.getEndereco(), EnderecoModel.class) : null);
            contrato.setIdContrato(contract.getId_Contrato());
            return ResponseEntity.ok(contrato);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @PutMapping("/Servico/Consumidor/Aprovar")
        public ResponseEntity<String> AprovarAgendamentoConsumidor(@RequestParam("id") int idContrato, @RequestParam("aprovacao") boolean aprovacao){
            try {
                boolean sucesso = contratoBussiness.AprovarConsumidor(idContrato,aprovacao);
                String messagem = "Aprovação relizada com" + (sucesso ? "Sucesso" : "Falha, Datas não mais disponiveis");
                return ResponseEntity.ok(messagem);

            }catch (Exception ex){
                return new ResponseEntity("Erro ao aprovar :"+ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        @PutMapping("/Servico/Prestador/Aprovar")
        public ResponseEntity<String> AprovarAgendamentoPrestador(@RequestParam("id") int idContrato, @RequestParam("aprovacao") boolean aprovacao) {
            try {
                boolean sucesso = contratoBussiness.AprovarPrestador(idContrato, aprovacao);
                String messagem = "Aprovação relizada com" + (sucesso ? "Sucesso" : "Falha, Datas não mais disponiveis");
                return ResponseEntity.ok(messagem);

            } catch (Exception ex) {
                return new ResponseEntity("Erro ao aprovar :" + ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }