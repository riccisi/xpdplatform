
Ext.define('Xtd.core.model.DateField', {
    extend: 'Xtd.core.model.Attribute',
    mixins: [
        'Ext.mixin.Factoryable'
    ],
    alias: 'attribute.date',

    getModelFieldConf: function() {
        return Ext.apply(this.callParent(), {
            type: 'date',
            dateFormat: 'Y-m-d\\TH:i:s.uO'
        });
    },

    getGridColumnConf: function() {
        return Ext.apply(this.callParent(), {
            xtype: 'datecolumn',
            align: 'center',
            format: 'd/m/Y',
            width: 120
        });
    },

    getColumnFilterConf: function() {
        return {
            xtype: 'datefield',
            format: 'd/m/Y'
        };
    },

    getFieldConf: function() {
        return {
            filter: {
                type: 'date'
            }
        };
    }

});