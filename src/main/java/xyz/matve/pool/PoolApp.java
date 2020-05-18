package xyz.matve.pool;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "xyz.matve.pool.repos")
@EntityScan(basePackages="xyz.matve.pool.models")
public class PoolApp {
    public static void main(String[] args) {
        SpringApplication.run(PoolApp.class, args);
    }
}