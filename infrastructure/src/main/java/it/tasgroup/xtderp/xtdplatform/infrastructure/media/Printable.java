package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

/**
 * A {@link Printable} object could be <i>printed</i> onto a {@link Media}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Printable {

    /**
     * {@link Printable} classes can print itself using the passed {@link Media} object.
     *
     * @param media the {@link Media} implementation.
     * @param <R> The type of the {@link Rendered} object;
     * @return the built {@link Rendered} object.
     */
    <R> Rendered<R> print(Media<R> media);

}