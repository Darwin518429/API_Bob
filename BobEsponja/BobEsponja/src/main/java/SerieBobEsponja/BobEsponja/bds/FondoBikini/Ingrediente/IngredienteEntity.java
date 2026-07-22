package SerieBobEsponja.BobEsponja.bds.FondoBikini.Ingrediente;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientes")
public class IngredienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long  id;
    protected String nombre;
    protected int alergeno ;
public IngredienteEntity(){}
    public IngredienteEntity(Long id, String nombre, int alergeno) {
        this.id = id;
        this.nombre = nombre;
        this.alergeno = alergeno;
    }
//Los neecsita el springboot lpara obtener los datos los fgetters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlergeno() {
        return alergeno;
    }

    public void setAlergeno(int alergeno) {
        this.alergeno = alergeno;
    }
}
