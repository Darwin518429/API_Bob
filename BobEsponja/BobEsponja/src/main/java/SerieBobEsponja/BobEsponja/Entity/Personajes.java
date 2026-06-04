package SerieBobEsponja.BobEsponja.Entity;

public class Personajes {
    protected  Long  id;
    protected String nombre,apellido,especies,rol;
    protected  int edad ;

    public Personajes(Long id, String nombre, String apellido, String especies, String rol, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especies = especies;
        this.rol = rol;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecies() {
        return especies;
    }

    public void setEspecies(String especies) {
        this.especies = especies;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especies='" + especies + '\'' +
                ", rol='" + rol + '\'' +
                ", edad=" + edad +
                '}';
    }
}

