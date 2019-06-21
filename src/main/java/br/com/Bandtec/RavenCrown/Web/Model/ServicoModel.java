package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ServicoModel {

    private int idServico;

    private int idUsuario;

    private EnderecoModel Endereco;

    private int idCategoria;

    private List<ImagemServicoModel> Imagem;

    private String nomeServico;

    private String descricaoServico;

    private LocalDateTime tempoExecucao;

    private Double precoServico;

    private boolean localizacaoFixa;

    public ServicoModel() {
    }

    public ServicoModel(int idServico, int idUsuario, EnderecoModel endereco, int idCategoria, List<ImagemServicoModel> imagem, String nomeServico, String descricaoServico, LocalDateTime tempoExecucao, Double precoServico, boolean localizacaoFixa) {
        this.idServico = idServico;
        this.idUsuario = idUsuario;
        Endereco = endereco;
        this.idCategoria = idCategoria;
        Imagem = imagem;
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
        this.tempoExecucao = tempoExecucao;
        this.precoServico = precoServico;
        this.localizacaoFixa = localizacaoFixa;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EnderecoModel getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        Endereco = endereco;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<ImagemServicoModel> getImagem() {
        return Imagem;
    }

    public void setImagem(List<ImagemServicoModel> imagem) {
        Imagem = imagem;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public LocalDateTime getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(LocalDateTime tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public Double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) {
        this.precoServico = precoServico;
    }

    public boolean isLocalizacaoFixa() {
        return localizacaoFixa;
    }

    public void setLocalizacaoFixa(boolean localizacaoFixa) {
        this.localizacaoFixa = localizacaoFixa;
    }
}
