package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public interface RavenCrownSaveImage<U> {

    String saveImage(U imageBLOB);

    String getImage(String idImage);
}
