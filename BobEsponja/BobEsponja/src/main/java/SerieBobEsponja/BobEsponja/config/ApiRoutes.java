package SerieBobEsponja.BobEsponja.config;

public class ApiRoutes {
    //  Definir las rutas en todos las apis rest
    public static final String Base = "/api/v1";
    //Buscador
    public static final String Buscar = "/buscar";
    //Elementos en comun
    public static final String Personajes = Base + "/personajes";
    public static final String Restaurantes = Base + "/restaurantes";
    public static final String Pedidos = Base + "/pedidos";
    public static final String Productos = Base + "/productos";
    public static final String Ingrediente = Base + "/ingrediente" ;

    //CRUD PaARA REUTILIZAR
    //GET
    private  final  static String getId = "/{id}";

    public static final String getPersonaje = Personajes + getId;
    public static final String getRestaurantes = Restaurantes + getId;
    public static final String getPedidos = Pedidos + getId;
    public static final String getProductos = Productos + getId;
    public static final String getIngrediente = Ingrediente + getId;


}
