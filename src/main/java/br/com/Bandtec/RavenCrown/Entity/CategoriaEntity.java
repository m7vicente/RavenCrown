package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TBI_CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO", unique = true, nullable = false)
    private int Id_Categoria;

    private String Nome_Categoria;

    @OneToMany(mappedBy = "Categoria")
    private List<ServicoEntity> Servicos;

    public CategoriaEntity() {
    }

    public CategoriaEntity(int id_Categoria, String nome_Categoria, List<ServicoEntity> servicos) {
        Id_Categoria = id_Categoria;
        Nome_Categoria = nome_Categoria;
        Servicos = servicos;
    }

    public List<ServicoEntity> getServicos() {
        return Servicos;
    }

    public void setServicos(List<ServicoEntity> servicos) {
        Servicos = servicos;
    }

    public int getId_Categoria() { return Id_Categoria; }

    public void setId_Categoria(int id_Categoria) { Id_Categoria = id_Categoria; }

    public String getNome_Categoria() { return Nome_Categoria; }

    public void setNome_Categoria(String nome_Categoria) { Nome_Categoria = nome_Categoria; }
}
