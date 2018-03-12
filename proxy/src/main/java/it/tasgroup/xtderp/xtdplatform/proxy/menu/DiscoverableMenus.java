package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.util.ArrayList;
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
    public Iterator<Menu> iterator() {
        List<Menu> menus = new ArrayList<>();
        List<String> services = this.discoveryClient.getServices();
        for (String service : services) {
            menus.add(new ServiceMenu(service, loadBalancerClient));
        }
        return menus.iterator();
    }
}
