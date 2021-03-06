package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Printable;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;

/**
 * Represent an attribute of the metadata. Cold be a {@link Field}, a {@link Relation}...
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Attribute extends Printable {

    String name();

    <R,T> RenderedObject<R> printValue(T model, RenderedObject<R> rendered);

    @Override
    <R> RenderedObject<R> print(Media<R> media) throws Exception;
}