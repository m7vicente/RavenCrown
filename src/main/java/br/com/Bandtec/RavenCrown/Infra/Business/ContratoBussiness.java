package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.EmailServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosContratosDAL;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContratoBussiness {

    @Autowired
    private TodosContratosDAL contratosDAL;

    @Autowired
    private EmailServiceDAO emailDAO;

    public ContratoEntity CreateContract(ContratoEntity contrato){
        contrato = contratosDAL.save(contrato);

        emailDAO.sandConfirmation(contrato.getPrestador().getId_Usuario(),contrato.getConsumidor().getId_Usuario());

        return contrato;
    }

    public boolean AprovarConsumidor(int idContrato,boolean approvation){
        boolean sucess = true;

        ContratoEntity contrato = contratosDAL.getOne(idContrato);

        LocalDateTime today = LocalDateTime.now();

        for(DataServicoEntity x : contrato.getDatas()){
            if (x.getDt_Agendamento() ==  today){
                sucess = false;
                break;
            }
        };

        contrato.setAprovado_Consumidor(sucess && approvation);
        contratosDAL.save(contrato);
        return  sucess;
    }

    public boolean AprovarPrestador(int idContrato, boolean approvation){
        boolean sucess = true;

        ContratoEntity contrato = contratosDAL.getOne(idContrato);

        LocalDateTime today = LocalDateTime.now();

        for(DataServicoEntity x : contrato.getDatas()){
            if (x.getDt_Agendamento() ==  today){
                sucess = false;
                break;
            }
        };

        contrato.setAprovado_Prestador(sucess && approvation);
        contratosDAL.save(contrato);
        return  sucess;
    }


    public List<ContratoEntity> ObterTodosContratosPorConsumidor(int id) {
        return contratosDAL.GetByConsumer(id);
    }

    public List<ContratoEntity> ObterTodosContratosPorPrestador(int id) {
        return contratosDAL.GetByProvider(id);
    }
}
