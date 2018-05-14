package it.tasgroup.xtderp.xtdplatform.admin.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@Configuration
@EnableResourceServer
@SuppressWarnings("DesignForExtension")
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources.resourceId(this.resourceIds).tokenServices(this.tokenServices);
    }

    @Override
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public void configure(final HttpSecurity http) throws Exception {
        http
            .requestMatchers()
            .and()
            .authorizeRequests()
            .antMatchers(
                //HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/**/*.ttf",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.png",
                "/**/classic.json",
                "/**/bootstrap.json",
                "/**/modern.json"
            ).permitAll()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated();
    }
}
