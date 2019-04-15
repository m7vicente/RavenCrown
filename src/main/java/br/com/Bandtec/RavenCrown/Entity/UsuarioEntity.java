package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="TBD_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    public int Id_Usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id_endereco")
    public EnderecoEntity Endereco;

    public String Nome_Usuario;

    public String Email_Usuario;

    public String CPF_CNPJ;

    public String RG;

    public String Telefone_usuario;

    public String Senha;

    public boolean Prestador;

    public char Sexo;

    public String Estado_Civil;

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public EnderecoEntity getId_Endereco() {
        return Endereco;
    }

    public void setId_Endereco(EnderecoEntity id_Endereco) {
        Endereco = id_Endereco;
    }

    public String getNome_Usuario() {
        return Nome_Usuario;
    }

    public void setNome_Usuario(String nome_Usuario) {
        Nome_Usuario = nome_Usuario;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone_usuario() {
        return Telefone_usuario;
    }

    public void setTelefone_usuario(String telefone_usuario) {
        Telefone_usuario = telefone_usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public boolean isPrestador() {
        return Prestador;
    }

    public void setPrestador(boolean prestador) {
        Prestador = prestador;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char sexo) {
        Sexo = sexo;
    }

    public String getEstado_Civil() {
        return Estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        Estado_Civil = estado_Civil;
    }

    public String getEmail_Usuario() {
        return Email_Usuario;
    }

    public void setEmail_Usuario(String email_Usuario) {
        Email_Usuario = email_Usuario;
    }
}
