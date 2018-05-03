
Ext.define('Xtd.core.model.StringField', {
    extend: 'Xtd.core.model.Attribute',
    mixins: [
        'Ext.mixin.Factoryable'
    ],
    alias: 'attribute.string',

    getModelFieldConf: function() {
        return Ext.apply(this.callParent(), { type: 'string' });
    },

    getGridColumnConf: function() {
        return Ext.apply(this.callParent(), { });
    },

    getColumnFilterConf: function() {
        return {
            filter: {
                type: 'string'
            }
        };
    },

    getFieldConf: function() {
        return Ext.apply(this.callParent(), { xtype: 'textfield' });
    }

});