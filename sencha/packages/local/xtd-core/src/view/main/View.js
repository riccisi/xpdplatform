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

    config: {
        headTitle: {
            iconCls: 'x-fa fa-hashtag',
            text: 'application title'
        },
        headItems: []
    },

    initComponent: function() {

        this.items = [{
            xtype: 'panel',
            layout: 'border',

            header: {
                title: this.getHeadTitle(),
                items: this.getHeadItems()
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
                            store: '{flatMenu}'
                        },
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
                reference: 'content',
                tbar: {
                    xtype: 'breadcrumb',
                    bind: {
                        store: '{menu}',
                        selection: '{selectedNode}'
                    }
                },
                defaults: {
                    header: false
                },
                layout: 'card'
            }]
        }];

        this.callParent(arguments);
    }

});
