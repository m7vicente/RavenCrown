package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UserEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogBussines {

    private Log logWriter = new Log();

    public void logLoginHistory(UserEntity user){

        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        Date d = new Date();

        String time = df.format(d) +" | "+user.getEmail_Usuario();

        logWriter.logLogin(time);
    }

}
