package it.tasgroup.xtderp.xtdplatform.prototype;

import it.tasgroup.xtderp.xtdplatform.infrastructure.util.StringAsDate;
import it.tasgroup.xtderp.xtdplatform.prototype.model.Customer;
import it.tasgroup.xtderp.xtdplatform.prototype.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrototypeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrototypeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer", new StringAsDate("dd/MM/yyyy","21/09/1973").value(),null));
            repository.save(new Customer("Chloe", "O'Brian", new StringAsDate("dd/MM/yyyy","01/03/1938").value(),null));
            repository.save(new Customer("Kim", "Bauer", new StringAsDate("dd/MM/yyyy","13/02/1960").value(),null));
            repository.save(new Customer("David", "Palmer", new StringAsDate("dd/MM/yyyy","05/05/1998").value(),null));
            repository.save(new Customer("Michelle", "Dessler", new StringAsDate("dd/MM/yyyy","12/11/1983").value(),null));
        };
    }

}