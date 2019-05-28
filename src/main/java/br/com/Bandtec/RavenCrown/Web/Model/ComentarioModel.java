package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;

public class ComentarioModel {

    private int Id_Comentario;

    private String De_Comentario ;

    private Date Data_Comentario;

    private ServicoEntity Servico;

    private UsuarioEntity Usuario;

    public ComentarioModel(int id_Comentario, String de_Comentario, Date data_Comentario, ServicoEntity servico, UsuarioEntity usuario) {
        Id_Comentario = id_Comentario;
        De_Comentario = de_Comentario;
        Data_Comentario = data_Comentario;
        Servico = servico;
        Usuario = usuario;
    }
}
