package it.tasgroup.xtderp.xtdplatform.core.metadata.action;

import it.tasgroup.xtderp.xtdplatform.core.action.ActionConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.action.ActionRegister;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntitiesMetadata;
import it.tasgroup.xtderp.xtdplatform.core.metadata.Entity;
import it.tasgroup.xtderp.xtdplatform.core.metadata.EntityMetadata;
import lombok.RequiredArgsConstructor;

/**
 * <p>{@link ActionConfigurer} used to automatically register all the predefined necessaries actions to work
 * with an {@link Entity} </p>
 *
 * <p>The class is immutable and thread-safe.</p>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class EntityActionConfigurer implements ActionConfigurer {

    private final EntitiesMetadata metadata;

    @Override
    public void configure(final ActionRegister register) {
        for (final EntityMetadata meta : this.metadata) {
            register.add(new CreateEntityAction(meta));
            register.add(new ReadEntityAction(meta));
        }
    }
}