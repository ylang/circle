package cmu.circle.insider.response;

import java.io.Serializable;

import cmu.circle.insider.bean.Circle;

public class GetAllCircleResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4741600830877137585L;
	
	public Circle[] circles;
	public boolean more;
}
