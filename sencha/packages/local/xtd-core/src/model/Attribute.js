/**
 * This class is the base for modelattributes.
 * @protected
 */
Ext.define('Xtd.core.model.Attribute', {
    mixins: [
        'Ext.mixin.Factoryable'
    ],

    factoryConfig: {
        type: 'attribute',
        defaultType: 'string'
    },

    config: {
        name: null,
        text: null
    },

    getModelFieldConf: function() {
        return {
            name: this.getName(),
            mapping: this.getName(),
            allowNull: true
        };
    },

    getGridColumnConf: function() {
        return {
            text: this.getText(),
            dataIndex: this.getName()
        }
    },

    getColumnFilterConf: Ext.emptyFn,

    getFieldConf: function() {
        return {
            fieldLabel: this.getText()
        }
    }
});