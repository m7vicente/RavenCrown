package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownModel;
import org.springframework.stereotype.Component;

@Component
public class ImagemUsuarioModel implements RavenCrownModel<ImagemUsuarioEntity> {

    private int Imagem_Id;

    private int Id_Usuario;

    private String Imagem_Url;

    private byte[] image;

    public ImagemUsuarioModel(ImagemUsuarioEntity imagem){
        populateModel(imagem);
    }

    public ImagemUsuarioModel(){
    }

    public ImagemUsuarioModel(int imagem_Id, int id_Usuario, String imagem_Url) {
        Imagem_Id = imagem_Id;
        Id_Usuario = id_Usuario;
        Imagem_Url = imagem_Url;
    }

    public int getImagem_Id() {
        return Imagem_Id;
    }

    public void setImagem_Id(int imagem_Id) {
        Imagem_Id = imagem_Id;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getImagem_Url() {
        return Imagem_Url;
    }

    public void setImagem_Url(String imagem_Url) {
        Imagem_Url = imagem_Url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public void populateModel(ImagemUsuarioEntity object) {
        this.setId_Usuario(object.getUsuario().getId_Usuario());
        this.setImagem_Id(object.getImagem_Id());
        this.setImagem_Url(object.getImagem_Url());
    }

    @Override
    public ImagemUsuarioEntity toEntity() {
        ImagemUsuarioEntity entity = new ImagemUsuarioEntity();

        entity.setImagem_Id(this.getImagem_Id());
        entity.setImagem_Url(this.getImagem_Url());
        entity.setUsuario(new UsuarioEntity(this.getId_Usuario()));

        return entity;
    }
}
