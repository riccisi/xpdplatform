Ext.define('Xtd.admin.jwt.security.Authentication', {
    singleton: true,
    requires: [
        'Xtd.admin.jwt.security.TokenStorage',
        'Xtd.admin.jwt.security.Token'
    ],

    login: function(username, password) {
        var deferred = new Ext.Deferred();

        Ext.Ajax.request({
            url: Xtd.core.EndPoint.url('oauth/token'),
            method: 'POST',
            headers: {
                "Authorization": "Basic dGVzdGp3dGNsaWVudGlkOlhZN2ttem9OemwxMDA="
            },
            params: {
                'username': username,
                'password': password,
                'grant_type': 'password'
            },

            success: function (response) {
                var data = Ext.decode(response.responseText);
                if (data.access_token) {
                    Xtd.admin.jwt.security.TokenStorage.save(data.access_token);
                    deferred.resolve(data, response);
                } else {
                    deferred.reject(data, response);
                }
            },

            failure: function (response) {
                var data = Ext.decode(response.responseText);
                Xtd.admin.jwt.security.TokenStorage.clear();
                deferred.reject(data, response);
            }
        });

        return deferred.promise;
    },

    logout: function(callback) {
        Xtd.admin.jwt.security.TokenStorage.clear();
        callback();
    },

    isLoggedIn: function () {
        var Storage = Xtd.admin.jwt.security.TokenStorage;
        return Storage.hasToken() && !Storage.retrieve().isExpired();
    }

}, function () {
    var Storage = Xtd.admin.jwt.security.TokenStorage;
    Ext.Ajax.on('beforerequest', function(conn, options) {
        if (Xtd.admin.jwt.security.Authentication.isLoggedIn()) {
            options.headers = options.headers || {};
            options.headers['Authorization'] = 'Bearer ' + Storage.retrieve().plain();
        }
    });
});