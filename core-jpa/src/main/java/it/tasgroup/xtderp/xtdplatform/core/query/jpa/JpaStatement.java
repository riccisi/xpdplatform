package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.query.filter.Filter;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.Statement;
import it.tasgroup.xtderp.xtdplatform.core.query.filter.json.LogicOperator;
import lombok.NonNull;
import org.cactoos.list.ListOf;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import static it.tasgroup.xtderp.xtdplatform.core.query.filter.json.LogicOperator.AND;
import static it.tasgroup.xtderp.xtdplatform.core.query.filter.json.LogicOperator.OR;

public final class JpaStatement<T> implements Statement {

    private Specifications<T> root = Specifications.where(null);

    private final AggregationStrategy<T> strategy;

    public JpaStatement() {
        this(AND);
    }

    public JpaStatement(final LogicOperator operator) {
        switch (operator) {
            case OR: this.strategy = new Or(); break;
            case AND: default: this.strategy = new And();
        }
    }

    @Override
    public Statement and(Filter... filter) {
        return this.and(new ListOf<>(filter));
    }

    @Override
    public Statement and(List<Filter> filters) {
        JpaStatement<T> jpaStatement = new JpaStatement<>();
        for (Filter filter : filters) {
            filter.applyOn(jpaStatement);
        }
        this.strategy.concat(jpaStatement.get());
        return this;
    }

    @Override
    public Statement or(Filter... filters) {
        return this.or(new ListOf<>(filters));
    }

    @Override
    public Statement or(List<Filter> filters) {
        JpaStatement<T> jpaStatement = new JpaStatement<T>(OR);
        for (Filter filter : filters) {
            filter.applyOn(jpaStatement);
        }
        this.strategy.concat(jpaStatement.get());
        return this;
    }

    @Override
    public Statement eq(@NonNull String property, @NonNull Object value) {
        this.strategy.concat((root, query, cb) -> cb.equal(this.pathOf(root, property), value));
        return this;
    }

    @Override
    public Statement notEq(@NonNull String property, @NonNull Object value) {
        this.strategy.concat((root, query, cb) -> cb.notEqual(this.pathOf(root, property), value));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement like(@NonNull String property, @NonNull String value) {
        this.strategy.concat((root, query, cb) -> cb.like(this.pathOf(root, property), "%" + value.toLowerCase() + "%"));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement notLike(@NonNull String property, @NonNull String value) {
        this.strategy.concat((root, query, cb) -> cb.notLike(this.pathOf(root, property), "%" + value.toLowerCase() + "%"));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement gt(@NonNull String property, @NonNull Comparable value) {
        this.strategy.concat((root, query, cb) -> cb.greaterThan(this.pathOf(root, property), value));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement gte(@NonNull String property, @NonNull Comparable value) {
        this.strategy.concat((root, query, cb) -> cb.greaterThanOrEqualTo(this.pathOf(root, property), value));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement lt(@NonNull String property, @NonNull Comparable value) {
        this.strategy.concat((root, query, cb) -> cb.lessThan(this.pathOf(root, property), value));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement lte(@NonNull String property, @NonNull Comparable value) {
        this.strategy.concat((root, query, cb) -> cb.lessThanOrEqualTo(this.pathOf(root, property), value));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement in(@NonNull String property, @NonNull Collection value) {
        this.strategy.concat((root, query, cb) -> value.size() > 0 ? this.pathOf(root, property).in(value) : null);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement notIn(@NonNull String property, @NonNull Collection value) {
        this.strategy.concat((root, query, cb) -> value.size() > 0 ? cb.not(this.pathOf(root, property).in(value)) : null);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement isNull(@NonNull String property) {
        this.strategy.concat((root, query, cb) -> cb.isNull(this.pathOf(root, property)));
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Statement isNotNull(@NonNull String property) {
        this.strategy.concat((root, query, cb) -> cb.isNotNull(this.pathOf(root, property)));
        return this;
    }

    @Override
    public Statement orderAscending(String property) {
        return null;
    }

    @Override
    public Statement orderDescending(String property) {
        return null;
    }

    public Specification<T> get() {
        return this.root;
    }

    private Path pathOf(Root<T> root, String name) {
        Path path = null;
        if (name.contains(".")) {
            for (StringTokenizer tt = new StringTokenizer(name, "."); tt.hasMoreTokens(); ) {
                String p = tt.nextToken();
                if (tt.hasMoreTokens()) {
                    path = path == null ? root.join(p) : ((Join) path).join(p);
                } else {
                    path = path == null ? root.get(p) : path.get(p);
                }
            }
        } else {
            path = root.get(name);
        }
        return path;
    }

    interface AggregationStrategy<T> {
        void concat(Specification<T> spec);
    }

    class And implements AggregationStrategy<T> {

        @Override
        public void concat(Specification<T> spec) {
            JpaStatement.this.root = JpaStatement.this.root.and(spec);
        }
    }

    class Or implements AggregationStrategy<T> {

        @Override
        public void concat(Specification<T> spec) {
            JpaStatement.this.root = JpaStatement.this.root.or(spec);
        }
    }
}
