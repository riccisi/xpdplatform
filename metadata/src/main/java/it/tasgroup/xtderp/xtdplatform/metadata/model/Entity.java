package it.tasgroup.xtderp.xtdplatform.metadata.model;

import java.io.Serializable;

public interface Entity<T> extends Model {

    Serializable idOf(T entity);

    void save(T entity);

    void delete(T entity);

}