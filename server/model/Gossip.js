var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var Gossip = new Schema({
	circleId: String,
	imageId: String,
    ownerId: String,
    tagList: Array,
    loc : {type : Array, index : '2d'},
    lat: Number,
    lng: Number,
    city: String,
    height: Number,
    width: Number,
    date: { type: Date, default: Date.now },
    text: String
});


module.exports = mongoose.model('Gossip', Gossip );