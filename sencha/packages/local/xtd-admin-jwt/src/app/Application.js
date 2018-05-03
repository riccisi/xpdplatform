
Ext.define('Xtd.admin.jwt.app.Application', {
    extend: 'Xtd.core.app.Application',
    requires: [
        'Xtd.admin.jwt.*'
    ],

    launch: function () {
        var loggedIn = Xtd.admin.jwt.security.Authentication.isLoggedIn();
        Ext.create({
            xtype: loggedIn ? 'xtd-admin-main' : 'xtd-login'
        });
    }
});