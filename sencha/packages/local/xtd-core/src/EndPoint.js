Ext.define('Xtd.core.EndPoint', {
    singleton: true,
    endpoint: Ext.manifest.server.context,

    url: function(relative) {
        return Ext.String.format('/{0}/{1}', this.endpoint, relative);
    }

});