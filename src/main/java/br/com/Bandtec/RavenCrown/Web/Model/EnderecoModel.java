package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

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

    private UsuarioEntity Usuario;

    public EnderecoModel(int id_Endereco, String rua, String cep, String complemento, String numero, String referencia, String bairro, String cidade, String estado, String pais, UsuarioEntity usuario) {
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
        Usuario = usuario;
    }
}
