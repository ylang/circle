package cmu.circle.insider;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.AsyncTask;
import android.util.Log;
import cmu.circle.insider.bean.Circle;
import cmu.circle.insider.util.HttpUtil;

public class GetAllCircles extends AsyncTask<Void, Integer, ArrayList<Circle>>{
	private int page;
	private final String TAG = this.getClass().getName();
	
	public GetAllCircles(int page) {
		this.page = page;
	}
	@Override
	protected ArrayList<Circle> doInBackground(Void... arg0) {
		try {
			String response = HttpUtil.sendHttpGet("circle/get/all/?p=" + page);
			if (response != null && response.length() != 0) {
				JSONObject json = (JSONObject) new JSONTokener(response).nextValue();
				JSONArray circles = json.getJSONArray("circles");
				ArrayList<Circle> result = new ArrayList<Circle>(circles.length());
				if (circles != null) {
					for (int i = 0; i <circles.length(); i++) {
						JSONObject jsonCircle = circles.getJSONObject(i);
						Log.d(TAG, jsonCircle.toString());
						Circle circle = Circle.getCircleFromJSON(jsonCircle);
						if (circle != null) {
							Log.d(TAG, "circle recieved successfully");
							result.add(circle);
						}
					}
				}
				return result;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
