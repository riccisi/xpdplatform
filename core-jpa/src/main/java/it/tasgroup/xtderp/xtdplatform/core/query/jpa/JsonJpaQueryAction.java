package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuAction;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import it.tasgroup.xtderp.xtdplatform.core.query.action.JsonQueryAction;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class JsonJpaQueryAction implements MenuAction {

    @NonNull private final Action delegate;
    @NonNull private final Class<?> cls;

    public JsonJpaQueryAction(final Class<?> cls, final EntityManager manager, final I18n i18n) {
        this(new JsonQueryAction(new JpaPaginatedQuery<>(cls, manager, i18n)), cls);
    }

    @Override
    public String path() {
        return
            this.cls.isAnnotationPresent(XtdMenu.class) ?
                this.cls.getAnnotation(XtdMenu.class).value() :
                this.cls.getSimpleName();
    }

    @Override
    public int order() {
        return this.cls.isAnnotationPresent(XtdMenu.class) ? this.cls.getAnnotation(XtdMenu.class).order() : 0;
    }

    @Override
    public String uid() {
        return "query";
    }

    @Override
    public Result execute(final Request request) throws Exception {
        return this.delegate.execute(request);
    }

    @Override
    public <R> Rendered<R> print(final Media<R> media) throws Exception {
        return this.delegate.print(media);
    }

    @Override
    public String id() {
        return this.delegate.id();
    }
}