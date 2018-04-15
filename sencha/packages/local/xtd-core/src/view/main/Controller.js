Ext.define('Xtd.core.view.main.Controller', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.xtd-main',

    collapseMenu: function () {
        var treelist = this.lookupReference('treelist'),
            expandBtn = this.lookupReference('expandTreelistBtn'),
            collapseBtn = this.lookupReference('collapseTreelistBtn'),
            searchToolbar = this.lookupReference('searchToolbar'),
            ct = treelist.ownerCt;

        treelist.setMicro(true);
        ct.setWidth(44);
        expandBtn.setHidden(false);
        collapseBtn.setHidden(true);
        searchToolbar.setHidden(true);
    },

    expandMenu: function () {
        var treelist = this.lookupReference('treelist'),
            expandBtn = this.lookupReference('expandTreelistBtn'),
            collapseBtn = this.lookupReference('collapseTreelistBtn'),
            searchToolbar = this.lookupReference('searchToolbar'),
            ct = treelist.ownerCt;

        treelist.setMicro(false);
        ct.setWidth(250);
        expandBtn.setHidden(true);
        collapseBtn.setHidden(false);
        searchToolbar.setHidden(false);
    }

});