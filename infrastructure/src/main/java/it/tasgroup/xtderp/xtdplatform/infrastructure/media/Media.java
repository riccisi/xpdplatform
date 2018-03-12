package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

public interface Media<T extends Rendered> {

    RenderedObject object();

    RenderedList list();
}
