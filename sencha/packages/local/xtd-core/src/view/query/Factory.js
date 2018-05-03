Ext.define('Xtd.core.view.query.Factory', {
    mixins: [
        'Ext.mixin.Factoryable'
    ],

    alias: 'uifactory.query',

    factoryConfig: {
        type: 'idfactory',
        defaultType: 'default'
    },

    build: function() {

    }

});

/**
 * if(!modelClass) {
            Ext.raise('modelClass should be not null');
        }
 var gridId = "model-grid-" + modelClass.replace(/\./g, '_');
 var widget = Ext.getCmp(gridId);
 if (!widget) {
            widget = Ext.widget('search-panel', Ext.apply({
                id: gridId,
                modelClass: modelClass
            }, conf));
        }
 return widget;
 **/