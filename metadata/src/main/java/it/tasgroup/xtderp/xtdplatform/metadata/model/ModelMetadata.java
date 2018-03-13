package it.tasgroup.xtderp.xtdplatform.metadata.model;

public interface ModelMetadata extends Iterable<Attribute> {

    String id();

    ProcessedModel process();

}