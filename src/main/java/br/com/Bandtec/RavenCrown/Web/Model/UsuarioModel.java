package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Interfaces.RavenCrownModel;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class UsuarioModel implements RavenCrownModel<UsuarioEntity> {

    private String nome;

    private String email;

    private String senha;

    private int IdUsuairo;

    private int IdEndereco;

    private ImagemUsuarioModel imagem;

    private String CPF_CNPJ;

    private String RG;

    private String telefone;

    private boolean Prestador;

    private char sexo;

    private String estadoCivil;

    private Date data_Nascimento;

    public UsuarioModel(UsuarioEntity usr){
        populateModel(usr);
    }

    public UsuarioModel(String nome, String email, String senha, int idUsuairo, int idEndereco, ImagemUsuarioModel imagem, String CPF_CNPJ, String RG, String telefone, boolean prestador, char sexo, String estadoCivil, Date data_Nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        IdUsuairo = idUsuairo;
        IdEndereco = idEndereco;
        this.imagem = imagem;
        this.CPF_CNPJ = CPF_CNPJ;
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

    public int getIdUsuairo() {
        return IdUsuairo;
    }

    public void setIdUsuairo(int idUsuairo) {
        IdUsuairo = idUsuairo;
    }

    public int getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        IdEndereco = idEndereco;
    }

    public ImagemUsuarioModel getImagem() {
        return imagem;
    }

    public void setImagem(ImagemUsuarioModel imagem) {
        this.imagem = imagem;
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

    @Override
    public void populateModel(UsuarioEntity usr){
        this.setNome(usr.getNome_Usuario());
        this.setEmail(email = usr.getEmail_Usuario());
        this.setSenha(usr.getSenha());
        this.setIdUsuairo(usr.getId_Usuario());
        this.setIdEndereco(usr.getEndereco() == null ? 0 : usr.getEndereco().getId_Endereco());
        this.setImagem(new ImagemUsuarioModel(usr.getImagem()));
        this.setCPF_CNPJ(usr.getCPF_CNPJ());
        this.setRG(usr.getRG());
        this.setTelefone(usr.getTelefone_usuario());
        this.setPrestador(usr.isPrestador());
        this.setSexo(usr.getSexo());
        this.setEstadoCivil(usr.getEstado_Civil());
        this.setData_Nascimento(usr.getData_Nascimento());
    }

    @Override
    public UsuarioEntity toEntity(){
        UsuarioEntity usr = new UsuarioEntity();

        usr.setNome_Usuario(this.getNome());
        usr.setEmail_Usuario(this.getEmail());
        usr.setSenha(this.getSenha());
        usr.setId_Usuario(this.getIdUsuairo());
        usr.setCPF_CNPJ(this.getCPF_CNPJ());
        usr.setRG(this.getRG());
        usr.setTelefone_usuario(this.getTelefone());
        usr.setPrestador(this.isPrestador());
        usr.setSexo(this.getSexo());
        usr.setEstado_Civil(this.getEstadoCivil());
        usr.setData_Nascimento(this.getData_Nascimento());

        usr.setEndereco(new EnderecoEntity(this.getIdEndereco()));
        usr.setImagem(this.imagem.toEntity());

        return usr;
    }
}
