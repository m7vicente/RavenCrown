package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

@Component
public class ImagemServicoModel{

    public int idImagemServico;

    public int idServico;

    public int idUsuario;

    public String imagemURL;

    public byte[] image;

    public ImagemServicoModel(int idImagemServico, int idServico, int idUsuario, String imagemURL, byte[] image) {
        this.idImagemServico = idImagemServico;
        this.idServico = idServico;
        this.idUsuario = idUsuario;
        this.imagemURL = imagemURL;
        this.image = image;
    }

    public ImagemServicoModel() {
    }

    public int getIdImagemServico() {
        return idImagemServico;
    }

    public void setIdImagemServico(int idImagemServico) {
        this.idImagemServico = idImagemServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
