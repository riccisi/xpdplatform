/**
 * Created by simone on 11/05/2018.
 */
Ext.define('Xtd.core.view.query.filter.View', {
    extend: 'Ext.panel.Panel',

    requires: [
        'Xtd.core.view.query.filter.Model',
		'Xtd.core.view.query.filter.Controller'
    ],

    xtype: 'queryFilter',

    viewModel: {
        type: 'queryFilter'
    },

    controller: 'queryFilter',

    config: {
        modelId: null
    },

    items: [{
        html: 'ciao'
    }]
});