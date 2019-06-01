package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class ImagemServicoModel{

    private int Id_Imagem_Servico;

    private int Id_Servico;

    private int Id_Usuario;

    private String Imagem_URL;

    private byte[] image;

    public int getId_Imagem_Servico() {
        return Id_Imagem_Servico;
    }

    public void setId_Imagem_Servico(int id_Imagem_Servico) {
        Id_Imagem_Servico = id_Imagem_Servico;
    }

    public int getId_Servico() {
        return this.Id_Servico;
    }

    public void setId_Servico(int servico) {
        this.Id_Servico = servico;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getImagem_URL() {
        return Imagem_URL;
    }

    public void setImagem_URL(String imagem_URL) {
        Imagem_URL = imagem_URL;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ImagemServicoModel() {
    }

    public ImagemServicoModel(int id_Imagem_Servico, int servico, int id_Usuario, String imagem_URL, byte[] image) {
        Id_Imagem_Servico = id_Imagem_Servico;
        Id_Servico = servico;
        Id_Usuario = id_Usuario;
        Imagem_URL = imagem_URL;
        this.image = image;
    }
}
