var assert = require("assert");
var should = require("should");
var http = require("http");
describe('Circle', function(){
  describe('get all but there is nothing in db', function(){
    it('should return -1 when the value is not present', function(){
      http.get({host:'localhost', port: 10086, path:'/circle/get/all?p=1'}, function(res) {
      	res.should.be({});
      });
    });
  });
});

describe('Array', function(){
  describe('#indexOf()', function(){
    it('should return -1 when the value is not present', function(){
      [1,2,3].indexOf(5).should.equal(-1);
      [1,2,3].indexOf(0).should.equal(-1);
    })
  })
})