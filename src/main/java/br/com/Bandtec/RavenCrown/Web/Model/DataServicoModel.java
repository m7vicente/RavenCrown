package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;

public class DataServicoModel {

    private int Id_data_agendado;

    private int IdPrestador;

    private int IdConsumidor;

    private int IdServico;

    private int IdContrato;

    private int IdDemanda;

    private Date Dt_Agendamento;

    private char Tipo_Reserva;

    public DataServicoModel() {
    }

    public DataServicoModel(int id_data_agendado, int idPrestador, int idConsumidor, int idServico, int idContrato, int idDemanda, Date dt_Agendamento, char tipo_Reserva) {
        Id_data_agendado = id_data_agendado;
        IdPrestador = idPrestador;
        IdConsumidor = idConsumidor;
        IdServico = idServico;
        IdContrato = idContrato;
        IdDemanda = idDemanda;
        Dt_Agendamento = dt_Agendamento;
        Tipo_Reserva = tipo_Reserva;
    }


    public int getId_data_agendado() {
        return Id_data_agendado;
    }

    public void setId_data_agendado(int id_data_agendado) {
        Id_data_agendado = id_data_agendado;
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

    public Date getDt_Agendamento() {
        return Dt_Agendamento;
    }

    public void setDt_Agendamento(Date dt_Agendamento) {
        Dt_Agendamento = dt_Agendamento;
    }

    public char getTipo_Reserva() {
        return Tipo_Reserva;
    }

    public void setTipo_Reserva(char tipo_Reserva) {
        Tipo_Reserva = tipo_Reserva;
    }
}
