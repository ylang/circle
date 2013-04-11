var Circle = require('./Circle');

module.exports = function (app) {
    var NUM_PER_PAGE = 10;
    
    app.get('/circle/get/all', function (req, res) {
        console.log("CIRCLE: GET /circle/get/all");
        console.log("page = " + req.query.p);
        Circle.find({
        }, 'id name gossipCnt followerCnt', {
            sort: [
                ['gossipCnt', 1]
            ],
            skip: ((req.query.p - 1) * NUM_PER_PAGE),
            limit: NUM_PER_PAGE
        }, function(err, circles) {
            if(err) {
                res.send(500, err);
                console.log("error: " + err);
            } else {
                var more = (circles.length === NUM_PER_PAGE) ? (true) : (false);
                console.log("found circles: ");
                console.log(circles);
                res.send(200, {
                    circles: circles,
                    more: more
                });
            }
            console.log("response sent");
        });
    });


    /* entry point of create a circle.
     *
     */
    app.post('/circle/create', function(req, res) {
        console.log("CIRCLE: GET /circle/create");
        var circle = new circle({
            name:req.body.name,
            detail: req.body.detail,
            gossipIds: new Array(),
            gossipCnt: 0,
            followerCnt: 1,
            date: new Date()
        });
        circle.save(function(err) {
            if (err) {
                console.log("ERR CIRCLE creating new circle:" + err);
                res.status = 500;
                res.send({
                    status: 'fail',
                    error: err
                });
                return;
            }
            console.log("DEBUG CIRCLE circle saved.");
            console.log(circle);
            res.status = 200;
            res.json({
                status: success,
                circle: circle
            })
        });
    });
}