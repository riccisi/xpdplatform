Ext.define('Xtd.core.view.main.Model', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.xtd-main',

    stores: {
        menu: {
            type: 'tree',
            model: 'Xtd.core.model.Menu',
            proxy: {
                type: 'rest',
                url: Xtd.core.EndPoint.url('menu')
            },
            root: {
                expanded: true
            }
        }
    }

});