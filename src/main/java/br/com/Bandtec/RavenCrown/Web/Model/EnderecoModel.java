package br.com.Bandtec.RavenCrown.Web.Model;

public class EnderecoModel {

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

    public EnderecoModel(int id_Endereco, String rua, String cep, String complemento, String numero, String referencia, String bairro, String cidade, String estado, String pais) {
        Id_Endereco = id_Endereco;
        Rua = rua;
        Cep = cep;
        Complemento = complemento;
        Numero = numero;
        Referencia = referencia;
        Bairro = bairro;
        Cidade = cidade;
        Estado = estado;
        Pais = pais;
    }

    public int getId_Endereco() {
        return Id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        Id_Endereco = id_Endereco;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String pais) {
        Pais = pais;
    }
}
