Ext.define('Xtd.admin.jwt.view.login.View', {
    extend: 'Ext.window.Window',
    xtype: 'xtd-login',

    requires: [
        'Xtd.admin.jwt.view.login.Controller',
        'Xtd.admin.jwt.view.login.Model',
        'Ext.form.Panel'
    ],

    controller: 'xtd-login',
    viewModel: 'xtd-login',

    title: 'Login',
    closable: false,
    autoShow: true,
    layout: 'fit',

    items: {
        xtype: 'form',
        bodyPadding: 10,
        defaults: {
            labelWidth: 65,
            anchor: '100%'
        },
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: 'Username',
            allowBlank: false,
            bind: '{username}'
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Password',
            allowBlank: false,
            bind: '{password}'
        }],
        buttons: [{
            text: 'Login',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }]
    }
});