package it.tasgroup.xtderp.xtdplatform.admin;

import it.tasgroup.xtderp.xtdplatform.admin.jpa.JpaUsers;
import it.tasgroup.xtderp.xtdplatform.admin.jpa.SpringSecurityAuditorAware;
import it.tasgroup.xtderp.xtdplatform.admin.repository.UserRepository;
import it.tasgroup.xtderp.xtdplatform.admin.security.XtdUserDetailService;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.localization.MultipleBundleMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.PostConstruct;

@Configuration
@EntityScan(basePackages = "it.tasgroup.xtderp.xtdplatform.admin.entity")
@EnableJpaRepositories(basePackages = "it.tasgroup.xtderp.xtdplatform.admin.repository")
@RequiredArgsConstructor
@SuppressWarnings("DesignForExtension")
public class AdminAutoConfig {

    private final MultipleBundleMessageSource messageSource;

    @PostConstruct
    public void init() {
        this.messageSource.addResource("admin");
    }

    @Bean
    @ConditionalOnMissingBean
    public Users users(final UserRepository repository) {
        return new JpaUsers(repository);
    }

    @Bean
    public UserDetailsService userDetailsService(final Users users, final I18n i18n) {
        return new XtdUserDetailService(users, i18n);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }
}