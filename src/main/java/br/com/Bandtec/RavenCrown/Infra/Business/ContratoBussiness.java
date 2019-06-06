package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.EmailServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosContratosDAL;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.OutputStream;


import java.sql.Date;

@Service
public class ContratoBussiness {

    @Autowired
    private TodosContratosDAL contratosDAL;

    @Autowired
    EmailServiceDAO emailDAO;

    public ContratoEntity CreateContract(ContratoEntity contrato){

        contrato = contratosDAL.save(contrato);

        emailDAO.sandConfirmation(contrato.getPrestador().getId_Usuario(),contrato.getConsumidor().getId_Usuario());

        return contrato;
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
