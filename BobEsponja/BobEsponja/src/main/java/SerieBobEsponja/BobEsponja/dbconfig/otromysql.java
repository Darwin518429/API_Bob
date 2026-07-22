package SerieBobEsponja.BobEsponja.dbconfig;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration

@Profile("otro")
@EnableJpaRepositories(
        basePackages = "SerieBobEsponja.BobEsponja.bds.test",
        entityManagerFactoryRef = "testEntityManagerFactory",
        transactionManagerRef = "testTransactionManager"
)
public class otromysql {
    @Value("${mysql.jpa.database-platform}")
    private String dialect;

    @Value("${spring.datasource.test.url}")
    private String url;

    @Value("${spring.datasource.test.username}")
    private String username;

    @Value("${spring.datasource.test.password}")
    private String password;

    @Value("${spring.datasource.driver-class-mysql}")
    private String driver;

    @Value("${mysql.jpa.database-platform}")
    private String dialecto;



    @Bean(name = "testDataSource") //Nombre para poder utilizarlo
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driver)
                .build();
    }

    @Bean(name = "testEntityManagerFactory") // Le  ponemos un nombre para poder utilizar ese bean
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            // Le especificaos cual data source debe de utilizar
            @Qualifier("testDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("SerieBobEsponja.BobEsponja.bds.test"); // Indicar por donde estan las classes entitys
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        em.setJpaVendorAdapter(adapter);
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", dialecto);
        em.setJpaProperties(props);

        return em;
    }

    @Bean(name = "testTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("testEntityManagerFactory") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }


}
