package it.tasgroup.xtderp.xtdplatform.metadata.query;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Action;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Request;
import it.tasgroup.xtderp.xtdplatform.infrastructure.action.Result;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import lombok.RequiredArgsConstructor;

/**
 * Abstract delegate template
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor
abstract class JsonRequestDecorator<T> implements Action<JsonNode, Media> {

    private final Action<T,Media> delegate;

    @Override
    public final Result<Media> execute(Request<JsonNode> request) throws Exception {
        return this.delegate.execute(decorate(request));
    }

    @Override
    public final void print(Media media) {
        this.delegate.print(media);
    }

    @Override
    public final String id() {
        return this.delegate.id();
    }

    protected abstract Request<T> decorate(Request<JsonNode> request);
}
