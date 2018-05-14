/**
 * Dynamic view to execute a query action and display a paginated result.
 *
 * Created by simone on 11/05/2018.
 */
Ext.define('Xtd.core.view.query.View', {
    extend: 'Ext.panel.Panel',
    requires: [
        'Xtd.core.view.query.Controller',
        'Xtd.core.view.query.Model',
        'Xtd.core.view.query.filter.View',
        'Xtd.core.view.query.result.View'
    ],

    xtype: 'query',

    controller: 'query',
    viewModel: 'query',

    config: {
        modelId: null,
        actionId: null
    },

    layout: {
        type: 'vbox',
        pack: 'start',
        align: 'stretch'
    },

    initComponent: function () {

        this.items = [{
            xtype: 'queryFilter',
            height: 50,
            modelId: this.getModelId()
        }, {
            xtype: 'queryResult',
            flex: 1,
            split: true,
            modelId: this.getModelId(),
            url: Xtd.core.EndPoint.url(Ext.String.format('action/{0}', this.getActionId()))
        }];

        this.callParent(arguments);
    }
});