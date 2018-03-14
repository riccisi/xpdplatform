package it.tasgroup.xtderp.xtdplatform.infrastructure.media;

public interface Printable {

    Printable EMPTY = new Printable() {
        @Override
        public <T> Rendered<T> print(Media<T> media) {
            return media.asNull();
        }
    };

    <R> Rendered<R> print(Media<R> media);
}
