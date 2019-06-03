package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosContratosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.emailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ContratoBussiness {

    @Autowired
    private TodosContratosDAL contratosDAL;
    private emailDAO emailDAO;

    public ContratoEntity CreateContract(ContratoEntity contrato){
        ContratoEntity prestador = emailDAO.getID(contrato.getPrestador().getId_Usuario();
        ContratoEntity consumidor = emailDAO.getID(contrato.getPrestador().getId_Usuario();


        return contratosDAL.save(contrato);
    }

    public boolean AprovarConsumidor(int idContrato,boolean approvation){
        boolean sucess = true;

        ContratoEntity contrato = contratosDAL.getOne(idContrato);

        Date today = new Date(System.currentTimeMillis());

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

        Date today = new Date(System.currentTimeMillis());

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




}
