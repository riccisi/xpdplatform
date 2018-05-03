
Ext.define('Xtd.core.app.Application', {
    extend: 'Ext.app.Application',
    requires: [
        'Xtd.core.*'
    ],

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    },

    launch: function () {
        Ext.create({
            xtype: 'xtd-main'
        });
    }
});