package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UsuarioModel {

    private String nome;

    private String email;

    private String senha;

    private int Id_Usuario;

    private EnderecoModel endereco;

    private ImagemUsuarioModel imagem;

    private String cpfCnpj;

    private String RG;

    private String telefone;

    private boolean Prestador;

    private char sexo;

    private String estadoCivil;

    private Date data_Nascimento;

    public UsuarioModel(String nome, String email, String senha, int idUsuario, EnderecoModel endereco, ImagemUsuarioModel imagem, String cpfcnpj, String RG, String telefone, boolean prestador, char sexo, String estadoCivil, Date data_Nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        Id_Usuario = idUsuario;
        this.endereco = endereco;
        this.imagem = imagem;
        this.cpfCnpj = cpfcnpj;
        this.RG = RG;
        this.telefone = telefone;
        Prestador = prestador;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data_Nascimento = data_Nascimento;
    }

    public UsuarioModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public EnderecoModel getEndereco() {
        return this.endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public ImagemUsuarioModel getImagem() {
        return imagem;
    }

    public void setImagem(ImagemUsuarioModel imagem) {
        this.imagem = imagem;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isPrestador() {
        return Prestador;
    }

    public void setPrestador(boolean prestador) {
        Prestador = prestador;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }

}
