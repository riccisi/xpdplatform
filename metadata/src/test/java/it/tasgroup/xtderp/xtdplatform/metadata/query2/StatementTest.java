package it.tasgroup.xtderp.xtdplatform.metadata.query2;

import it.tasgroup.xtderp.xtdplatform.metadata.query.filter.Statement;
import org.junit.Test;

public class StatementTest {

    @Test
    public void and() {
        Statement st = null;

        /*

        st.and(
            st.eq().and().,
            st.eq().and()
        ).or(
            st.notEq()
        )
         */

        Stmt stmt = null;

        stmt.where().eq().and().eq().or().eq();

    }

    interface Stmt {

        StmtExpression where();
    }

    interface StmtGroup {

        StmtExpression and();

        StmtExpression or();
    }

    interface StmtExpression {

        StmtGroup eq();

        StmtGroup notEq();
    }
}
