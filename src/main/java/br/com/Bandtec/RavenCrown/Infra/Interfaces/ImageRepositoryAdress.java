package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public enum ImageRepositoryAdress {

    SERVICE("c:/ravencrown/data/images/servicos"),
    USER("c:/ravencrown/data/images/usuarios");

    private String locais;

    private ImageRepositoryAdress(String tipo){
        this.locais = tipo;
    }

    public String getLocais(){
        return locais;
    }


}
