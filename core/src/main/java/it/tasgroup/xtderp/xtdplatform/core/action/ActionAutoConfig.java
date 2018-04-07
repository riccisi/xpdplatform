package it.tasgroup.xtderp.xtdplatform.core.action;

import it.tasgroup.xtderp.xtdplatform.core.action.service.ActionExecutionService;
import it.tasgroup.xtderp.xtdplatform.core.action.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
@SuppressWarnings("DesignForExtension")
public class ActionAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public Actions actions(final List<ActionConfigurer> configurers) {
        return new CachedActions(new ConfigurableActions(configurers));
    }

    @Bean
    public ActionDecorator decorator() {
        return new DefaultDecoratorStack();
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionLookup actionLookup(final Actions actions, final List<ActionDecorator> decorators) {
        return new DecoratedActionLookup(new DefaultActionLookup(actions), decorators);
    }

    @Bean
    public ActionService actionService(final Actions actions) {
        return new ActionService(actions);
    }

    @Bean
    public ActionExecutionService actionExecutionService(final ActionLookup lookup) {
        return new ActionExecutionService(lookup);
    }

}