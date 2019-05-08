package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownModel;
import org.springframework.stereotype.Component;

@Component
public class ImagemServicoModel implements RavenCrownModel<ImagemServicoEntity> {


    private int Id_Imagem_Servico;

    private int Id_Servico;

    private int Id_Usuario;

    private String Imagem_URL;

    private byte[] image;

    public ImagemServicoModel(ImagemServicoEntity entity){
        this.populateModel(entity);
    }

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

    @Override
    public void populateModel(ImagemServicoEntity object) {
        this.setId_Imagem_Servico(object.getId_Imagem_Servico());
        this.setId_Usuario(object.getUsuario().getId_Usuario());
        this.setImagem_URL(object.getImagem_URL());
    }

    @Override
    public ImagemServicoEntity toEntity() {
        ImagemServicoEntity entity = new ImagemServicoEntity();

        entity.setServico(new ServicoEntity(this.getId_Servico()));
        entity.setImagem_URL(this.getImagem_URL());
        entity.setId_Imagem_Servico(this.getId_Imagem_Servico());
        entity.setUsuario(new UsuarioEntity(this.getId_Usuario()));

        return entity;
    }
}
