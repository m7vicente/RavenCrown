package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="dbo.TBD_COMENTARIO")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO", unique = true, nullable = false)
    private Integer Id_Comentario;

    @Column(name = "DE_COMENTARIO")
    private String De_Comentario ;

    @Column(name = "DATA_COMENTARIO")
    private Date Data_Comentario;

    @Column(name = "ID_SERVICO")
    private Integer Id_Servico;

    @Column(name = "ID_USUARIO")
    private Integer Id_Usuario;


    public ComentarioEntity(){}

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

    public Integer getId_Servico() {
        return Id_Servico;
    }

    public void setId_Servico(Integer id_Servico) {
        Id_Servico = id_Servico;
    }

    public Integer getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        Id_Usuario = id_Usuario;
    }
}
