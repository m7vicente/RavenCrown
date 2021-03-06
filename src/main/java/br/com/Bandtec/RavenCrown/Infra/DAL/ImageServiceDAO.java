package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownSaveImage;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageServiceDAO implements RavenCrownSaveImage<ImagemServicoModel> {

    private final String local;

    public ImageServiceDAO(){
        this.local = RepositoriesAdress.SERVICE_IMAGE.getLocais();
    }

    @Override
    public String saveImage(ImagemServicoModel imageBLOB) {

        String imageURL = local+"/image"+imageBLOB.getId_Servico()+imageBLOB.getId_Usuario()+imageBLOB.getId_Imagem_Servico()+".jpg";

        byte[] data = imageBLOB.getImage();

        try( OutputStream stream = new FileOutputStream(imageURL))
        {
            stream.write(data);
        }
        catch (Exception e)
        {
            imageURL = null;
        }

        return imageURL;
    }

    @Override
    public byte[] getImage(String ImageURL) {
        return null;
    }
}
