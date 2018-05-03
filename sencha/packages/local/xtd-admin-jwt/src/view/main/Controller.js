Ext.define('Xtd.admin.jwt.view.main.Controller', {
    extend: 'Xtd.core.view.main.Controller',

    alias: 'controller.xtd-admin-main',

    onExit: function() {
        Xtd.admin.jwt.security.TokenStorage.clear();
        this.getView().destroy();
        Ext.create({
            xtype: 'xtd-login'
        });
    }

});