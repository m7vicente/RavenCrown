package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoBussiness {

    @Autowired
    private TodosEnderecosDAL enderecosDAL;

    public EnderecoEntity GetEndereco(int id){
        return enderecosDAL.getOne(id);
    }

}
