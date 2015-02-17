package com.ghotibown.json.factory;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.JSONValueType;
import com.ghotibown.json.NullObject;
import com.ghotibown.json.exception.JSONInvalidValueTypeException;

abstract class AbstractJSONObject extends AbstractMapNode implements JSONObject {

	
	public AbstractJSONObject() {
		super();
	}


	
	public void put(String key, Number n) {
		JSONValue<Number> value = NodeFactory.newNumberValue(n);
		put(key, value);

	}

	
	public void put(String key, String s) {
		JSONValue<String> value = NodeFactory.newStringValue(s);
		put(key, value);

	}

	
	public void put(String key, boolean b) {
		JSONValue<Boolean> value = NodeFactory.newBooleanValue(b);
		put(key, value);

	}

	
	public void put(String key, JSONArray a) {
		JSONValue<JSONArray> value = NodeFactory.newJSONArrayValue(a);
		put(key, value);

	}

	
	public void put(String key, JSONObject o) {
		JSONValue<JSONObject> value = NodeFactory.newJSONObjectValue(o);
		put(key, value);

	}

	
	public void putNull(String key) {
		JSONValue<NullObject> value = NodeFactory.newJSONNullValue();
		put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJSONObject(String key) throws JSONInvalidValueTypeException {
		JSONObject value = null;
		if (containsKey(key)) {
			if (get(key).getType() == JSONValueType.OBJECT) {
				JSONValue<JSONObject> v = (JSONValue<JSONObject>) get(key);
				value = v.getValue();
			} else {
				throw new JSONInvalidValueTypeException();
			}
		}
			
		return value;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getJSONArray(String key) throws JSONInvalidValueTypeException {
		JSONArray value = null;
		
		if (containsKey(key)) {
			if (get(key).getType() == JSONValueType.ARRAY) {
				JSONValue<JSONArray> v = (JSONValue<JSONArray>)get(key);
				value = v.getValue();
			}
		}
			
		return value;
	}

	@SuppressWarnings("unchecked")
	public Number getNumber(String key) throws JSONInvalidValueTypeException {
		Number value = null;
		if (containsKey(key)) {
			if (get(key).getType() == JSONValueType.NUMBER) {
				JSONValue<Number> v = (JSONValue<Number>)get(key);
				value = v.getValue();
			}
		}
		
		return value;
	}

	public long getLong(String key) throws JSONInvalidValueTypeException {
		long value;
		Number v = getNumber(key);
		if (v != null) {
			value = v.longValue();
		} else {
			throw new JSONInvalidValueTypeException("Cannot cast a null value to an long");
		}
		return value;
	}


	public int getInt(String key) throws JSONInvalidValueTypeException {
		int value;
		Number v = getNumber(key);
		if (v != null) {
			value = v.intValue();
		} else {
			throw new JSONInvalidValueTypeException("Cannot cast a null value to an integer");
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public boolean getBoolean(String key) throws JSONInvalidValueTypeException {
		boolean value;
		
		if (containsKey(key)) {
			if (get(key).getType() == JSONValueType.BOOLEAN) {
				JSONValue<Boolean> v = (JSONValue<Boolean>)get(key);
				value = v.getValue().booleanValue();
			} else {
				throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.BOOLEAN, get(key).getType()));
			}
		} else {
			throw new JSONInvalidValueTypeException("Cannot cast a null to a boolean");
		}
		return value;
		
	}

	@SuppressWarnings("unchecked")
	public String getString(String key) throws JSONInvalidValueTypeException {
		String value = null;
		if (containsKey(key)) {
			if (get(key).getType() == JSONValueType.STRING) {
				JSONValue<String> v = (JSONValue<String>)get(key);
				value = v.getValue();
			} else {
				throw new JSONInvalidValueTypeException(JSONInvalidValueTypeException.getMessage(JSONValueType.STRING, get(key).getType()));
			}
		}
		return value;
	}

}
