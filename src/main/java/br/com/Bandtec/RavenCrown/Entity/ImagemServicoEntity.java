package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="TBI_IMAGEM_SERVICO")
public class ImagemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IMAGENS", unique = true, nullable = false)
    private int Id_Imagem_Servico;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Id_servico")
    private ServicoEntity Servico;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private UsuarioEntity Usuario;

    private String Imagem_URL;

    public ImagemServicoEntity() {
    }

    public ImagemServicoEntity(int id_Imagem_Servico, ServicoEntity servico, UsuarioEntity usuario, String _ImagemURL) {
        Id_Imagem_Servico = id_Imagem_Servico;
        Servico = servico;
        Usuario = usuario;
        Imagem_URL = _ImagemURL;
    }

    public int getId_Imagem_Servico() { return Id_Imagem_Servico; }

    public void setId_Imagem_Servico(int Id_Imagem_Servico) { this.Id_Imagem_Servico = Id_Imagem_Servico; }

    public ServicoEntity getServico() { return Servico; }

    public void setServico(ServicoEntity Servico) { this.Servico = Servico; }

    public UsuarioEntity getUsuario() { return Usuario; }

    public void setUsuario(UsuarioEntity Usuario) { this.Usuario = Usuario; }

    public String getImagem_URL() { return Imagem_URL; }

    public void setImagem_URL(String Url_Imagem) { this.Imagem_URL = Url_Imagem; }
}
