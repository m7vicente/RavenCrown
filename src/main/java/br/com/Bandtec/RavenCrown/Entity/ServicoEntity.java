package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name="TBD_SERVICO")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO", unique = true, nullable = false)
    private int Id_Servico;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_usuario_prestador", referencedColumnName = "id_usuario")
    public UsuarioEntity Prestador;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id_endereco")
    private EnderecoEntity Endereco;

    @OneToMany(mappedBy = "Servico")
    private List<ComentarioEntity> Comentarios;

    @OneToMany(mappedBy = "Servico")
    private List<DataServicoEntity> Datas;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name= "ID_categoria")
    private CategoriaEntity Categoria;

    @OneToMany(mappedBy = "Servico")
    private List<ImagemServicoEntity> Imagens;


    private String Nome_Servico;

    private String Descricao_Servico;

    private Time Tempo_Execucao;

    private Double Preco_Servico;

    private boolean Localizacao_Fixa;

    public ServicoEntity() {
    }

    public ServicoEntity(int id_Servico, UsuarioEntity prestador, EnderecoEntity endereco, List<ComentarioEntity> comentarios, List<DataServicoEntity> datas, CategoriaEntity categoria, String nome_Servico, String descricao_Servico, Time tempo_Execucao, Double preco_Servico, boolean localizacao_Fixa) {
        Id_Servico = id_Servico;
        Prestador = prestador;
        Endereco = endereco;
        Comentarios = comentarios;
        Datas = datas;
        Categoria = categoria;
        Nome_Servico = nome_Servico;
        Descricao_Servico = descricao_Servico;
        Tempo_Execucao = tempo_Execucao;
        Preco_Servico = preco_Servico;
        Localizacao_Fixa = localizacao_Fixa;
    }

    public ServicoEntity(int id_servico) {
        this.Id_Servico = id_servico;
    }

    public int getId_Servico() { return Id_Servico;}

    public void setId_Servico(int Id_Servico) { this.Id_Servico = Id_Servico;}

    public UsuarioEntity getPrestador() { return Prestador; }

    public void setPrestador(UsuarioEntity Prestador) { this.Prestador = Prestador;}

    public EnderecoEntity getEndereco() { return Endereco;}

    public void setEndereco(EnderecoEntity Endereco) { this.Endereco = Endereco;}

    public String getNome_Servico() { return Nome_Servico;}

    public void setNome_Servico(String Nome_Servico) { this.Nome_Servico = Nome_Servico; }

    public String getDescricao_Servico() { return Descricao_Servico; }

    public void setDescricao_Servico(String Desc_Servico) { this.Descricao_Servico = Desc_Servico; }

    public Time getTempo_Execucao() { return Tempo_Execucao; }

    public void setTempo_Execucao(Time Tempo_Execucao) {this.Tempo_Execucao = Tempo_Execucao; }

    public Double getPreco_Servico() { return Preco_Servico; }

    public void setPreco_Servico(Double Preco_Servico) { this.Preco_Servico = Preco_Servico; }

    public boolean isLocalizacao_Fixa() { return Localizacao_Fixa; }

    public void setLocalizacao_Fixa(boolean Localizacao_Fixa) { this.Localizacao_Fixa = Localizacao_Fixa; }

    public List<ComentarioEntity> getComentarios() {
        return Comentarios;
    }

    public void setComentarios(List<ComentarioEntity> comentarios) {
        Comentarios = comentarios;
    }

    public List<DataServicoEntity> getDatas() {
        return Datas;
    }

    public void setDatas(List<DataServicoEntity> datas) {
        Datas = datas;
    }

    public CategoriaEntity getCategoria() {
        return Categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        Categoria = categoria;
    }

    public List<ImagemServicoEntity> getImagens() {
        return Imagens;
    }

    public void setImagens(List<ImagemServicoEntity> imagens) {
        Imagens = imagens;
    }
}

