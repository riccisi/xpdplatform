Ext.define('Xtd.core.view.UIFactory', {
    mixins: [
        'Ext.mixin.Factoryable'
    ],

    alias: 'uifactory.xtype',

    factoryConfig: {
        type: 'uifactory',
        defaultType: 'xtype'
    },

    build: function (conf) {
        return Ext.widget(Ext.apply({ xtype: conf.uid }, conf));
    }

});