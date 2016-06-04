(function (){
    var bodyParser = require('body-parser');
    var jwt = require('jsonwebtoken');

    module.exports = function(app) {
        app.server.use(bodyParser.json());
        app.server.route('/login')
            .post(checkedLogin, login);


        function checkedLogin(req, res, next) {
            if (!req.body.email) {
                res.status(400).send("Missing email");
            }
            else if (!req.body.password) {
                res.status(400).send("Missing password");
            }
            else {
                next();
            }
        }

        function login(req, res) {
            app.models.User.findOne({
                email: req.body.email,
                password: req.body.password
            }, function (err, user) {
                if(err) {
                    res.status(500).send("Something went wrong: ", err);
                    return;
                }

                if(!user) {
                    res.status(404).send("Login or password is not correct");
                    return;
                }
                var token = jwt.sign(user.toJSON(), app.settings.secret);
                res.send(token);
            });

        }
    };
})();