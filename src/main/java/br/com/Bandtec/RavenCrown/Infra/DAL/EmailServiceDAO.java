package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Infra.Interfaces.RepositoriesAdress;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class EmailServiceDAO {

    public boolean sandConfirmation(int idPrestador, int idCosumidor){
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT ).create();

        String json = gson.toJson("{idPrestador:\""+idPrestador+",idConsumidor:\""+idCosumidor+"\"}");

        try {

            URL url = new URL(RepositoriesAdress.WEB_SERVICE.toString()
                    +"idPrestador="+idPrestador
                    +"&idConsumidor="+idCosumidor);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
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
