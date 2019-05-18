package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.ImageServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoBussiness {

    @Autowired
    private  TodosServicosDAL servicosDAL;
    @Autowired
    private TodosImagemServicoDAL imagensDAL;

    @Autowired
    private TodosImagemServicoDAL imagensServicoDAL;


    public ServicoEntity getById(int id) {
        return servicosDAL.getOne(id);
    }

    public ServicoEntity insertService(ServicoEntity servico){

        ServicoEntity servicoEntity = servicosDAL.save(servico);

        return servicoEntity;
    }

    public void UpdateService(ServicoEntity model) {
        servicosDAL.save(model);
    }

    public void DeleteService(ServicoEntity model) {
        servicosDAL.delete(model);
    }

    public List<ServicoEntity>ObterTodosServicosPorPrestadorId(int id){
        return servicosDAL.GetAllServicesByUserId(id);
    }

}
