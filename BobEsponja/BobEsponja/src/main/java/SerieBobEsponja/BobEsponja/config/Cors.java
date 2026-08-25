package SerieBobEsponja.BobEsponja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Cors  implements WebMvcConfigurer {//Nos sirve para poder configurar que puertos pueden accedr a uestro servicio
    //hay uns cosa llamada cors CORS: una regla de seguridad de los navegadores que
    // dice "un sitio web no puede pedir datos
    // libremente a otro sitio distinto, a menos que ese otro sitio lo permita


        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
        }

}
