package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

import java.util.Optional;

public interface Request<T> {

    Request EMPTY = Optional::empty;

    T value() throws Exception;
}