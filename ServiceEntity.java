package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICO")
public class ServiceEntity {

    @Id
    public int Id_Servico;

    public int Id_Usuario;

    public int Id_Endereco;

    public String Nome_Servico;

    public String Desc_Servico;

    public Boolean Disponibilidade_Fds;

    public Datetime Tempo_Execucao;

    public Decimal Preco_Servico;

    public boolean Localizacao_Fixa;



    public int getId_Servico() { return Id_Servico;}

    public void setId_Servico(int Id_Servico) { this.Id_Servico = Id_Servico;}

    public int getId_Usuario() { return Id_Usuario; }

    public void setId_Usuario(int Id_Usuario) { this.Id_Usuario = Id_Usuario;}

    public int getId_Endereco() { return Id_Endereco;}

    public void setId_Endereco(int Id_Endereco) { this.Id_Endereco = Id_Endereco;}

    public String getNome_Servico() { return Nome_Servico;}

    public void setNome_Servico(String Nome_Servico) { this.Nome_Servico = Nome_Servico; }

    public String getDesc_Servico() { return Desc_Servico; }

    public void setDesc_Servico(String Desc_Servico) { this.Desc_Servico = Desc_Servico; }

    public Boolean getDisponibilidade_Fds() { return Disponibilidade_Fds; }

    public void setDisponibilidade_Fds(Boolean Disponibilidade_Fds) { this.Disponibilidade_Fds = Disponibilidade_Fds; }

    public Datetime getTempo_Execucao() { return Tempo_Execucao; }

    public void setTempo_Execucao(Datetime Tempo_Execucao) {this.Tempo_Execucao = Tempo_Execucao; }

    public Decimal getPreco_Servico() { return Preco_Servico; }

    public void setPreco_Servico(Decimal Preco_Servico) { this.Preco_Servico = Preco_Servico; }

    public boolean isLocalizacao_Fixa() { return Localizacao_Fixa; }

    public void setLocalizacao_Fixa(boolean Localizacao_Fixa) { this.Localizacao_Fixa = Localizacao_Fixa; }
}

