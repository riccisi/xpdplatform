Ext.define('Xtd.core.view.query.Factory', {
    extends: 'Xtd.core.view.UIFactory',
    requires: [
        'Xtd.core.view.query.View'
    ],
    mixins: [
        'Ext.mixin.Factoryable'
    ],

    alias: 'uifactory.query',

    build: function(conf) {
        var modelId = conf.modelId;
        var id = "query-" + modelId.replace(/\./g, '_');
        var widget = Ext.getCmp(id);
        if (!widget) {
            widget = Ext.widget('query', Ext.apply({ id: id }, conf));
        }
        return widget;
    }

});