package SerieBobEsponja.BobEsponja.Entity;

public class Personajes {
    protected  int id;
    protected String nombre,apellido,especies,rol;
    protected  int edad ;

    public Personajes(int id, String nombre, String apellido, String especies, String rol, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especies = especies;
        this.rol = rol;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

