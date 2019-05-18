package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.ImageRepositoryAdress;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownSaveImage;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemUsuarioModel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;

public class ImageUserDAO implements RavenCrownSaveImage<ImagemUsuarioModel> {

    private final String local;

    public ImageUserDAO(String local) {
        this.local = ImageRepositoryAdress.USER.getLocais();
    }

    @Override
    public String saveImage(ImagemUsuarioModel imageBLOB) {

        String imageURL = local+"/image-"+imageBLOB.getId_Usuario()+".jpg";

        byte[] data = imageBLOB.getImage();

        try( OutputStream stream = new FileOutputStream(imageURL))
        {
            stream.write(data);
        }
        catch (Exception e)
        {
            imageURL = null;
        }

        return null;
    }

    @Override
    public byte[] getImage(String idImage) {
        return null;
    }
}
