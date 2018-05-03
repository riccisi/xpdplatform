Ext.define('Xtd.admin.jwt.security.Token', {
    requires: [
        'Ext.util.Base64'
    ],

    token: null,

    constructor(token) {
        this.token = token;
    },

    plain: function() {
        return this.token;
    },

    urlBase64Decode: function(str) {
        var output = str.replace(/-/g, '+').replace(/_/g, '/');
        switch (output.length % 4) {
            case 0: {
                break;
            }
            case 2: {
                output += '==';
                break;
            }
            case 3: {
                output += '=';
                break;
            }
            default: {
                throw 'Illegal base64url string!';
            }
        }
        return Ext.util.Base64.decode(output);
    },

    decode: function() {
        var parts = this.token.split('.');
        if (parts.length !== 3) {
            throw new Error('The inspected token doesn\'t appear to be a JWT. Check to make sure it has three parts and see https://jwt.io for more.');
        }
        var decoded = this.urlBase64Decode(parts[1]);
        if (!decoded) {
            throw new Error('Cannot decode the token.');
        }
        return JSON.parse(decoded);
    },

    expirationDate: function() {
        var decoded = this.decode();
        if (!decoded.hasOwnProperty('exp')) {
            return null;
        }
        var date = new Date(0);
        date.setUTCSeconds(decoded.exp);
        return date;
    },

    isExpired: function(offsetSeconds) {
        offsetSeconds = offsetSeconds || 0;
        var date = this.expirationDate();
        if (date === null) {
            return true;
        }
        return !(date.valueOf() > new Date().valueOf() + offsetSeconds * 1000);
    },

    displayName: function() {
        var decoded = this.decode();
        return decoded.displayName;
    }

});