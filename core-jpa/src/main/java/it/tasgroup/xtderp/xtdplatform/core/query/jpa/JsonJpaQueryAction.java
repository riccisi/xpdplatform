package it.tasgroup.xtderp.xtdplatform.core.query.jpa;

import it.tasgroup.xtderp.xtdplatform.core.action.Action;
import it.tasgroup.xtderp.xtdplatform.core.action.ActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.action.Request;
import it.tasgroup.xtderp.xtdplatform.core.action.Result;
import it.tasgroup.xtderp.xtdplatform.core.action.SimpleActionCoordinate;
import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.media.Media;
import it.tasgroup.xtderp.xtdplatform.core.media.Rendered;
import it.tasgroup.xtderp.xtdplatform.core.menu.MenuAction;
import it.tasgroup.xtderp.xtdplatform.core.metadata.annotation.XtdMenu;
import it.tasgroup.xtderp.xtdplatform.core.query.Query;
import it.tasgroup.xtderp.xtdplatform.core.query.action.JsonQueryAction;
import lombok.NonNull;
import org.cactoos.map.MapEntry;
import org.cactoos.map.MapOf;

import javax.persistence.EntityManager;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
public final class JsonJpaQueryAction implements MenuAction {

    @NonNull private final Query query;
    @NonNull private final Action delegate;
    @NonNull private final Class<?> cls;

    public JsonJpaQueryAction(final Class<?> cls, final EntityManager manager, final I18n i18n) {
        this.query = new JpaPaginatedQuery<>(cls, manager, i18n);
        this.delegate = new JsonQueryAction(this.query);
        this.cls = cls;
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
    public ActionCoordinate coordinate() {
        return new SimpleActionCoordinate(this.id(), "query", new MapOf<>(new MapEntry<>("modelId", this.query.modelId())));
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
        return this.query.id();
    }
}