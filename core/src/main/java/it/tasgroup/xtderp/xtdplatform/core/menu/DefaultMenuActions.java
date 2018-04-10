package it.tasgroup.xtderp.xtdplatform.core.menu;

import it.tasgroup.xtderp.xtdplatform.core.action.Actions;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterator.Filtered;
import org.cactoos.iterator.Mapped;

import java.util.Iterator;

/**
 * <p>Default {@link MenuActions} implementation that iterate only over {@link MenuAction}.</p>
 *
 * <p>The class is immutable and thread-safe.</p>
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class DefaultMenuActions implements MenuActions {

    @NonNull private final Actions actions;

    @Override
    public Iterator<MenuAction> iterator() {
        return
            new Mapped<>(
                MenuAction.class::cast,
                new Filtered<>(
                    input -> MenuAction.class.isAssignableFrom(input.getClass()),
                    this.actions.iterator()
                )
            );
    }
}