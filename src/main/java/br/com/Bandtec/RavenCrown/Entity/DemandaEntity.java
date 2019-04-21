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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
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

    private int getId_Demanda() { return Id_Demanda; }

    private void setId_Demanda(int id_Demanda) { Id_Demanda = id_Demanda; }

    private EnderecoEntity getEndereco() { return Endereco; }

    private void setEndereco(EnderecoEntity Endereco) { Endereco = Endereco; }

    private UsuarioEntity getContratante() { return Contratante; }

    private void setContratante(UsuarioEntity Contratante) { Contratante = Contratante; }

    private String getNome_Demanda() { return Nome_Demanda; }

    private void setNome_Demanda(String nome_Demanda) { Nome_Demanda = nome_Demanda; }

    private String getDescricao_Demanda() { return Descricao_Demanda; }

    private void setDescricao_Demanda(String descricao_Ddemanda) { Descricao_Demanda = descricao_Ddemanda; }

    private Double getValor_Previsto() { return Valor_Previsto; }

    private void setValor_Previsto(Double valor_Previsto) { Valor_Previsto = valor_Previsto; }
}

