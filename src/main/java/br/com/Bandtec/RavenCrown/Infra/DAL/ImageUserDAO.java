package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownSaveImage;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemUsuarioModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUserDAO implements RavenCrownSaveImage<ImagemUsuarioModel> {

    private final String local;

    public ImageUserDAO(String local) {
        this.local = RepositoriesAdress.USER_IMAGE.getLocais();
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

        return imageURL;
    }

    @Override
    public byte[] getImage(String repository) {

        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(repository));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "png", bos );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }
}
