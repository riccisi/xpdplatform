package it.tasgroup.xtderp.xtdplatform.metadata.model;

public interface Model extends Iterable<Attribute> {

    String id();

    ProcessedModel process();

}