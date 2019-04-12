package br.com.Bandtec.RavenCrown.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name="Comentario")
public class ComentarioEntity {

    @Id
    private Integer Id_Comentario;
    private String De_Comentario ;
    private Date Data_Comentario;
    private Integer Id_Servico;
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
