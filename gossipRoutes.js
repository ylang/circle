var Gossip = require('./Gossip');
var knox = require("knox");

module.exports = function (app) {
	var client = knox.createClient({
        key: 'AKIAINRZPE3EWRSRWNFA',
        secret: process.env.S3SECRET,
        bucket: 'gossip'
    });
    
    app.get('/', function (req, res) {

    });


    /* entry point of post a gossip to a circle.
     *
     */
    app.post('/post', function(req, res) {

    });
}