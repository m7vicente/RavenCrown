package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoBussines {

    @Autowired
    private  TodosServicosDAL servicosDAL;



}
