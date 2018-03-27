package it.tasgroup.xtderp.xtdplatform.core.metadata;

public interface MetadataLookup {

    ModelMetadata get(String modelId) throws Exception;

    final class Fake implements MetadataLookup {

        @Override
        public ModelMetadata get(String modelId) throws Exception {
            return new ModelMetadata.Fake(modelId);
        }
    }
}
