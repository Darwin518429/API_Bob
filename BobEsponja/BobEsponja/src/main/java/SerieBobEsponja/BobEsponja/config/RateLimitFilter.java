package SerieBobEsponja.BobEsponja.config;

import SerieBobEsponja.BobEsponja.Exception.ErrorMensajes;
import SerieBobEsponja.BobEsponja.Exception.RequestException;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//CLASSE QUE LIMITE LAS PETICIONES HTTP
@Component
public class RateLimitFilter extends OncePerRequestFilter {
private int capacidad = 10;
private int minutos = 1;
    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();
/*Un Bucket es un contador dque se van gastando con cada petición y que se recargan
 automáticamente con el tiempo.*/
    private Bucket createBucket() {
        return Bucket.builder()
                .addLimit(Bandwidth.simple(capacidad, Duration.ofMinutes(minutos))) //10 intentos por 1 min
                .build();
    }

    @Override // Se debe de implementar este metodo(Springboot ya te ejecuta este metodo por si solo)
    protected void doFilterInternal(
            HttpServletRequest  peticion, // Recibe la peticion clienntte http
            HttpServletResponse respuesta, // Respeusta del server que devolvera
            FilterChain filtro) throws  ServletException, IOException/*throws ServletException, IOException*/ { // Objeto que permite que Spring continue la ejecución de la petición con diferentes filtros  hasta llegar al controller.


        String ip = peticion.getRemoteAddr();

        Bucket bucket = buckets.computeIfAbsent(ip, k -> createBucket());
    /*Si la clave existe devuelve su valor
    Si no existe crealo y guárdalo automáticamente */

        if (bucket.tryConsume(1)) {
            filtro.doFilter(peticion, respuesta);

        } else {
            throw new RequestException(ErrorMensajes.RequestException);
        }
    }

}