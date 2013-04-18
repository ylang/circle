package cmu.circle.insider.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;

public class Circle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8656735798037450759L;
	public static final String NAME = "name";
	public static final String ID = "_id";
	public static final String DETAIL = "detail";
	public static final String FOLLOWER_CNT = "followerCnt";
	public static final String DATE = "date";
	public static final String GOSSIP_CNT = "gossipCnt";
	public String id;
	public String name;
	public String detail;
	public String[] gossipIds;
	public int followerCnt;
	public int gossipCnt;
	public Date date;

	public static Circle getCircleFromJSON(JSONObject jsonCircle) {
		try {
			String name = jsonCircle.getString(Circle.NAME);
			String detail = jsonCircle.getString(Circle.DETAIL);
			String id = jsonCircle.getString(Circle.ID);
			int followerCnt = jsonCircle.getInt(Circle.FOLLOWER_CNT);
			int gossipCnt = jsonCircle.getInt(Circle.GOSSIP_CNT);
			String date = jsonCircle.getString(Circle.DATE);
			date = date.substring(0, date.indexOf('.'));

			Circle circle = new Circle();
			circle.name = name;
			circle.detail = detail;
			circle.id = id;
			circle.followerCnt = followerCnt;
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss");
			format.setTimeZone(TimeZone.getTimeZone("UTC"));
			circle.date = format.parse(date);
			circle.gossipCnt = gossipCnt;
			return circle;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
