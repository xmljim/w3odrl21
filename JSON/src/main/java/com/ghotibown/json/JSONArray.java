package com.ghotibown.json;

import com.ghotibown.json.exception.JSONInvalidValueTypeException;

public interface JSONArray extends JSONListNode {

	void add(String string);
	
	void add(Boolean bool);
	
	void add(Number number);
	
	void add(JSONArray array);
	
	void add(JSONObject obj);
	
	String getString(int index) throws JSONInvalidValueTypeException;
	
	Number getNumber(int index) throws JSONInvalidValueTypeException;
	
	long getLong(int index) throws JSONInvalidValueTypeException;
	
	int getInt(int index) throws JSONInvalidValueTypeException;
	
	boolean getBoolean(int index) throws JSONInvalidValueTypeException;
	
	JSONArray getJSONArray(int index) throws JSONInvalidValueTypeException;
	
	JSONObject getJSONObject(int index) throws JSONInvalidValueTypeException;
	


}
