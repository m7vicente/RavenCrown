package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public interface RavenCrownSaveImage<U> {

    String saveImage(U imageBLOB);

    byte[] getImage(String idImage);
}
