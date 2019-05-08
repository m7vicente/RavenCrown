package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.ImageServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
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

    public ServicoModel insertService(ServicoModel servico){

        ServicoEntity servicoEntity = servicosDAL.save(servico.toEntity());

        if(servico.getImagens() != null) {
            for(int i = 0; i < servico.getImagens().size();i++){
                servico.getImagens().get(i).setId_Servico(servicoEntity.getId_Servico());
                servico.getImagens().get(i).setId_Usuario(servicoEntity.getPrestador().getId_Usuario());
                servico.getImagens().get(i).setImagem_URL(new ImageServiceDAO().saveImage(servico.getImagens().get(i)));

                ImagemServicoEntity imagemServicoEntity = servico.getImagens().get(i).toEntity();
                imagemServicoEntity.setServico(servicoEntity);

                servicoEntity.getImagens().add(imagemServicoEntity);
                }
            servicosDAL.save(servicoEntity);
        }


        return new ServicoModel(servicoEntity);
    }

    public void UpdateService(ServicoModel model) {
        servicosDAL.save(model.toEntity());
    }

    public void DeleteService(ServicoModel model) {
        servicosDAL.delete(model.toEntity());
    }
}
