package cmu.circle.insider.response;

import java.io.Serializable;

import cmu.circle.insider.bean.Circle;

public class Response<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3283000354918074398L;
	public String err;
	public T data;
}
