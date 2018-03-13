package it.tasgroup.xtderp.xtdplatform.infrastructure.action.model;

import it.tasgroup.xtderp.xtdplatform.infrastructure.action.*;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Media;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.infrastructure.media.RenderedObject;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Test case for {@link DecoratedActionLookup}.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
public class DecoratedActionLookupTest {

    private Action<Integer,Writer> sum;

    @Before
    public void init() throws ActionNotFoundException {
        DecoratedActionLookup lookup = new DecoratedActionLookup(
            id -> new SumAction(5),
            OnlyPositive::new, action -> new LessThan(action, 10)
        );
        this.sum = lookup.get("sum");
    }

    @Test
    public void testValidSum() throws Exception {
        StringWriter writer = new StringWriter();
        sum.execute(() -> 1).writeOn(writer);
        assertThat(writer.toString(), equalTo("6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidByFirstDecorator() throws Exception {
        sum.execute(() -> -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBySecondDecorator() throws Exception {
        sum.execute(() -> 11);
    }

    @RequiredArgsConstructor
    class SumAction implements Action<Integer,Writer> {

        private final int base;

        @Override
        public Result<Writer> execute(Request<Integer> request) throws Exception {
            final int sum = base + request.value();
            return media -> {
                media.write(""+sum);
            };
        }

        @Override
        public String id() {
            return "sum";
        }

        @Override
        public <T> Rendered<T> print(Media<T> media) {
            throw new UnsupportedOperationException("#print()");
        }
    }

    @RequiredArgsConstructor
    class OnlyPositive implements Action<Integer,Writer> {

        private final Action<Integer,Writer> delegate;

        @Override
        public Result<Writer> execute(Request<Integer> request) throws Exception {
            if(request.value() < 0) {
                throw new IllegalArgumentException("Only positive numbers!");
            }
            return this.delegate.execute(request);
        }

        @Override
        public String id() {
            throw new UnsupportedOperationException("#id()");
        }

        @Override
        public <T> Rendered<T> print(Media<T> media) {
            throw new UnsupportedOperationException("#print()");
        }
    }

    @RequiredArgsConstructor
    class LessThan implements Action<Integer,Writer> {

        private final Action<Integer,Writer> delegate;

        private final int limit;

        @Override
        public Result<Writer> execute(Request<Integer> request) throws Exception {
            Integer value = request.value();
            if(value > this.limit) {
                throw new IllegalArgumentException(String.format("Value must be less than %s", value));
            }
            return this.delegate.execute(request);
        }

        @Override
        public String id() {
            throw new UnsupportedOperationException("#id()");
        }

        @Override
        public <T> Rendered<T> print(Media<T> media) {
            throw new UnsupportedOperationException("#print()");
        }
    }
}