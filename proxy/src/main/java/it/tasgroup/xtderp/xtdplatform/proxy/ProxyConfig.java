package it.tasgroup.xtderp.xtdplatform.proxy;

import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.Menu;
import it.tasgroup.xtderp.xtdplatform.proxy.menu.AggregatedMenu;
import it.tasgroup.xtderp.xtdplatform.proxy.menu.DiscoverableMenus;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {

    @Bean
    public Menu getMenu(DiscoveryClient discoveryClient, LoadBalancerClient loadBalancerClient) {
        return new AggregatedMenu(new DiscoverableMenus(discoveryClient, loadBalancerClient));
    }
}