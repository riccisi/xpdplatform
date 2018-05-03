package it.tasgroup.xtderp.xtdplatform.proxy;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.menu.Menu;
import it.tasgroup.xtderp.xtdplatform.proxy.menu.AggregatedMenu;
import it.tasgroup.xtderp.xtdplatform.proxy.menu.DiscoverableMenus;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("DesignForExtension")
public class ProxyConfig {

    @Bean
    public Menu getMenu(final DiscoveryClient discoveryClient, final LoadBalancerClient loadBalancerClient, final I18n i18n) {
        return new AggregatedMenu(new DiscoverableMenus(discoveryClient, loadBalancerClient), i18n);
    }
}