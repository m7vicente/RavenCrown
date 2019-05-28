package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public enum RepositoriesAdress {

    SERVICE_IMAGE("c:/ravencrown/data/images/servicos"),
    USER_IMAGE("c:/ravencrown/data/images/usuarios");

    private String locais;

    private RepositoriesAdress(String tipo){
        this.locais = tipo;
    }

    public String getLocais(){
        return locais;
    }


}
