package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="TBD_Demanda")
public class DemandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEMANDA", unique = true, nullable = false)
    private int Id_Demanda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id_endereco")
    private EnderecoEntity Endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_consumidor")
    private UsuarioEntity Contratante;

    private String Nome_Demanda;

    private String Descricao_Demanda;

    private Double Valor_Previsto;

    public DemandaEntity() {
    }

    public DemandaEntity(int id_Demanda, EnderecoEntity endereco, UsuarioEntity contratante, String nome_Demanda, String descricao_Demanda, Double valor_Previsto) {
        Id_Demanda = id_Demanda;
        Endereco = endereco;
        Contratante = contratante;
        Nome_Demanda = nome_Demanda;
        Descricao_Demanda = descricao_Demanda;
        Valor_Previsto = valor_Previsto;
    }

    public int getId_Demanda() { return Id_Demanda; }

    public void setId_Demanda(int id_Demanda) { Id_Demanda = id_Demanda; }

    public EnderecoEntity getEndereco() { return Endereco; }

    public void setEndereco(EnderecoEntity Endereco) { Endereco = Endereco; }

    public UsuarioEntity getContratante() { return Contratante; }

    public void setContratante(UsuarioEntity Contratante) { Contratante = Contratante; }

    public String getNome_Demanda() { return Nome_Demanda; }

    public void setNome_Demanda(String nome_Demanda) { Nome_Demanda = nome_Demanda; }

    public String getDescricao_Demanda() { return Descricao_Demanda; }

    public void setDescricao_Demanda(String descricao_Ddemanda) { Descricao_Demanda = descricao_Ddemanda; }

    public Double getValor_Previsto() { return Valor_Previsto; }

    public void setValor_Previsto(Double valor_Previsto) { Valor_Previsto = valor_Previsto; }
}

