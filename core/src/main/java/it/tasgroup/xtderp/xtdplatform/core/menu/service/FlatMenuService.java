package it.tasgroup.xtderp.xtdplatform.core.menu.service;

import it.tasgroup.xtderp.xtdplatform.core.menu.FlatMenu;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuItem;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("menu/flat")
public final class FlatMenuService {

    @NonNull private final FlatMenu menu;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<MenuItem> get() {
        return this.menu;
    }
}