package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import jakarta.persistence.*;

@Entity
@Table(name = "resturantes")
public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long id ;
    private String nombre;
    private String propietario;
    private String direccion;
    public RestauranteEntity(){}
    public RestauranteEntity(Long id, String nombre, String propietario, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.direccion = direccion;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
