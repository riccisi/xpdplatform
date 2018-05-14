Ext.define('Xtd.core.model.ModelMetadata', {
    extend: 'Ext.data.Model',

    requires: [
        'Xtd.core.model.Attribute',
        'Xtd.core.model.StringField',
        'Xtd.core.model.NumberField',
        'Xtd.core.model.DateField'
    ],

    fields: [
        {name: 'id', type: 'string'},
        {name: 'attributes', convert: function(attributes) {
            var list = new Ext.util.MixedCollection();
            Ext.each(attributes, function(attribute) {
                list.add(Xtd.core.model.Attribute.create(attribute));
            });
            return list;
        }}
    ],

    defineModel: function() {
        var modelName = this.getModelName();
        var fields = this.getModelFields();
        Ext.define(modelName, {
            extend: 'Ext.data.Model',
            fields: fields
        });
        console.log('Model ' + modelName + ' successfully defined!');
    },

    /*createInstance: function(referencedBy, callback, scope) {
        var model = Ext.create(this.get('modelClass'));
        model.initFromServer({ callback: callback, scope: scope }, referencedBy);
        return model;
    },*/

    getModelName: function() {
        return this.getId();
    },

    getModelFields: function() {
        if (!this.modelFields) {
            var attributes = this.get('attributes');
            this.modelFields = [];
            attributes.each(function(attribute) {
                var modelFieldsConf = attribute.getModelFieldConf();
                modelFieldsConf = Ext.isArray(modelFieldsConf) ? modelFieldsConf : [modelFieldsConf];
                for (var i in modelFieldsConf) {
                    this.modelFields.push(modelFieldsConf[i]);
                }
            }, this);
        }
        return this.modelFields;
    },

    columns: function() {
        if (!this.gridColumns) {
            var attributes = this.get('attributes');
            this.gridColumns = [];
            attributes.each(function(attribute) {
                var gridColumnConf = attribute.getGridColumnConf();
                gridColumnConf = Ext.isArray(gridColumnConf) ? gridColumnConf : [gridColumnConf];
                for (var i in gridColumnConf) {
                    this.gridColumns.push(gridColumnConf[i]);
                }
            }, this);
        }
        return this.gridColumns;
    },

    store: function(url) {
        return Ext.create('Ext.data.Store', {
            model: this.getModelName(),
            proxy: {
                type: 'ajax',
                url: url,
                paramsAsJson: true,
                actionMethods: {
                    create: 'POST',
                    read: 'POST',
                    update: 'POST',
                    destroy: 'POST'
                },
                reader: {
                    type: 'json',
                    rootProperty: 'result' ,
                    totalProperty: 'total'
                }
            },
            autoLoad: true
        });
    }

    /*,

    getFormFields: function(excludedFields) {
        return this.collectFormFields(excludedFields);
    },

    getGridColumns: function(grid) {
        return this.collectGridColumns(grid);
    },

    getGridColumn: function(name, grid) {
        var found = null;
        var columns = this.collectGridColumns(grid);
        Ext.each(columns, function (column) {
            if (column.dataIndex == name) {
                found = column;
                return false;
            }
        });
        return found;
    },

    getFilterFields: function() {
        return this.collectFilterFields();
    },

    getFilterField: function(name) {
        var found = null;
        var fields = this.collectFilterFields();
        Ext.each(fields, function (field) {
            if (field.name == name) {
                found = field;
                return false;
            }
        });
        return found;
    },

    getManyRelations: function() {
        var manyRelations = [];
        var modelClass = this.get('modelClass');
        var model = Ext.create(modelClass);
        if (model.associations) {
            for (var roleName in model.associations) {
                var association = model.associations[roleName];
                if(association.isMany) {
                    manyRelations.push({
                        name: association.role,
                        modelClass: association.type,
                        inverseName: association.inverse.role
                    });
                }
            }
        }
        return manyRelations;
    }*/

});