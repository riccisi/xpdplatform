package it.tasgroup.xtderp.xtdplatform.core.menu.model;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class AbstractMenuNode implements MenuNode {

    @NonNull private final String code;

    @Override
    public final String code() {
        return this.code;
    }

}