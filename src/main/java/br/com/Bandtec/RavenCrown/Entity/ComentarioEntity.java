package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="TBD_COMENTARIO")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO", unique = true, nullable = false)
    private int Id_Comentario;

    @Column(name = "DE_COMENTARIO")
    private String De_Comentario ;

    @Column(name = "DATA_COMENTARIO")
    private Date Data_Comentario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private ServicoEntity Servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity Usuario;

    public ComentarioEntity() {
    }

    public ComentarioEntity(int id_Comentario, String de_Comentario, Date data_Comentario, ServicoEntity servico, UsuarioEntity usuario) {
        Id_Comentario = id_Comentario;
        De_Comentario = de_Comentario;
        Data_Comentario = data_Comentario;
        Servico = servico;
        Usuario = usuario;
    }

    public ServicoEntity getServico() {
        return Servico;
    }

    public void setServico(ServicoEntity servico) {
        Servico = servico;
    }

    public UsuarioEntity getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        Usuario = usuario;
    }

    public int getId_Comentario() {
        return Id_Comentario;
    }

    public void setId_Comentario(int id_Comentario) {
        Id_Comentario = id_Comentario;
    }

    public String getDe_Comentario() {
        return De_Comentario;
    }

    public void setDe_Comentario(String de_Comentario) {
        De_Comentario = de_Comentario;
    }

    public Date getData_Comentario() {
        return Data_Comentario;
    }

    public void setData_Comentario(Date data_Comentario) {
        Data_Comentario = data_Comentario;
    }

}
