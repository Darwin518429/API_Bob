package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import jakarta.persistence.*;
//El nombre de las propiedades debe de ser igual que el nombre de las columanas de la bd
@Entity
@Table(name = "personajes")
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long  id;
    protected String nombre, especie, direccion, ocupacion;
    protected  int edad ;
    public PersonajeEntity() {}

    public PersonajeEntity(Long id, String nombre, String dirrecion, String especies, String rol, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = dirrecion;
        this.especie = especies;
        this.ocupacion = rol;
        this.edad = edad;
    }

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "PersonajeEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", especies='" + especie + '\'' +
                ", rol='" + ocupacion + '\'' +
                ", edad=" + edad +
                '}';
    }
}

