package it.tasgroup.xtderp.xtdplatform.core.metadata;

import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.media.RenderedObject;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;

public interface Field extends Attribute {

    Object parsedValue(String value) throws ParseException;

    /**
     * Fake {@link Field} implementation class for testing purpose.
     */
    @RequiredArgsConstructor
    final class Fake implements Field {

        private final String prop;
        private final String value;

        public Fake() {
            this("prop","value");
        }

        @Override
        public String name() {
            return this.prop;
        }

        @Override
        public <R, T> RenderedObject<R> printValue(final T model, final RenderedObject<R> rendered) {
            return rendered.with(this.prop,this.value);
        }

        @Override
        public <R> Rendered<R> print(final Media<R> media) {
            return media.asObject().with("name", this.prop).with("type","string");
        }

        @Override
        public Object parsedValue(String value) {
            throw new UnsupportedOperationException("#value()");
        }
    }
 }