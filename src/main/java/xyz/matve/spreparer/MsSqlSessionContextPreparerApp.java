package xyz.matve.spreparer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "xyz.matve.pool.repos", repositoryBaseClass = SimpleJpaRepository.class)
@EntityScan(basePackages="xyz.matve.pool.models")
public class MsSqlSessionContextPreparerApp {
    public static void main(String[] args) {
        SpringApplication.run(MsSqlSessionContextPreparerApp.class, args);
    }

//
//    @Bean
//    @ConditionalOnMissingBean(type = "JpaTransactionManager")
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//
}