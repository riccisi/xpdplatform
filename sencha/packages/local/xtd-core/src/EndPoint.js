Ext.define('Xtd.core.EndPoint', {
    singleton: true,
    endpoint: Ext.manifest.server.context,

    url: function(relative) {
        return '/' + this.endpoint + '/' + relative;
    }

});