package SerieBobEsponja.BobEsponja.Exception;

public class ErrorMensajes {
    //Personajes Fondo bikini
    final public  static String  PersonajeNotFound = "Personaje  no encontrado ";
    final public static String PersonajeAddException = "Error en añadir el personaje comprueba: \n1.El nombre debe de ser > 4 letras " +
            "\n2.La especie deb de ser > 2 letras ";

    final public static String PersonajePage = "Numero de pagina  no encontrado ";
    final public static String PersonajeEleemnt = "El numero de elemntos no puede ser menor que 0 ";
    final public static String InvalidId = "Id invalido menor a 0";
    final public static String InvalidString = "TEXTO VACIO O CON EL FORMATO NO ADECUADO";

    //Mensajes Restaurante error
    final public static String RestaurentePage = "Error no se encontro  el num de  pagina ";
    final public static String RestauranteId = "Restaurante no encontrado";
    final public static String RestauranteAdd = "NO se ha podido añadir el retaurante";
    final public static String RestauranteSize = "Tamaño no valido";

    //Mensajes Productos

    final public static String ProductoPage = "NO se encuentra pagina";
    final public static String ProductoId = "Restaurante no encontrado";
    final public static String ProductoAdd = "NO se ha podido añadir el retaurante";
    final public static String ProductoSize = "Tamaño no valido";

    //Mensahes Pedidos

    final public static String PedidoPage = "NO se encuentra pagina";
    final public static String PedidoId = "Pedodp no encontrado";
    final public static String PeidoAdd = "NO se ha podido añadir el pedido";
    final public static String PedidoSize = "Error no se puede size ";
    final public static String PedidoPrecio = "Error con el total";


    //Mensajes Ingredientes
    final public static String IngredientePage = "NO se encuentra pagina";
    final public static String IngredienteId = "Ingrediente no encontrado";
    final public static String IngredienteAdd = "NO se ha podido añadir el ingrediente";
    final public static String IngredienteSize = "Error no se puede size ";
    final public static String IngredientePrecio = "Error con el total";



    //MENSAJES  error peticion http
    final public static String RequestException = "Error Demasiadas excepciones";

    //Error general (Que falal al escribir)
    final public static String RutaGeneral = "Error no se ha encontrado la ruta ";
}
