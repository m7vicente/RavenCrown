package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public interface RavenCrownModel<U> {

    void populateModel(U object);

    U toEntity();
}
