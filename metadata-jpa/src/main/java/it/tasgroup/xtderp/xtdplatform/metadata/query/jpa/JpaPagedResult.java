package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.PrintableCollection;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class JpaPagedResult<T> implements Printable {

    @NonNull private final Page<T> page;
    @NonNull private final EntityMetadata<T> metadata;
    @NonNull private final EntityManager entityManager;

    @Override
    public <R> Rendered<R> print(Media<R> media) {
        return media.asObject()
            .with("total", this.page.getTotalElements())
            .with("result", new PrintableCollection(this.page.getContent(), t -> new JpaEntity<T>(t, this.metadata, this.entityManager)));
    }
}
