/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
Ext.application({
    extend: 'App.Application',

    name: 'App',

    requires: [
        // This will automatically load all classes in the App namespace
        // so that application classes do not need to require each other.
        'App.*',
        'Xtd.core.*'
    ]

    // The name of the initial view to create.
//    mainView: 'Xtd.core.view.main.View'
});
