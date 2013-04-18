package cmu.circle.insider.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

import cmu.circle.insider.constant.Constant;

public class HttpUtil {

	public static String sendHttpGet(String path) throws IOException {
		URL url = new URL(Constant.SERVER_ADDRESS + path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = new BufferedInputStream(connection.getInputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String readLine;
		StringBuilder entitySB = new StringBuilder();
		while ((readLine = reader.readLine()) != null) {
			entitySB.append(readLine);
		}
		reader.close();
		in.close();
		String response = entitySB.toString();
		connection.disconnect();
		return response;

	}

	public static String sendHttpPost(String path, String entity) throws IOException {
		URL url = new URL(Constant.SERVER_ADDRESS + path);
		HttpURLConnection connection = (HttpURLConnection) url
				.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-type", "application/json");
			connection.setChunkedStreamingMode(0);

			OutputStream out = new BufferedOutputStream(
					connection.getOutputStream());
			PrintWriter p = new PrintWriter(out);
			p.print(entity);
			p.flush();
			p.close();
			InputStream in = new BufferedInputStream(connection.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String readLine;
			StringBuilder entitySB = new StringBuilder();
			while ((readLine = reader.readLine()) != null) {
				entitySB.append(readLine);
			}
			reader.close();
			in.close();
			String response = entitySB.toString();
			connection.disconnect();
			return response;
	}
}
