package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMENTARIO")
public class CommetEntity {

    @Id
    public int Id_Comentario;

    public int Id_Usuario;

    public int Id_Servico;

    public String De_Comentario;

    public Datetime Data_Comentario;

    public int getId_Comentario() { return Id_Comentario; }

    public void setId_Comentario(int Id_Comentario) { this.Id_Comentario = Id_Comentario; }

    public int getId_Usuario() { return Id_Usuario; }

    public void setId_Usuario(int id_Usuario) { Id_Usuario = id_Usuario; }

    public int getId_Servico() { return Id_Servico; }

    public void setId_Servico(int id_Servico) { Id_Servico = id_Servico; }

    public String getDe_Comentario() { return De_Comentario; }

    public void setDe_Comentario(String de_Comentario) { De_Comentario = de_Comentario; }

    public Datetime getData_Comentario() { return Data_Comentario; }

    public void setData_Comentario(Datetime data_Comentario) { Data_Comentario = data_Comentario; }
}
