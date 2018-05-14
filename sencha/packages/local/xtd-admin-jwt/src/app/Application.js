
Ext.define('Xtd.admin.jwt.app.Application', {
    extend: 'Xtd.core.app.Application',
    requires: [
        'Xtd.admin.jwt.*'
    ],

    launch: function () {
        Ext.Ajax.on('requestexception', function (conn, response) {
            if (response.status === 401) {
                Ext.create({
                    xtype: 'xtd-login',
                    modal: true,
                    redirect: false
                });
            }
        });
        var loggedIn = Xtd.admin.jwt.security.Authentication.isLoggedIn();
        Ext.create({
            xtype: loggedIn ? 'xtd-admin-main' : 'xtd-login'
        });
    }
});