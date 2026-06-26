package SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido;

import jakarta.persistence.*;
/*
id_personaje    BIGINT  NOT NULL,
    id_producto     BIGINT  NOT NULL,
    cantidad        INT     NOT NULL DEFAULT 1,
    fecha           DATE    NOT NULL,
    total           DECIMAL(7,2),
*/

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long  id;
    protected Long id_personaje;
    protected int cantidad;
    protected String fecha;
    protected int total;
    public PedidoEntity(){}
    public PedidoEntity(Long id, Long id_personaje, int cantidad, String fecha, int total) {
        this.id = id;
        this.id_personaje = id_personaje;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(Long id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
