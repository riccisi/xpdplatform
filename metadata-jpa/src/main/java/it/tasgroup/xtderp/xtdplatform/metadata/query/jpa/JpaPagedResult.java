package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Printable;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.PrintableCollection;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.metadata.model.EntityMetadata;
import it.tasgroup.xtderp.xtdplatform.metadata.model.jpa.JpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
public class JpaPagedResult<T> implements Printable {

    private final Page<T> page;

    private final EntityMetadata<T> metadata;

    @Override
    public Rendered print(Media media) {
        return media.asObject()
            .with("total", this.page.getTotalElements())
            .with("result", new PrintableCollection(this.page.getContent(), t -> new JpaEntity<T>(t, this.metadata)));
    }
}
