package config;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "SerieBobEsponja.BobEsponja" //EN que classes se aplican pundre a todos
)
public class Mysqlconfig {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource") // En el propertie agarra los valores que tengan spring.datsource
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
}
