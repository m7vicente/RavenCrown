package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Infra.DAL.ImageServiceDAO;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImagemServicoBussines {

    @Autowired
    private TodosImagemServicoDAL repositorio;

    public List<ImagemServicoModel> getServiceImages(int idServico){

        List<ImagemServicoModel> images = new ArrayList<ImagemServicoModel>();
        ImageServiceDAO imageDAO = new ImageServiceDAO();

        repositorio.GetAllByServiceId(idServico).forEach(X -> {
            ImagemServicoModel imagemModel = new ImagemServicoModel();
            imagemModel.setImage(imageDAO.getImage(X.getImagem_URL()));
            imagemModel.setImagem_URL(X.getImagem_URL());
            imagemModel.setId_Servico(X.getId_Imagem_Servico());
            imagemModel.setId_Usuario(X.getUsuario().getId_Usuario());
            images.add(imagemModel);
        });

        return  images;
    }

}
