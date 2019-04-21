package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="TBD_ENDERECO")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Endereco", unique = true, nullable = false)
    private int Id_Endereco;

    private String Rua;

    private String Cep;

    private String Complemento;

    private String Numero;

    private String Referencia;

    private String Bairro;

    private String Cidade;

    private String Estado;

    private String Pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    public UsuarioEntity Usuario;

    public int getId_Endereco() {return this.Id_Endereco;}

    public void setId_Endereco(int id_Endereco) {Id_Endereco = id_Endereco; }

    public String getRua() {return this.Rua;}

    public void setRua(String rua) {this.Rua = rua;}

    public String getCep() {return Cep; }

    public void setCep(String cep) {this.Cep = cep; }

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

