Ext.define('Xtd.admin.jwt.security.TokenStorage', {
    requires: [
        'Xtd.admin.jwt.security.Token'
    ],
    singleton: true,
    storageKey: 'json-web-token',

    clear: function () {
        localStorage.removeItem(this.storageKey);
    },

    retrieve: function() {
        return new Xtd.admin.jwt.security.Token(localStorage.getItem(this.storageKey));
    },

    save: function(token) {
        localStorage.setItem(this.storageKey, token);
    },

    hasToken: function() {
        return localStorage.getItem(this.storageKey) != null;
    }

});