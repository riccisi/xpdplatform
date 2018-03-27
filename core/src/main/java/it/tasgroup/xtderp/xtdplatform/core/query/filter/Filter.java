package it.tasgroup.xtderp.xtdplatform.core.query.filter;

/**
 * A {@link Filter} represent a constrained matched to dynamically build a query.
 * Its implementation can be simple or composite.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Filter {

    void applyOn(Statement stmt);

    /**
     * Fake Filter implementation class for testing purpose.
     */
    final class Fake implements Filter {

        @Override
        public void applyOn(Statement stmt) {
        }
    }
}