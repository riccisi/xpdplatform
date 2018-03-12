package it.tasgroup.xtderp.xtdplatform.infrastructure.action;

public interface ActionLookup {
    
    Action get(String id) throws ActionNotFoundException;
}
