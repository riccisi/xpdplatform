package it.tasgroup.xtderp.xtdplatform.prototype;

import it.tasgroup.xtderp.xtdplatform.admin.entity.Permission;
import it.tasgroup.xtderp.xtdplatform.admin.entity.Role;
import it.tasgroup.xtderp.xtdplatform.admin.entity.User;
import it.tasgroup.xtderp.xtdplatform.admin.repository.RoleRepository;
import it.tasgroup.xtderp.xtdplatform.admin.repository.UserRepository;
import it.tasgroup.xtderp.xtdplatform.core.util.StringAsDate;
import it.tasgroup.xtderp.xtdplatform.prototype.model.Customer;
import it.tasgroup.xtderp.xtdplatform.prototype.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "it.tasgroup.xtderp.xtdplatform.prototype.model")
@EnableJpaRepositories(basePackages = "it.tasgroup.xtderp.xtdplatform.prototype.repository")
@SuppressWarnings("DesignForExtension")
public class PrototypeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return super.configure(application).sources(PrototypeApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(PrototypeApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(final CustomerRepository customers, final UserRepository users, final RoleRepository roles) {
        return args -> {
            final Role admin = roles.save(new Role("admin", new Permission("all")));
            users.save(new User("admin", "admin", "Administrator", admin));

            customers.save(new Customer("Jack", "Bauer", new StringAsDate("dd/MM/yyyy","21/09/1973").value(),null));
            customers.save(new Customer("Chloe", "O'Brian", new StringAsDate("dd/MM/yyyy","01/03/1938").value(),null));
            customers.save(new Customer("Kim", "Bauer", new StringAsDate("dd/MM/yyyy","13/02/1960").value(),null));
            customers.save(new Customer("David", "Palmer", new StringAsDate("dd/MM/yyyy","05/05/1998").value(),null));
            customers.save(new Customer("Michelle", "Dessler", new StringAsDate("dd/MM/yyyy","12/11/1983").value(),null));
        };
    }

}