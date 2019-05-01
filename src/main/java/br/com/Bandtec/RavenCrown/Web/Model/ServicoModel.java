package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.*;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownModel;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServicoModel implements RavenCrownModel<ServicoEntity> {

    private int Id_Servico;

    public int  Id_Usuario;

    private int Id_Endereco;

    private int Id_Categoria;

    private List<ImagemServicoModel> Imagens;

    private String Nome_Servico;

    private String Descricao_Servico;

    private Time Tempo_Execucao;

    private Double Preco_Servico;

    private boolean Localizacao_Fixa;

    public ServicoModel() {
    }

    public ServicoModel(ServicoEntity entity) {
        this.populateModel(entity);
    }

    public ServicoModel(int id_Servico, int id_Usuario, int id_Endereco, int id_Categoria, List<ImagemServicoModel> imagens, String nome_Servico, String descricao_Servico, Time tempo_Execucao, Double preco_Servico, boolean localizacao_Fixa) {
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

    public List<ImagemServicoModel> getImagens() {
        return Imagens;
    }

    public void setImagens(List<ImagemServicoModel> imagens) {
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
        this.setNome_Servico(object.getNome_Servico());
        this.setDescricao_Servico(object.getDescricao_Servico());
        this.setTempo_Execucao(object.getTempo_Execucao());
        this.setPreco_Servico(object.getPreco_Servico());
        this.setLocalizacao_Fixa(object.isLocalizacao_Fixa());

        if(object.getImagens() != null) {
            List<ImagemServicoModel> imagens = new ArrayList<>();

            for(int i =0; i < object.getImagens().size();i++){
                imagens.add(new ImagemServicoModel(object.getImagens().get(i)));
            }
            this.setImagens(imagens);
        }else{
            this.setImagens(null);
        }
    }

    @Override
    public ServicoEntity toEntity() {
        ServicoEntity entity = new ServicoEntity();

        entity.setId_Servico(this.getId_Servico());
        entity.setNome_Servico(this.getNome_Servico());
        entity.setDescricao_Servico(this.getDescricao_Servico());
        entity.setTempo_Execucao(this.getTempo_Execucao());
        entity.setPreco_Servico(this.getPreco_Servico());
        entity.setLocalizacao_Fixa(this.isLocalizacao_Fixa());

        entity.setPrestador(new UsuarioEntity(this.getId_Usuario()));
        entity.setEndereco(new EnderecoEntity(this.getId_Endereco()));
        entity.setCategoria(new CategoriaEntity(this.getId_Categoria()));

        if(this.getImagens() != null) {
            List<ImagemServicoEntity> imagens = new ArrayList<>();
            this.getImagens().forEach(X -> {
                imagens.add(X.toEntity());
            });
            entity.setImagens(imagens);
        }else{
            entity.setImagens(null);
        }
        return entity;
    }
}
