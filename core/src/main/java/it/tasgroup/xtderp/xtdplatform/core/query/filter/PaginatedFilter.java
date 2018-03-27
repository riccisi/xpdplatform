package it.tasgroup.xtderp.xtdplatform.core.query.filter;

/**
 * It's essentially a {@link Filter} that provide also pagination instructions.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface PaginatedFilter extends Filter {

    int page();

    int limit();
}