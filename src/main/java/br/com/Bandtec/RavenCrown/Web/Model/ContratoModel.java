package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.util.List;

public class ContratoModel {

    private int idContrato;

    private int idServico;

    private EnderecoModel Endereco;

    private int idPrestador;

    private int idConsumidor;

    private int idDemanda;

    private double Valor_Final;

    private boolean Pago;

    private boolean Aprovado_Consumidor;

    private boolean Aprovado_Prestador;

    private List<DataServicoModel> Datas;

    public ContratoModel() {
    }

    public ContratoModel(int idContrato, int idServico, EnderecoModel endereco, int idPrestador, int idConsumidor, int idDemanda, double valor_Final, boolean pago, boolean aprovado_Consumidor, boolean aprovado_Prestador, List<DataServicoModel> datas) {
        this.idContrato = idContrato;
        this.idServico = idServico;
        Endereco = endereco;
        this.idPrestador = idPrestador;
        this.idConsumidor = idConsumidor;
        this.idDemanda = idDemanda;
        Valor_Final = valor_Final;
        Pago = pago;
        Aprovado_Consumidor = aprovado_Consumidor;
        Aprovado_Prestador = aprovado_Prestador;
        Datas = datas;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public EnderecoModel getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        Endereco = endereco;
    }

    public int getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        this.idPrestador = idPrestador;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public int getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        this.idDemanda = idDemanda;
    }

    public double getValor_Final() {
        return Valor_Final;
    }

    public void setValor_Final(double valor_Final) {
        Valor_Final = valor_Final;
    }

    public boolean isPago() {
        return Pago;
    }

    public void setPago(boolean pago) {
        Pago = pago;
    }

    public boolean isAprovado_Consumidor() {
        return Aprovado_Consumidor;
    }

    public void setAprovado_Consumidor(boolean aprovado_Consumidor) {
        Aprovado_Consumidor = aprovado_Consumidor;
    }

    public boolean isAprovado_Prestador() {
        return Aprovado_Prestador;
    }

    public void setAprovado_Prestador(boolean aprovado_Prestador) {
        Aprovado_Prestador = aprovado_Prestador;
    }

    public List<DataServicoModel> getDatas() {
        return Datas;
    }

    public void setDatas(List<DataServicoModel> datas) {
        Datas = datas;
    }
}