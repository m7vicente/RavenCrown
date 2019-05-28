package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

public class DemandaModel {

    private int Id_Demanda;

    private EnderecoEntity Endereco;

    private UsuarioEntity Contratante;

    private String Nome_Demanda;

    private String Descricao_Demanda;

    private Double Valor_Previsto;

    public DemandaModel(int id_Demanda, EnderecoEntity endereco, UsuarioEntity contratante, String nome_Demanda, String descricao_Demanda, Double valor_Previsto) {
        Id_Demanda = id_Demanda;
        Endereco = endereco;
        Contratante = contratante;
        Nome_Demanda = nome_Demanda;
        Descricao_Demanda = descricao_Demanda;
        Valor_Previsto = valor_Previsto;
    }
}
