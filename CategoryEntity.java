package br.com.Bandtec.RavenCrown.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class CategoryEntity {

    @Id
    public int Id_Categoria;

    public String Nome_Categoria;

    public int getId_Categoria() { return Id_Categoria; }

    public void setId_Categoria(int id_Categoria) { Id_Categoria = id_Categoria; }

    public String getNome_Categoria() { return Nome_Categoria; }

    public void setNome_Categoria(String nome_Categoria) { Nome_Categoria = nome_Categoria; }
}
