package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

public interface Media<T> {

    RenderedObject<T> object();

    RenderedList<T> list();
}
