Ext.define('Xtd.admin.jwt.view.main.View', {
    extend: 'Xtd.core.view.main.View',
    xtype: 'xtd-admin-main',

    requires: [
        'Xtd.admin.jwt.view.main.Controller',
        'Xtd.admin.jwt.view.main.Model'
    ],

    controller: 'xtd-admin-main',
    viewModel: 'xtd-admin-main',

    headItems: [{
        xtype: 'button',
        cls: 'link',
        bind: {
            text: 'Ciao, {displayName}'
        },
        menu: [{
            text: 'Impostazioni',
            iconCls: 'x-fa fa-cog'
        },'-',{
            text: 'Esci',
            iconCls: 'x-fa fa-sign-out',
            handler: 'onExit'
        }]
    }]

});