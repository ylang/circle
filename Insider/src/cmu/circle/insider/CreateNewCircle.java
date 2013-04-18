package cmu.circle.insider;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.AsyncTask;
import android.util.Log;
import cmu.circle.insider.bean.Circle;
import cmu.circle.insider.util.HttpUtil;

public class CreateNewCircle extends
		AsyncTask<Void, Integer, Circle> {

	private String name;
	private String detail;

	private final String TAG = this.getClass().getName();

	public CreateNewCircle(String name, String detail) {
		this.name = name;
		this.detail = detail;
	}

	@Override
	protected Circle doInBackground(Void... arg0) {
		try {
			JSONObject json = new JSONObject();
			json.put(Circle.NAME, name);
			json.put(Circle.DETAIL, detail);
			Log.d(TAG, json.toString());
			String response = HttpUtil.sendHttpPost("circle/create",
					json.toString());
			if (response != null && response.length() != 0) {
				JSONObject jsonRes = (JSONObject) new JSONTokener(response)
						.nextValue();
				JSONObject jsonCircle = jsonRes.getJSONObject("circle");
				if (jsonCircle != null) {
					Log.d(TAG, jsonCircle.toString());
					Circle circle = Circle.getCircleFromJSON(jsonCircle);
					if (circle != null) {
						Log.d(TAG, "circle created successfully");
					} else {
						Log.e(TAG, "error during parse circle recieved.");
					}
					return circle;
				}
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
