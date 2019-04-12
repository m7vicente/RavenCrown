package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Endereco")
public class AdressEntity {

    @Id
    public int Id_Endereco;

    public String Rua;

    public int Cep;

    public String Complemento;

    public String Numero;

    public String Referencia;

    public String Bairro;

    public String Cidade;

    public String Estado;

    public String Pais;

    public int getId_Endereco() {return getId_Endereco;}

    public void setId_Endereco(int id_Endereco) {Id_Endereco = id_Endereco; }

    public String getRua() {return getRua;}

    public void setRua(String rua) {this.Rua = rua;}

    public int getCep() {return Cep; }

    public void setCep(int cep) {this.Cep = cep; }

    public String getComplemento() { return Complemento; }

    public void setComplemento(String complemento) {this.Complemento = complemento; }

    public String getNumero() { return Numero; }

    public void setNumero(String Numero) {this.Numero = Numero; }

    public String getReferencia() { return Referencia; }

    public void setReferencia(String Referencia) {this.Referencia = Referencia; }

    public String getBairro() {return Bairro;}

    public void setBairro(String Bairro) {this.Bairro = Bairro; }

    public String getCidade() { return Cidade; }

    public void setCidade(String Cidade) {this.Cidade = Cidade; }

    public String getEstado() { return Estado; }

    public void setEstado(String Estado) {this.Estado = Estado; }

    public String getPais() { return Pais; }

    public void setPais(String Pais) {this.Pais = Pais; }


}

