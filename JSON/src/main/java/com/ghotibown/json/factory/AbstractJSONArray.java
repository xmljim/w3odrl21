package com.ghotibown.json.factory;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.JSONValueType;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;

abstract class AbstractJSONArray extends AbstractListNode implements JSONArray, Iterable<JSONValue<?>> {

	public AbstractJSONArray() {
		super();
	}

	@SuppressWarnings("unchecked")
    public String getString(int index) throws JSONInvalidValueTypeException {
		String value = null;
	    if (get(index).getType() == JSONValueType.STRING) {
	    	JSONValue<String> v = (JSONValue<String>) get(index);
	    	value = v.getValue();
	    } else {
	    	throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.STRING, get(index).getType()));
	    }
	    
	    return value;
    }

	@SuppressWarnings("unchecked")
    public Number getNumber(int index) throws JSONInvalidValueTypeException {
	    Number value = null;
	    if (get(index).getType() == JSONValueType.NUMBER) {
	    	JSONValue<Number> v = (JSONValue<Number>) get(index);
	    	value = v.getValue();
	    } else {
	    	throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.NUMBER, get(index).getType()));
	    }
	    
	    return value;
    }
	
	public long getLong(int index) throws JSONInvalidValueTypeException {
		return getNumber(index).longValue();
	}
	
	public int getInt(int index) throws JSONInvalidValueTypeException {
		return getNumber(index).intValue();
	}

	@SuppressWarnings("unchecked")
    public boolean getBoolean(int index) throws JSONInvalidValueTypeException {
	    Boolean value = null;
	    if (get(index).getType() == JSONValueType.BOOLEAN) {
	    	JSONValue<Boolean> v = (JSONValue<Boolean>) get(index);
	    	value = v.getValue().booleanValue();
	    } else {
	    	throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.BOOLEAN, get(index).getType()));
	    }
	    
	    return value;
    }

	@SuppressWarnings("unchecked")
    public JSONArray getJSONArray(int index) throws JSONInvalidValueTypeException {
	    JSONArray value = null;
	    if (get(index).getType() == JSONValueType.ARRAY) {
	    	JSONValue<JSONArray> v = (JSONValue<JSONArray>) get(index);
	    	value = v.getValue();
	    } else {
	    	throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.ARRAY, get(index).getType()));
	    }
	    
	    return value;
    }

	@SuppressWarnings("unchecked")
    public JSONObject getJSONObject(int index) throws JSONInvalidValueTypeException {
		JSONObject value = null;
	    if (get(index).getType() == JSONValueType.OBJECT) {
	    	JSONValue<JSONObject> v = (JSONValue<JSONObject>) get(index);
	    	value = v.getValue();
	    } else {
	    	throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.OBJECT, get(index).getType()));
	    }
	    
	    return value;
    }

    public void add(String string) {
	    JSONStringValue value = new JSONStringValue(string);
	    add(value);
	    
    }

    public void add(Boolean bool) {
	    JSONBooleanValue value = new JSONBooleanValue(bool);
	    add(value);
    }

    public void add(Number number) {
	    JSONNumberValue value = new JSONNumberValue(number);
	    add(value);
	    
    }

    public void add(JSONArray array) {
	    JSONArrayValue value = new JSONArrayValue(array);
	    add(value);
	    
    }

    public void add(JSONObject obj) {
	    JSONObjectValue value = new JSONObjectValue(obj);
	    add(value);
	    
    }

	
	public String toJSONString() {
		return "";
	}

	
	

}
