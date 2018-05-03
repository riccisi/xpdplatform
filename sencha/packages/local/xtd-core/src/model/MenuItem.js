Ext.define('Xtd.core.model.MenuItem', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'text', type: 'string' },
        { name: 'iconCls', type: 'string', mapping: 'id',
            convert: function(id) {
                if(id) {
                    return 'menu-node-' + id.replace(/\./g,'-');
                }
            }
        }
    ]

});