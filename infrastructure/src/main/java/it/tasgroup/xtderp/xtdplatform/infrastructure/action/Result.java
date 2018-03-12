package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

public interface Result<T> {

    Result EMPTY = media -> {};

    void printOn(T out) throws Exception;
}