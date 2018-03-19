package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Printable {

    /**
     *
     * @param media
     * @param <R>
     * @return
     */
    <R> Rendered<R> print(Media<R> media);

    /**
     * Fake Printable implementation class for testing purpose.
     */
    final class Fake implements Printable {

        @Override
        public <R> Rendered<R> print(Media<R> media) {
            return media.asObject().with("prop","value");
        }
    }
}
