package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name="TBD_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    private int Id_Usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id_endereco")
    private EnderecoEntity Endereco;

    @OneToOne(mappedBy="Usuario")
    private ImagemUsuarioEntity Imagem;

    private String Nome_Usuario;

    @Column(unique=true)
    private String Email_Usuario;

    @Column(unique=true)
    private String CPF_CNPJ;

    private String RG;

    private String Telefone_usuario;

    private String Senha;

    private boolean Prestador;

    private char Sexo;

    private String Estado_Civil;

    private Date Data_Nascimento;

    public UsuarioEntity() {
    }

    public UsuarioEntity(int id_Usuario, EnderecoEntity endereco, ImagemUsuarioEntity imagem, String nome_Usuario, String email_Usuario, String CPF_CNPJ, String RG, String telefone_usuario, String senha, boolean prestador, char sexo, String estado_Civil, Date data_Nascimento, Collection<DataServicoEntity> datasPrestar, Collection<DataServicoEntity> datasConsumir, Collection<ContratoEntity> servicosPrestar, Collection<ContratoEntity> servicosConsumir) {
        Id_Usuario = id_Usuario;
        Endereco = endereco;
        Imagem = imagem;
        Nome_Usuario = nome_Usuario;
        Email_Usuario = email_Usuario;
        this.CPF_CNPJ = CPF_CNPJ;
        this.RG = RG;
        Telefone_usuario = telefone_usuario;
        Senha = senha;
        Prestador = prestador;
        Sexo = sexo;
        Estado_Civil = estado_Civil;
        Data_Nascimento = data_Nascimento;
        DatasPrestar = datasPrestar;
        DatasConsumir = datasConsumir;
        this.servicosPrestar = servicosPrestar;
        this.servicosConsumir = servicosConsumir;
    }

    public Date getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        Data_Nascimento = data_Nascimento;
    }

    public Collection<DataServicoEntity> getDatasPrestar() {
        return DatasPrestar;
    }

    public void setDatasPrestar(Collection<DataServicoEntity> datasPrestar) {
        DatasPrestar = datasPrestar;
    }

    public Collection<DataServicoEntity> getDatasConsumir() {
        return DatasConsumir;
    }

    public void setDatasConsumir(Collection<DataServicoEntity> datasConsumir) {
        DatasConsumir = datasConsumir;
    }

    public Collection<ContratoEntity> getServicosPrestar() {
        return servicosPrestar;
    }

    public void setServicosPrestar(Collection<ContratoEntity> servicosPrestar) {
        this.servicosPrestar = servicosPrestar;
    }

    public Collection<ContratoEntity> getServicosConsumir() {
        return servicosConsumir;
    }

    public void setServicosConsumir(Collection<ContratoEntity> servicosConsumir) {
        this.servicosConsumir = servicosConsumir;
    }

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

    @OneToMany(mappedBy="Prestador")
    private Collection<DataServicoEntity> DatasPrestar;

    @OneToMany(mappedBy="Consumidor")
    private Collection<DataServicoEntity>  DatasConsumir;

    @OneToMany(mappedBy="Prestador")
    private Collection<ContratoEntity> servicosPrestar ;

    @OneToMany(mappedBy="Consumidor")
    private Collection<ContratoEntity> servicosConsumir;

    @OneToOne(mappedBy = "Usuario")
    private ImagemUsuarioEntity ImagemPerfil;


}
