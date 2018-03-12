package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class ActionAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public Actions actions(List<ActionConfigurer> configurers) {
        return new CachedActions(new ConfigurableActions(configurers));
    }

    @Bean
    public ActionDecorator decorator() {
        return new DefaultDecoratorStack();
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionLookup actionLookup(Actions actions, List<ActionDecorator> decorators) {
        return new DecoratedActionLookup(new DefaultActionLookup(actions), decorators);
    }

    @Bean
    public ActionService actionService(Actions actions, ActionLookup lookup) {
        return new ActionService(actions, lookup);
    }

}