package br.com.Bandtec.RavenCrown.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contrato")
public class ContractEntity {

    @Id
    public int Id_Contrato;

    public int Id_Servico;

    public int Id_Endereco;

    //public
}
