package config;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
@Profile("mysql") // Opcional pero en caso de tener mas  de una bd especificar cual bd utiliar
@EnableJpaRepositories(//ESTA ANOTACION NOS SIRVE PARA PODER ESPCIFICAR  QUE CLASES PUEDEN ABIRR CONEXION CON LA BD
        basePackages = "SerieBobEsponja.BobEsponja.bds.FondoBikini" //EN que classes se aplican pundre a todos
)
public class MysqlConfig {
    @Bean // Nos creara un objeto Myqlconfig con las creenciales
    @Primary //Esto se le especifica que estra seta como la bd por defecto(Agarra las credneciales de las bds)
    @ConfigurationProperties("spring.datasource") // En el propertie agarra los valores que tengan spring.datsource
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    } // Guarda las credenciales
}
