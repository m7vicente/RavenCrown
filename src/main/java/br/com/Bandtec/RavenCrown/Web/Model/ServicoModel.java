package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownModel;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.List;

@Component
public class ServicoModel implements RavenCrownModel<ServicoEntity> {

    private int Id_Servico;

    public int  Id_Usuario;

    private int Id_Endereco;

    private int Id_Categoria;

    private List<Object> Imagens;

    private String Nome_Servico;

    private String Descricao_Servico;

    private Time Tempo_Execucao;

    private Double Preco_Servico;

    private boolean Localizacao_Fixa;

    public ServicoModel() {
    }

    public ServicoModel(int id_Servico, int id_Usuario, int id_Endereco, int id_Categoria, List<Object> imagens, String nome_Servico, String descricao_Servico, Time tempo_Execucao, Double preco_Servico, boolean localizacao_Fixa) {
        Id_Servico = id_Servico;
        Id_Usuario = id_Usuario;
        Id_Endereco = id_Endereco;
        Id_Categoria = id_Categoria;
        Imagens = imagens;
        Nome_Servico = nome_Servico;
        Descricao_Servico = descricao_Servico;
        Tempo_Execucao = tempo_Execucao;
        Preco_Servico = preco_Servico;
        Localizacao_Fixa = localizacao_Fixa;
    }

    public int getId_Servico() {
        return Id_Servico;
    }

    public void setId_Servico(int id_Servico) {
        Id_Servico = id_Servico;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public int getId_Endereco() {
        return Id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        Id_Endereco = id_Endereco;
    }

    public int getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        Id_Categoria = id_Categoria;
    }

    public List<Object> getImagens() {
        return Imagens;
    }

    public void setImagens(List<Object> imagens) {
        Imagens = imagens;
    }

    public String getNome_Servico() {
        return Nome_Servico;
    }

    public void setNome_Servico(String nome_Servico) {
        Nome_Servico = nome_Servico;
    }

    public String getDescricao_Servico() {
        return Descricao_Servico;
    }

    public void setDescricao_Servico(String descricao_Servico) {
        Descricao_Servico = descricao_Servico;
    }

    public Time getTempo_Execucao() {
        return Tempo_Execucao;
    }

    public void setTempo_Execucao(Time tempo_Execucao) {
        Tempo_Execucao = tempo_Execucao;
    }

    public Double getPreco_Servico() {
        return Preco_Servico;
    }

    public void setPreco_Servico(Double preco_Servico) {
        Preco_Servico = preco_Servico;
    }

    public boolean isLocalizacao_Fixa() {
        return Localizacao_Fixa;
    }

    public void setLocalizacao_Fixa(boolean localizacao_Fixa) {
        Localizacao_Fixa = localizacao_Fixa;
    }

    @Override
    public void populateModel(ServicoEntity object) {
        this.setId_Servico(object.getId_Servico());
        this.setId_Usuario(object.getPrestador().getId_Usuario());
        this.setId_Endereco(object.getEndereco().getId_Endereco());
        this.setId_Categoria(object.getCategoria().getId_Categoria());
        //this.setImagens(object.getImagens());
        this.setNome_Servico(object.getNome_Servico());
        this.setDescricao_Servico(object.getDescricao_Servico());
        this.setTempo_Execucao(object.getTempo_Execucao());
        this.setPreco_Servico(object.getPreco_Servico());
        this.setLocalizacao_Fixa(object.isLocalizacao_Fixa());
    }
}
