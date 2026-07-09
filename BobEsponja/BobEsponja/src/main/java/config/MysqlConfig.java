package SerieBobEsponja.BobEsponja.Config;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Profile("mysql") // Opcional pero en caso de tener mas  de una bd especificar cual bd utiliar
@EnableJpaRepositories(//ESTA ANOTACION NOS SIRVE PARA PODER ESPCIFICAR  QUE CLASES PUEDEN ABIRR CONEXION CON LA BD
        basePackages = "SerieBobEsponja.BobEsponja.bds.FondoBikini", //EN que classes se aplican pundre a todos
entityManagerFactoryRef = "primaryEntityManagerFactory",
transactionManagerRef = "primaryTransactionManager"
)
public class MysqlConfig {
   /* @Bean // Nos creara un objeto Myqlconfig con las creenciales
    @Primary //Esto se le especifica que estra seta como la bd por defecto(Agarra las credneciales de las bds)
    @ConfigurationProperties("spring.datasource") // En el propertie agarra los valores que tengan spring.datsource
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    } // Guarda las credenciales*/

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties("spring.datasource") // Agarra spring.datasource.*
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            @Qualifier("primaryDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        // ¡Clave! Escanea ÚNICAMENTE las entidades de Fondo de Bikini
        em.setPackagesToScan("SerieBobEsponja.BobEsponja.bds.FondoBikini");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
