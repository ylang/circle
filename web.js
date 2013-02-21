var path = require('path');
var express = require('express');
var http = require('http');
var mongoose = require('mongoose');
console.log("hello");
function init() {
    var app = express();
    configureExpress(app);
    mongoose.connect(process.env.MONGOLAB_URI || process.env.MONGOHQ_URL || 'mongodb://localhost/myApp');
    http.createServer(app).listen(process.env.PORT || 18419, function() {
        console.log("Express server listening on port %d", process.env.PORT || 18419);
    });


}

init();

function configureExpress(app) {
    app.configure(function() {
        app.use(express.bodyParser());
        app.use(express.methodOverride());

        app.use(express.cookieParser('your secret here'));
        app.use(express.session());

        app.use(app.router);
        app.use(express["static"](__dirname + "/www/"));
    });
}