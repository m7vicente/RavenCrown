package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="TBD_SERVICO")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO", unique = true, nullable = false)
    public int Id_Servico;

    @OneToOne
    public UsuarioEntity Usuario_Prestador;

    @OneToOne
    public EnderecoEntity Endereco;

    public String Nome_Servico;

    public String Desc_Servico;

    public Boolean Disponibilidade_Fds;

    public Date Tempo_Execucao;

    public double Preco_Servico;

    public boolean Localizacao_Fixa;



    public int getId_Servico() { return Id_Servico;}

    public void setId_Servico(int Id_Servico) { this.Id_Servico = Id_Servico;}

    public UsuarioEntity getUsuario_Prestador() {
        return Usuario_Prestador;
    }

    public void setUsuario_Prestador(UsuarioEntity usuario_Prestador) {
        Usuario_Prestador = usuario_Prestador;
    }

    public EnderecoEntity getEndereco() { return this.Endereco;}

    public void setId_Endereco(EnderecoEntity Id_Endereco) { this.Endereco = Id_Endereco;}

    public String getNome_Servico() { return Nome_Servico;}

    public void setNome_Servico(String Nome_Servico) { this.Nome_Servico = Nome_Servico; }

    public String getDesc_Servico() { return Desc_Servico; }

    public void setDesc_Servico(String Desc_Servico) { this.Desc_Servico = Desc_Servico; }

    public Boolean getDisponibilidade_Fds() { return Disponibilidade_Fds; }

    public void setDisponibilidade_Fds(Boolean Disponibilidade_Fds) { this.Disponibilidade_Fds = Disponibilidade_Fds; }

    public Date getTempo_Execucao() { return Tempo_Execucao; }

    public void setTempo_Execucao(Date Tempo_Execucao) {this.Tempo_Execucao = Tempo_Execucao; }

    public double getPreco_Servico() { return Preco_Servico; }

    public void setPreco_Servico(double Preco_Servico) { this.Preco_Servico = Preco_Servico; }

    public boolean isLocalizacao_Fixa() { return Localizacao_Fixa; }

    public void setLocalizacao_Fixa(boolean Localizacao_Fixa) { this.Localizacao_Fixa = Localizacao_Fixa; }
}

