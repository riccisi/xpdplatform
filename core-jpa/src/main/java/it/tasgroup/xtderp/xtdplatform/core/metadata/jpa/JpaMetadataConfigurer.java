package it.tasgroup.xtderp.xtdplatform.core.metadata.jpa;

import it.tasgroup.xtderp.xtdplatform.core.localization.I18n;
import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataConfigurer;
import it.tasgroup.xtderp.xtdplatform.core.metadata.MetadataRegister;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@Log
@RequiredArgsConstructor
public final class JpaMetadataConfigurer implements MetadataConfigurer {

    @NonNull private final EntityManager entityManager;
    @NonNull private final I18n i18n;

    @Override
    @SuppressWarnings("unchecked")
    public void configure(final MetadataRegister register) {
        final Set<EntityType<?>> types = this.entityManager.getMetamodel().getEntities();
        for (final EntityType<?> type : types) {
            final Class<?> entityClass = type.getJavaType();
            register.add(new JpaEntityMetadata(this.entityManager, entityClass, this.i18n));
            log.info(String.format("Entity %s successfully registered!", entityClass));
        }
    }
}