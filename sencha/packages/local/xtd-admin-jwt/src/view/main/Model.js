Ext.define('Xtd.admin.jwt.view.main.Model', {
    extend: 'Xtd.core.view.main.Model',

    alias: 'viewmodel.xtd-admin-main',

    formulas: {
        displayName: function() {
            return Xtd.admin.jwt.security.TokenStorage.retrieve().displayName();
        }
    }
});