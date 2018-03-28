package it.tasgroup.xtderp.xtdplatform.core.metadata;

public interface MetadataLookup {

    ModelMetadata get(String id) throws Exception;

    final class Fake implements MetadataLookup {

        @Override
        public ModelMetadata get(final String id) {
            return new ModelMetadata.Fake(id);
        }
    }
}