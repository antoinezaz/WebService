var express = require('express');

(function init() {
    var app = {
        server: express()
    };
    require('./settings')(app);
    require('./models')(app);
    require('./controllers')(app);
    var port = app.settings.port;

    app.server.listen(port);
    console.log('Server started. Listening on port #{port}.'
        .replace('#{port}', port));
}());