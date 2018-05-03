Ext.define('Xtd.core.model.MenuNode', {
    extend: 'Ext.data.TreeModel',

    fields: [
        { name: 'text', type: 'string' },
        { name: 'iconCls', type: 'string', mapping: 'id',
            convert: function(id) {
                if(id) {
                    return 'menu-node-' + id.replace(/\./g,'-');
                }
            }
        },
        { name: 'action',  convert: function(value) { return value; } }
    ]

});