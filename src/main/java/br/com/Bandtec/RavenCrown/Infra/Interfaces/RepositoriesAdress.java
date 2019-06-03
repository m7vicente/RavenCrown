package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public enum RepositoriesAdress {

    SERVICE_IMAGE("/home/ravencrown/images/servicos"),
    USER_IMAGE("/home/ravencrown/images/usuarios");

    private String locais;

    private RepositoriesAdress(String tipo){
        this.locais = tipo;
    }

    public String getLocais(){
        return locais;
    }


}
