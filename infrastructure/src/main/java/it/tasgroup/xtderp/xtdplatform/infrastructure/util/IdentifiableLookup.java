package it.tasgroup.xtderp.xtdplatform.infrastructure.util;

public interface IdentifiableLookup<Identified> {

    Identified get(String id);
}
