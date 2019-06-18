package br.com.Bandtec.RavenCrown.Infra.Business;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Encryption {

    private static String GenerateStringHash(String password, int salt) throws NoSuchAlgorithmException {
        String compoundPassword = password + salt;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(compoundPassword .getBytes());
        byte[] passwordByte = md.digest();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < passwordByte.length; i++) {
            int highPart = ((passwordByte[i] >> 4) & 0xf) << 4;
            int lowPart = passwordByte[i] & 0xf;
            if (highPart == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(highPart | lowPart));
        }
        return s.toString();

    }

    public String Encript(String string){
        try {
            return this.GenerateStringHash(string, 1);
        }catch (Exception error){
            System.out.println(error.toString());
            return string;
        }
    }
}
