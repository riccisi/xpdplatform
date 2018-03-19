package it.tasgroup.xtderp.xtdplatform.metadata.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;

/**
 * Represent an attribute of the model. Cold be a {@link Field}, a {@link Relation}...
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public interface Attribute extends Printable {

    String name();

    <R,T> RenderedObject<R> printValue(T entity, RenderedObject<R> rendered);
}