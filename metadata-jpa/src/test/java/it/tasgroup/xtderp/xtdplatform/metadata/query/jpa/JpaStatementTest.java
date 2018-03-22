package it.tasgroup.xtderp.xtdplatform.metadata.query.jpa;

import org.junit.Test;

public class JpaStatementTest {

    @Test
    public void and() {

        JpaStatement<Object> stmt = new JpaStatement<>();

        stmt.eq("a","b")
            .eq("c","e")
            .and(stm2 -> stm2.eq("a", "v")
                             .like("a", "b")
                             .isNull("test")
        );
        System.out.println("stmt = " + stmt);
    }
}