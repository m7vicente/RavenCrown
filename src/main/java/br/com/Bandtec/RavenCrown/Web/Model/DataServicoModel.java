package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

import java.sql.Date;

public class DataServicoModel {

    private int Id_data_agendado;

    private UsuarioEntity Prestador;

    private UsuarioEntity Consumidor;

    private ServicoEntity Servico;

    private ContratoEntity Contrato;

    private DemandaEntity Demanda;

    private Date Dt_Agendamento;

    private char Tipo_Reserva;

}
