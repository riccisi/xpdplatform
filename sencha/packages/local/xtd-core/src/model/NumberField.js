
Ext.define('Xtd.core.model.NumberField', {
    extend: 'Xtd.core.model.Attribute',
    mixins: [
        'Ext.mixin.Factoryable'
    ],
    alias: 'attribute.number',

    getModelFieldConf: function() {
        return Ext.apply(this.callParent(), { type: 'int' });
    },

    getGridColumnConf: function() {
        return Ext.apply(this.callParent(), {
            xtype: 'numbercolumn',
            align: 'right',
            format: '0'
        });
    },

    getColumnFilterConf: function() {
        return {
            xtype: 'numberfield',
            allowDecimals: false
        };
    },

    getFieldConf: function() {
        return {
            filter: {
                type: 'number'
            }
        };
    }

});