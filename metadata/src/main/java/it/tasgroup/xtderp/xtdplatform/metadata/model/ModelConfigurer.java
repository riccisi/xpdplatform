package it.tasgroup.xtderp.xtdplatform.metadata.model;

public interface ModelConfigurer {

    ModelConfigurer EMPTY = modelRegister -> {};

    void configure(ModelRegister modelRegister);
}