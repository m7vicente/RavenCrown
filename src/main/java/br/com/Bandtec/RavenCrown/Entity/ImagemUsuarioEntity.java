package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;

@Entity
@Table(name="TBI_IMAGEM_USUARIO")
public class ImagemUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGEM_ID", unique = true, nullable = false)
    private int Imagem_Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity Usuario;

    private String Imagem_Url;

    public ImagemUsuarioEntity() {
    }

    public ImagemUsuarioEntity(int imagem_Id, UsuarioEntity usuario, String imagem_Url) {
        Imagem_Id = imagem_Id;
        Usuario = usuario;
        Imagem_Url = imagem_Url;
    }

    public UsuarioEntity getUsuario() {return Usuario; }

    public void setUsuario(UsuarioEntity Usuario) {
        this.Usuario = Usuario;
        Usuario.setImagem(this);
    }

    public int getImagem_Id() { return Imagem_Id; }

    public void setImagem_Id(int Imagem_Id) {this.Imagem_Id = Imagem_Id;}

    public String getImagem_Url() { return Imagem_Url; }

    public void setImagem_Url(String Imagem_Url) {this.Imagem_Url = Imagem_Url; }
}
