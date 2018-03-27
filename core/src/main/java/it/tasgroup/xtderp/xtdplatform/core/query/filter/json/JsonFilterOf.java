package it.tasgroup.xtderp.xtdplatform.core.query.filter.json;

import com.fasterxml.jackson.databind.JsonNode;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.cactoos.collection.Filtered;
import org.cactoos.list.ListOf;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @version $Id$
 * @since 1.0
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonFilterOf implements Filter {

    private final Collection<FilterMatcher> matchers;
    private final JsonNode node;

    public JsonFilterOf(JsonNode node) {
        this(
            new Filtered<>(
                FilterMatcher::match,
                new ListOf<>(
                    new JsonAnd.Matcher(node),
                    new JsonOr.Matcher(node),
                    new JsonEq.Matcher(node),
                    new JsonNotEq.Matcher(node),
                    new JsonLike.Matcher(node),
                    new JsonLt.Matcher(node),
                    new JsonLte.Matcher(node),
                    new JsonGt.Matcher(node),
                    new JsonGte.Matcher(node),
                    new JsonIn.Matcher(node),
                    new JsonNotIn.Matcher(node)
                )
            ),
            node
        );
    }

    @Override
    public void applyOn(Statement stmt) {
        this.matchedFilter().applyOn(stmt);
    }

    private Filter matchedFilter() {
        try {
            return this.matchers.iterator().next().matched();
        } catch (NoSuchElementException e) {
            throw new RuntimeException(String.format("No matched filters to node %s, check your json request!", node));
        }
    }
}