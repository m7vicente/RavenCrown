package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class EmailServiceDAO {

    public boolean sandConfirmation(int idPrestador, int idCosumidor){
        try {

            URL url = new URL(RepositoriesAdress.WEB_SERVICE.toString()
                    +"/?idPrestador="+idPrestador
                    +"&idConsumidor="+idCosumidor);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(null);
            os.flush();

            if (conn.getResponseCode() != 200) {
                //throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                System.out.println("Failed : HTTP error code : " + conn.getResponseCode());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
