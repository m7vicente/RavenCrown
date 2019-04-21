package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.*;

@Entity
@Table(name="TBD_Contrato")
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato", unique = true, nullable = false)
    private int Id_Contrato;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private ServicoEntity Servico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "Id_endereco")
    private EnderecoEntity Endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_prestador")
    private UsuarioEntity Prestador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_consumidor")
    private UsuarioEntity Consumidor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_demanda", referencedColumnName = "id_demanda")
    private DemandaEntity Demanda;

    private double Valor_Final;

    private boolean Pago;

    private boolean Aprovado_Consumidor;

    private boolean Aprovado_Prestador;

    public ContratoEntity() {
    }

    public ContratoEntity(int id_Contrato, ServicoEntity servico, EnderecoEntity endereco, UsuarioEntity prestador, UsuarioEntity consumidor, DemandaEntity demanda, double valor_Final, boolean pago, boolean aprovado_Consumidor, boolean aprovado_Prestador) {
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

    public int getId_Contrato() { return Id_Contrato; }

    public void setId_Contrato(int id_Contrato) { Id_Contrato = id_Contrato; }

    public EnderecoEntity getEndereco() { return Endereco; }

    public void setEndereco(EnderecoEntity Endereco) { this.Endereco = Endereco; }

    public UsuarioEntity getPrestador() { return this.Prestador; }

    public void setPrestador(UsuarioEntity Prestador) { this.Prestador = Prestador; }

    public UsuarioEntity getConsumidor() { return Consumidor; }

    public void setConsumidor(UsuarioEntity Consumidor) { this.Consumidor = Consumidor; }

    public DemandaEntity getDemandaEntity() { return this.Demanda; }

    public void setDemanda(DemandaEntity Demanda) { this.Demanda = Demanda; }

    public double getValor_Final() { return Valor_Final; }

    public void setValor_Final(double valor_Final) { Valor_Final = valor_Final; }

    public boolean isPago() { return Pago; }

    public void setPago(boolean pago) { Pago = pago; }

    public boolean isAprovado_Consumidor() { return Aprovado_Consumidor; }

    public void setAprovado_Consumidor(boolean aprovado_Consumidor) { Aprovado_Consumidor = aprovado_Consumidor; }

    public boolean isAprovado_Prestador() { return Aprovado_Prestador; }

    public void setAprovado_Prestador(boolean aprovado_Prestador) { Aprovado_Prestador = aprovado_Prestador; }
}
