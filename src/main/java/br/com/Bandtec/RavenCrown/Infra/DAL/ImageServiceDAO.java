package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownSaveImage;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageServiceDAO implements RavenCrownSaveImage<ImagemServicoModel> {

    private final String local;

    public ImageServiceDAO(){
        this.local = RepositoriesAdress.SERVICE_IMAGE.getLocais();
    }

    @Override
    public String saveImage(ImagemServicoModel imageBLOB) {

        String imageURL = local+"/image"+imageBLOB.getIdServico()+imageBLOB.getIdUsuario()+imageBLOB.getIdImagemServico()+".jpg";

        byte[] data = imageBLOB.getImage();

        try( OutputStream stream = new FileOutputStream(imageURL))
        {
            stream.write(data);
        }
        catch (Exception e)
        {
            imageURL = null;
            System.out.println("Erro on save image: "+e.toString());
        }

        return imageURL;
    }

    @Override
    public byte[] getImage(String ImageURL) {

        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(ImageURL));
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
