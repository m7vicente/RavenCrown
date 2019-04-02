package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IMAGEM_USUARIO")
public class ImagemUserEntity {

    @Id
    public int Imagem_Id;

    public int Id_Usuario;

    public String Imagem_Url;

    public int getId_Usuario() {return Id_Usuario; }

    public void setId_Usuario(int Id_Usuario) {this.Id_Usuario = Id_Usuario; }

    public int getImagem_Id() { return Imagem_Id; }

    public void setImagem_Id(int Imagem_Id) {this.Imagem_Id = Imagem_Id;}

    public String getImagem_Url() { return Imagem_Url; }

    public void setImagem_Url(String Imagem_Url) {this.Imagem_Url = Imagem_Url; }
}
