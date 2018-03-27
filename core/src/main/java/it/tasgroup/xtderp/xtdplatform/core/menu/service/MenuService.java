package it.tasgroup.xtderp.xtdplatform.core.menu.service;

import it.tasgroup.xtderp.xtdplatform.core.menu.model.Menu;
import it.tasgroup.xtderp.xtdplatform.core.menu.model.MenuNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/menu")
public class MenuService {

    private final Menu menu;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<MenuNode> get() {
        return this.menu;
    }

}