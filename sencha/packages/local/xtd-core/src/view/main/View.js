Ext.define('Xtd.core.view.main.View', {
    extend: 'Ext.container.Viewport',
    xtype: 'xtd-main',

    requires: [
        'Xtd.core.EndPoint',
        'Xtd.core.view.main.Controller',
        'Xtd.core.view.main.Model'
    ],

    controller: 'xtd-main',
    viewModel: 'xtd-main',

    layout: 'fit',

    items: [{
        xtype: 'panel',
        layout: 'border',

        header: {
            title: {
                iconCls: 'x-fa fa-university',
                baseCls: 'main-title',
                text: 'mercury portal'
            },
            items: [{
                xtype: 'button',
                cls: 'link',
                text: 'Ciao, Simone',
                menu: [{
                    text: 'Impostazioni',
                    iconCls: 'x-fa fa-cog'
                },'-',{
                    text: 'Esci',
                    iconCls: 'x-fa fa-sign-out',
                    handler: function() {
                        document.location = '/login.html';
                    }
                }]
            }, {
                xtype: 'component',
                html: '<div class="user"></div>'
            }]
        },

        items: [{
            region: 'west',
            cls: 'treelist-with-nav',
            width: 250,
            split: {
                size: 5
            },
            reference: 'treelistContainer',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            border: false,
            scrollable: 'y',
            items: [{
                xtype: 'treelist',
                ui: 'nav',
                micro: false,
                highlightPath: true,
                expanderFirst: false,
                expanderOnly: false,
                reference: 'treelist',
                bind: {
                    store: '{menu}',
                    selection: '{selectedNode}'
                }
            }],
            dockedItems: [{
                xtype: 'toolbar',
                cls: 'treelist-toolbar',
                dock: 'top',
                reference: 'searchToolbar',
                items: [{
                    xtype: 'combo',
                    flex: 1,
                    bind: {
                        store: '{flatmenu}'
                    },
                    queryMode: 'local',
                    listConfig: {
                        itemTpl: [
                            '<i class="{iconCls}" style="margin-right: 10px;"></i> {text}'
                        ]
                    },
                    listeners: {
                        select: 'onSearchMenuSelect'
                    }
                }]
            },{
                xtype: 'toolbar',
                dock: 'bottom',
                cls: 'treelist-toolbar',
                items: [{
                    reference: 'expandTreelistBtn',
                    iconCls: 'x-fa fa-angle-double-right',
                    cls: 'treelist-button',
                    hidden: true,
                    handler: 'expandMenu'
                }, '->', {
                    reference: 'collapseTreelistBtn',
                    iconCls: 'x-fa fa-angle-double-left',
                    cls: 'treelist-button',
                    hidden: false,
                    handler: 'collapseMenu'
                }]
            }]
        }, {
            region: 'center',
            xtype: 'panel',
            tbar: {
                xtype: 'breadcrumb',
                bind: {
                    store: '{menu}',
                    selection: '{selectedNode}'
                }
            },
            layout: 'card',
            defaults: {
                header: false
            },
            items: [/*{
                itemId: 'generic',
                xtype: 'panel',
                bodyCls: 'genericpanel'
            }, {
                itemId: 'pos-logs',
                xtype: 'pos-logs'
            }, {
                itemId: 'card-management',
                xtype: 'card-management'
            }*/]
        }]
    }]

});
