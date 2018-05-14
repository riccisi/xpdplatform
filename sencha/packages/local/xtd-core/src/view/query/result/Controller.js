/**
 * Created by simone on 11/05/2018.
 */
Ext.define('Xtd.core.view.query.result.Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.queryResult',

    /**
     * Called when the view model is created
     */
    initViewModel: function(viewModel) {
        var view = this.getView();
        var modelId = view.getModelId();
        if(!modelId) {
            Ext.raise('modelId parameter cannot be null');
        }
        var url = view.getUrl();
        if(!url) {
            Ext.raise('url parameter cannot be null');
        }
        var metadata = viewModel.get('modelMetadata').getById(modelId);
        view.reconfigure(metadata.store(url), metadata.columns());
    }
});