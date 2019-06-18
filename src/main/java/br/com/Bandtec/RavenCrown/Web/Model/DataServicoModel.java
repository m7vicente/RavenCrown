package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;
import java.time.LocalDateTime;

public class DataServicoModel {

    private int IdDataAgendamento;

    private int IdPrestador;

    private int IdConsumidor;

    private int IdServico;

    private int IdContrato;

    private int IdDemanda;

    private LocalDateTime DtAgendamento;

    private char TipoReserva;

    public int getIdDataAgendamento() {
        return IdDataAgendamento;
    }

    public void setIdDataAgendamento(int idDataAgendamento) {
        IdDataAgendamento = idDataAgendamento;
    }

    public int getIdPrestador() {
        return IdPrestador;
    }

    public void setIdPrestador(int idPrestador) {
        IdPrestador = idPrestador;
    }

    public int getIdConsumidor() {
        return IdConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        IdConsumidor = idConsumidor;
    }

    public int getIdServico() {
        return IdServico;
    }

    public void setIdServico(int idServico) {
        IdServico = idServico;
    }

    public int getIdContrato() {
        return IdContrato;
    }

    public void setIdContrato(int idContrato) {
        IdContrato = idContrato;
    }

    public int getIdDemanda() {
        return IdDemanda;
    }

    public void setIdDemanda(int idDemanda) {
        IdDemanda = idDemanda;
    }

    public LocalDateTime getDtAgendamento() {
        return DtAgendamento;
    }

    public void setDtAgendamento(LocalDateTime dtAgendamento) {
        DtAgendamento = dtAgendamento;
    }

    public char getTipoReserva() {
        return TipoReserva;
    }

    public void setTipoReserva(char tipoReserva) {
        TipoReserva = tipoReserva;
    }
}