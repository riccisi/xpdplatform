Ext.define('Xtd.admin.jwt.view.login.Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.xtd-login',
    requires: [
        'Xtd.admin.jwt.security.Authentication',
        'Xtd.admin.jwt.view.main.View'
    ],

    onLoginClick: function() {
        var username = this.getViewModel().get('username');
        var password = this.getViewModel().get('password');
        Xtd.admin.jwt.security.Authentication.login(username, password).then(function() {
            this.getView().destroy();
            Ext.create({
                xtype: 'xtd-admin-main'
            });
        }.bind(this), function(data) {
            Ext.Msg.alert('Error', data.message || 'An error occurred while logging in.');
        });
    }
});