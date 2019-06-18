package br.com.Bandtec.RavenCrown.Infra.Interfaces;

public enum RepositoriesAdress {

    SERVICE_IMAGE("C:/home/data/images/servicos"),
    USER_IMAGE("C:/home/data/images/usuarios"),
    WEB_SERVICE("https://ravenmail.azurewebsites.net/Default.aspx/SandEmail?");

    private String locais;

    private RepositoriesAdress(String tipo){
        this.locais = tipo;
    }

    public String getLocais(){
        return locais;
    }


}
