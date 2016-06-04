(function () {
    var mongoose = require('mongoose');

    module.exports = function(app){

        app.mongoose = mongoose.connect(app.settings.db);
        app.Schema = mongoose.Schema;

        app.models = {};
        app.models.User = require('./Users')(app);
    };
})();