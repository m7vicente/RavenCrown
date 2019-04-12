package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IMAGEM_SERVICO")
public class ImagemServiceEntity {

    @Id
    public int Id_ImagemServico;

    public int Id_Servico;

    public int Id_Usuario;

    public String Url_Imagem;

    public int getId_ImagemServico() { return Id_ImagemServico; }

    public void setId_ImagemServico(int Id_ImagemServico) { this.Id_ImagemServico = Id_ImagemServico; }

    public int getId_Servico() { return Id_Servico; }

    public void setId_Servico(int Id_Servico) { this.Id_Servico = Id_Servico; }

    public int getId_Usuario() { return Id_Usuario; }

    public void setId_Usuario(int Id_Usuario) { this.Id_Usuario = Id_Usuario; }

    public String getUrl_Imagem() { return Url_Imagem; }

    public void setUrl_Imagem(String Url_Imagem) { this.Url_Imagem = Url_Imagem; }
}
