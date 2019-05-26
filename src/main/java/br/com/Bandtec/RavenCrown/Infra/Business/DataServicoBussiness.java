package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Web.Model.DataServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class DataServicoBussiness {

    @Autowired
    ServicoBussiness servicoBussiness;


    public boolean ValidateDate(DataServicoModel data) {
        boolean available = true;

        ServicoEntity servico = servicoBussiness.getById(data.getIdServico());

        for (DataServicoEntity x : servico.getDatas()) {
            if (x.getDt_Agendamento() != data.getDt_Agendamento()) {
                if (x.getDt_Agendamento().getDay() == data.getDt_Agendamento().getDay()) {
                    if ((x.getDt_Agendamento().getTime() + servico.getTempo_Execucao().getTime())
                            < data.getDt_Agendamento().getTime()) {
                        available = false;
                        break;
                    }
                }
            }else {
                available = false;
            }
        }

         return available;





    }
}
