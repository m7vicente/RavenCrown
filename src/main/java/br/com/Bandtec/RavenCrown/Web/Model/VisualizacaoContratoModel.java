package br.com.Bandtec.RavenCrown.Web.Model;

import java.util.List;

public class VisualizacaoContratoModel extends ContratoModel{

    private UsuarioModel prestador;

    private ServicoModel servicoModel;

    private List<DataServicoModel> datas;


    public UsuarioModel getPrestador() {
        return prestador;
    }

    public void setPrestador(UsuarioModel prestador) {
        this.prestador = prestador;
    }

    public ServicoModel getServicoModel() {
        return servicoModel;
    }

    public void setServicoModel(ServicoModel servicoModel) {
        this.servicoModel = servicoModel;
    }

    @Override
    public List<DataServicoModel> getDatas() {
        return datas;
    }

    @Override
    public void setDatas(List<DataServicoModel> datas) {
        this.datas = datas;
    }
}
