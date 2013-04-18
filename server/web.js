var path = require('path');
var express = require('express');
var http = require('http');
var mongoose = require('mongoose');
console.log("hello");
function init() {
    var app = express();
    configureExpress(app);
    mongoose.connect(process.env.MONGOLAB_URI || process.env.MONGOHQ_URL || 'mongodb://localhost/myApp');
    require('./circleRoutes')(app);

    http.createServer(app).listen(process.env.PORT || 10086, function() {
        console.log("Express server listening on port %d", process.env.PORT || 10086);
    });


}

init();

function configureExpress(app) {
    app.configure(function() {
        app.use(express.bodyParser());
        app.use(express.methodOverride());

        app.use(express.cookieParser('your secret here'));
        app.use(express.session());
        app.use(express.query());

        app.use(app.router);
        app.use(express["static"](__dirname + "/www/"));
    });
}