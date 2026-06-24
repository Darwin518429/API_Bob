package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductoEntity {
/*
*     id              BIGINT AUTO_INCREMENT ,
    nombre          VARCHAR(100)   NOT NULL,
    precio          DECIMAL(5,2)   NOT NULL,
    id_restaurante  BIGINT         NOT NULL,
* */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long  id;
    protected Long id_restaurante;
    protected String nombre;
    protected Float precio;

    public ProductoEntity() {} //JPA/Hibernate necesita un constructor sin parámetros para poder crear los objetos cuando lee datos de la BD

    public ProductoEntity(Long id, Long id_restaurante,  String nombre, Float precio) {
        this.id = id;
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.precio = precio;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Long id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

