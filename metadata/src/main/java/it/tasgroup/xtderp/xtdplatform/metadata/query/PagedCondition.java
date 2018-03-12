package it.tasgroup.xtderp.xtdplatform.metadata.query;

public interface PagedCondition extends Condition {

    int page();

    int limit();
}
