/**
 * Created by simone on 11/05/2018.
 */
Ext.define('Xtd.core.view.query.result.View', {
    extend: 'Ext.grid.Panel',

    requires: [
        'Xtd.core.view.query.result.Model',
		'Xtd.core.view.query.result.Controller'
    ],

    xtype: 'queryResult',

    viewModel: {
        type: 'queryResult'
    },

    controller: 'queryResult',

    config: {
        modelId: null,
        url: null
    },

    columns: [],

    bbar: {
        xtype: 'pagingtoolbar',
        displayInfo: true,
        displayMsg: 'Risultati {0} - {1} di {2}',
        emptyMsg: "Nessun risultato trovato"
    }

});