package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

public interface Printable {

    <T extends Rendered> T print(Media<T> media);
}
