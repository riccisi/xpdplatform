package it.tasgroup.xtderp.xtdplatform.proxy.menu;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.Menu;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuNode;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Menu implementation that returns the menu from a remote service.
 */
@RequiredArgsConstructor
public class ServiceMenu implements Menu {

    private final String service;

    private final LoadBalancerClient loadBalancerClient;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackIterator")
    public Iterator<MenuNode> iterator() {
        ServiceInstance instance = this.loadBalancerClient.choose(this.service);
        URI uri = instance.getUri();
        MenuNode[] nodes = new RestTemplate().getForObject(uri.resolve("/menu"), MenuNode[].class);
        return Arrays.asList(nodes).iterator();
    }

    public Iterator<MenuNode> fallbackIterator() {
        return Collections.emptyIterator();
    }
}
