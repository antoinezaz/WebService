(function (){
    module.exports = userModel;

    function userModel(app){

        var UserSchema = app.mongoose.Schema({
            email: {
                type: String,
                required: true
            },
            password: {
                type: String,
                required: true
            }
        });

        UserSchema.index({email: 1}, {unique: true});
        UserSchema.plugin(require('mongoose-timestamp'));

        UserSchema.methods.toJSON = function(){
            var user = this.toObject();
            delete user.password;
            return user;
        };

        return app.mongoose.model('User', UserSchema);
    }
})();