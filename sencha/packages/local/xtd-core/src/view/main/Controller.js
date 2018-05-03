Ext.define('Xtd.core.view.main.Controller', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.xtd-main',

    bindings: {
        onMenuSelection: '{selectedNode}'
    },

    listen: {
        controller: {
            '*': {
                showcontent: 'showContent'
            }
        }
    },

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
    },

    onSearchMenuSelect: function(combo, menuitem) {
        var treelist = this.lookupReference('treelist');
        treelist.setSelection(menuitem.getId());
    },

    onMenuSelection: function(node) {
        var coordinate = node.get('coordinate');
        if(coordinate) {
            this.showContent(coordinate)
        }
    },

    showContent: function(config) {
        var content = this.lookupReference('content');
        var widget = content.lookupComponent(config);
        if(!content.contains(widget)) {
            content.add(widget);
        }
        content.getLayout().setActiveItem(widget);
    }

});