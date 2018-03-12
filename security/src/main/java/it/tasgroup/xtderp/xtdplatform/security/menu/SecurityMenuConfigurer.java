package it.tasgroup.xtderp.xtdplatform.security.menu;

import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuBuilder;
import it.tasgroup.xtderp.xtdplatform.infrastructure.menu.model.MenuConfigurer;
import it.tasgroup.xtderp.xtdplatform.security.entity.Permission;
import it.tasgroup.xtderp.xtdplatform.security.entity.Role;
import it.tasgroup.xtderp.xtdplatform.security.entity.User;

public class SecurityMenuConfigurer implements MenuConfigurer {

    @Override
    public void configure(MenuBuilder menuBuilder) {
/*
        menuBuilder.add("", new JpaCrudAction(User.class));
        menuBuilder.add("", new JpaCrudAction(Role.class));
        menuBuilder.add("", new JpaCrudAction(Permission.class));
*/
    }
}
