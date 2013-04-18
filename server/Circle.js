var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var Circle = new Schema({
    name: String,
    detail: String,
    gossipIds: Array,
    gossipCnt: Number,
    followerCnt: Number,
    date: { type: Date, default: Date.now }
});

module.exports = mongoose.model('Circle', Circle );