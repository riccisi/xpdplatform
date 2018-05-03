Ext.define('Xtd.core.store.ModelMetadata', {
    extend: 'Ext.data.Store',

    alias: 'store.modelMetadata',

    model: 'Xtd.core.model.ModelMetadata',

    pageSize: 0,

    proxy: {
        type: 'rest',
        url: Xtd.core.EndPoint.url('metadata'),
        reader: {
            type: 'json'
        }
    },

    listeners: {
        load: function(me, modelsMetadata) {
            Ext.each(modelsMetadata, function(modelMetadata) {
                modelMetadata.defineModel();
            });
        }
    }
});