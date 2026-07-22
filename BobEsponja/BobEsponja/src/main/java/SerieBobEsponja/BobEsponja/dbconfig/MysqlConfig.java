package SerieBobEsponja.BobEsponja.dbconfig;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration // Indica que en esta classe hay objetos que Spring debe gestionar

@Profile("mysql") // Es opcional esto indica cual bd debe de conectarse para utilizarlo
@EnableJpaRepositories(//La anotacion sirve para pode concetarnos,escanear los paquetes y asignar factorys
        basePackages = "SerieBobEsponja.BobEsponja.bds.FondoBikini",  // Buscar  los Repositories para poder  hacer las consultas
        entityManagerFactoryRef = "primaryEntityManagerFactory", // Es el que gestiona cómo se ejecutan las consultas de los Repositories
transactionManagerRef = "primaryTransactionManager" // nos sirve para  que los repositoroes  de un paquete especifico utilize trnasacciones
)
public class MysqlConfig {
//La Data source son las credeniales que tenemos
    //@value sacamos losvalores de la properties
    @Value("${mysql.jpa.database-platform}")
    private String dialect;

    @Value("${spring.datasource.primary.url}")
    private String url;

    @Value("${spring.datasource.primary.username}")
    private String username;

    @Value("${spring.datasource.primary.password}")
    private String password;

    @Value("${spring.datasource.driver-class-mysql}")
    private String driver;

    @Value("${mysql.jpa.database-platform}")
    private String dialecto;
// Credenciales para  la bd
//Data source son las credenciales o datos que eestan relaionados con la conexion bd osea:
    /*
    * Usuario
    * Contraseñña
    * Url de la bd
    * */
    @Primary // Indica cual data soure sera por defecto
    @Bean(name = "primaryDataSource") //Nombre para poder utilizarlo
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }

// @bean guarda un metodo  que devuelve un objeto (al arrancar)  para poder ser utilizado mas aelante sin volve a ejecutarse
    @Primary //Especificamos cual data source deb utilizar por defecto en as ode que spring no sepa cual utilizar
    @Bean(name = "primaryEntityManagerFactory") // Le  ponemos un nombre para poder utilizar ese bean
    //este emtodod devuelve una clase de Spring que crea y configura el EntityManagerFactory.
    /*
    * LocalCOntaineENtityManafetFactorybean lo que hace es:
    * Agarrar el  DataSource (las credenciales).
Agarrar las carpetas/packages  (setPackagesToScan).
Agarrar a Hibernate (el motor SQL).
* Dialecto (La tecnologia exacta que utiliza la bd en  MYSQL)
    * */
    /*
    * El entity manager factory(LocalContainerEntityManagerFactoryBean)
    *  Junta los ocnfigurada o lo qure tien de propiedades y crea
    * el entitymanager
    *
    * Entity manager: objeto trabajador que tiene todo lo necesario
    * (las credenciales, las entidades y a Hibernate) para acceder a
    * la base de datos y ejecutar las acciones
    */
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            // Le especificaos cual data source debe de utilizar
            @Qualifier("primaryDataSource") DataSource dataSource) {
        //Creamos El objeto que nos servira para
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource); //Insertamamos el data source
        em.setPackagesToScan("SerieBobEsponja.BobEsponja.bds.FondoBikini"); // Indicar por donde estan las classes entitys
        //Creamos el traductor
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        //Indicamos que tipo de bd/gestor
        adapter.setDatabase(Database.MYSQL);
        // Imprime por el temrinal las consultas ejecutadas
        adapter.setShowSql(true);
        //Inseramos este hibernate en el factory entity
        em.setJpaVendorAdapter(adapter);
        //Creamos una propertie paraccedr una oina de cual es el dialecto que se debe de utilizaar
        //Es para especificar cual version del gestor utilizamo
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", dialecto);
        em.setJpaProperties(props);  //Se lo especifcamos al factory

        return em;
    }
//El PlatformTransactionManager Se encarga de mNanejar
// LAS TRANSACCIONS QUE ESTAN ABIERTAS Y HACER ROLLBACK A LAS TRANSACCIONES QUE FALLEN
    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("primaryEntityManagerFactory") EntityManagerFactory emf) { // Indicamos el entity factory
        //Debe  de tenerlo porque dbee de acceder a lab paracerrar o hacer cosas a las transacciones

        return new JpaTransactionManager(emf);
    }
}
