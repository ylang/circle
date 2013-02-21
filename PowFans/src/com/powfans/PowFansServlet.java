package com.powfans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.*;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;
import weibo4j.util.WeiboConfig;

@SuppressWarnings("serial")
public class PowFansServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Oauth oauth = new Oauth();
		String state = "";
		WeiboConfig.updateProperties("client_ID", "4150869404");
		WeiboConfig.updateProperties("client_SERCRET", "ae9cc3e0af630e694e3b0d9f821c915e");
		WeiboConfig.updateProperties("redirect_URI", "http://apps.weibo.com/paofans");
		String scope = "friendships_groups_read";
		try {
			BareBonesBrowserLaunch.openURL(oauth.authorize("code",state, scope));
			System.out.println(oauth.authorize("code",state, scope));
		} catch (WeiboException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Log.logInfo("code: " + code);
		try{
			System.out.println(oauth.getAccessTokenByCode(code));
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
	}
}
