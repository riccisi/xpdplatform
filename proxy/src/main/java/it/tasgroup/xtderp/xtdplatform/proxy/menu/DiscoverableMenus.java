package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.core.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Menus implementation that returns a collection of discovered ServiceMenu.
 */
@RequiredArgsConstructor
public class DiscoverableMenus implements Menus {

    private final DiscoveryClient discoveryClient;

    private final LoadBalancerClient loadBalancerClient;

    @Override
    public final Iterator<Menu> iterator() {
        final Collection<Menu> menus = new ArrayList<>();
        final List<String> services = this.discoveryClient.getServices();
        for (final String service : services) {
            menus.add(new ServiceMenu(service, this.loadBalancerClient));
        }
        return menus.iterator();
    }
}