# A Circle project contains both an Android client-side app and a nodejs back-end server

#Server API entey point
##circle
	*	GET /circle/get/all?p=:page
respond: {[circles], more}
10 ids are return each time.
	* POST /circle/create
entity: {name: name, detail: detail}
response: {circle: circle}

#db schema

##circle
	*	name: String,
	*	detail: String,
	*	gossipIds: Array,
	*	gossipCnt: Number,
	*	followerCnt: Number,
	*	date: Date

##gossip
	*	circleId: String,
	*	imageId: String,
	*	owner: String,
	*	tagList: Array,
	*	loc : {type : Array, index : '2d'},
	*	lat: Number,
	*	lng: Number,
	*	city: String,
	*	height: Number,
	*	width: Number,
	*	date: Date,
	*	text: String

