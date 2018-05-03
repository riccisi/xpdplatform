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
                list.add(Xtd.core.model.Attribute.create(attribute.type, attribute));
            });
            return list;
        }}
    ],

    defineModel: function() {
        var id = this.getId();
        var fields = this.getModelFields();
        Ext.define(id, {
            extend: 'Ext.data.Model',
            fields: fields
        });
        console.log('Model ' + id + ' successfully defined!');
    },

    /*createInstance: function(referencedBy, callback, scope) {
        var model = Ext.create(this.get('modelClass'));
        model.initFromServer({ callback: callback, scope: scope }, referencedBy);
        return model;
    },*/

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
    }/*,

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