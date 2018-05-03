Ext.define('Xtd.core.view.main.Model', {
    extend: 'Ext.app.ViewModel',
    requires: [
        'Xtd.core.model.MenuNode',
        'Xtd.core.model.MenuItem',
        'Xtd.core.store.ModelMetadata'
    ],

    alias: 'viewmodel.xtd-main',

    stores: {
        modelMetadata: {
            type: 'modelMetadata',
            autoLoad: true
        },
        menu: {
            type: 'tree',
            model: 'Xtd.core.model.MenuNode',
            proxy: {
                type: 'rest',
                url: Xtd.core.EndPoint.url('menu')
            },
            root: {
                expanded: true
            }
        },
        flatMenu: {
            model: 'Xtd.core.model.MenuItem',
            proxy: {
                type: 'rest',
                url: Xtd.core.EndPoint.url('menu/flat')
            }
        }
    }

});