package it.tasgroup.xtderp.xtdplatform.metadata.query.filter;

import java.util.Collection;
import java.util.List;

public interface Statement {

    Statement and(Filter... filters);

    Statement and(List<Filter> filters);

    Statement or(Filter... filters);

    Statement or(List<Filter> filters);

    Statement eq(String property, Object value);

    Statement notEq(String property, Object value);

    Statement like(String property, String value);

    Statement notLike(String property, String value);

    Statement gt(String property, Comparable value);

    Statement gte(String property, Comparable value);

    Statement lt(String property, Comparable value);

    Statement lte(String property, Comparable value);

    Statement in(String property, Collection value);

    Statement notIn(String property, Collection value);

    Statement isNull(String property);

    Statement isNotNull(String property);

    Statement orderAscending(String property);

    Statement orderDescending(String property);
}