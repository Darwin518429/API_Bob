package SerieBobEsponja.BobEsponja.Exception;

public class ErrorMensajes {
    //Personajes Fondo bikini
    final public  static String  PersonajeNotFound = "Personaje  no encontrado ";
    final public static String PersonajeAddException = "Error en añadir el personaje comprueba: \n1.El nombre debe de ser > 4 letras " +
            "\n2.La especie deb de ser > 2 letras ";

    final public static String PersonajePage = "Numero de pagina no puede ser menor que 0 ";

    final public static String PersonajeEleemnt = "El numero de elemntos no puede ser menor que 0 ";
    final public static String InvalidId = "Id invalido menor a 0";

    final public static String InvalidString = "TEXTO VACIO O CON EL FORMATO NO ADECUADO";

    //Mensajes Restaurante error
    final public static String RestaurentePage = "Error no se encontro el restaurante";
final public static String RestauranteId = "Restaurante no encontrado";
final public static String RestauranteAdd = "NO se ha podido añadir el retaurante";
    //MENSAJES  error peticion http
    final public static String RequestException = "Error Demasiadas excepciones";
}
