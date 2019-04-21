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
    @JoinColumn(name="id_servico")
    private ServicoEntity Servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity Usuario;

    private String Url_Imagem;

    public ImagemServicoEntity() {
    }

    public ImagemServicoEntity(int id_Imagem_Servico, ServicoEntity servico, UsuarioEntity usuario, String url_Imagem) {
        Id_Imagem_Servico = id_Imagem_Servico;
        Servico = servico;
        Usuario = usuario;
        Url_Imagem = url_Imagem;
    }

    public int getId_Imagem_Servico() { return Id_Imagem_Servico; }

    public void setId_Imagem_Servico(int Id_Imagem_Servico) { this.Id_Imagem_Servico = Id_Imagem_Servico; }

    public ServicoEntity getServico() { return Servico; }

    public void setServico(ServicoEntity Servico) { this.Servico = Servico; }

    public UsuarioEntity getUsuario() { return Usuario; }

    public void setUsuario(UsuarioEntity Usuario) { this.Usuario = Usuario; }

    public String getUrl_Imagem() { return Url_Imagem; }

    public void setUrl_Imagem(String Url_Imagem) { this.Url_Imagem = Url_Imagem; }
}
