package br.com.Bandtec.RavenCrown.Web.Model;

import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;

public class ContratoModel {

    private int Id_Contrato;

    private ServicoEntity Servico;

    private EnderecoEntity Endereco;

    private UsuarioEntity Prestador;

    private UsuarioEntity Consumidor;

    private DemandaEntity Demanda;

    private double Valor_Final;

    private boolean Pago;

    private boolean Aprovado_Consumidor;

    private boolean Aprovado_Prestador;

    public ContratoModel(int id_Contrato, ServicoEntity servico, EnderecoEntity endereco, UsuarioEntity prestador, UsuarioEntity consumidor, DemandaEntity demanda, double valor_Final, boolean pago, boolean aprovado_Consumidor, boolean aprovado_Prestador) {
        Id_Contrato = id_Contrato;
        Servico = servico;
        Endereco = endereco;
        Prestador = prestador;
        Consumidor = consumidor;
        Demanda = demanda;
        Valor_Final = valor_Final;
        Pago = pago;
        Aprovado_Consumidor = aprovado_Consumidor;
        Aprovado_Prestador = aprovado_Prestador;
    }
}
