package com.ghotibown.json.factory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;
import com.ghotibown.json.NullObject;

public class NodeFactory {
	
	public static JSONObject newJSONObject() {
		return new JSONObjectImpl();
	}
	
	public static JSONArray newJSONArray() {
		return new JSONArrayImpl();
	}
	
	public static JSONObject newJSONObject(Map<String, Object> map) {
		JSONObject obj = newJSONObject();
		Set<Entry<String, Object>> entries = map.entrySet();

		for (Entry<String, Object> entry : entries) {
			String key = entry.getKey();
			JSONValue<?> value = createFromObject(entry.getValue());
			obj.put(key, value);
		}
		
		return obj;
		
	} 
	
	public static JSONArray newJSONArray(List<Object> list) {
		JSONArray array = newJSONArray();
		for (Object o : list) {
			array.add(createFromObject(o));
		}
		return array;
	}
	
	public static JSONValue<String> newStringValue(String value) {
		JSONStringValue v = new JSONStringValue(value);
		return v;
	}
	
	public static JSONValue<Number> newNumberValue(Number value) {
		JSONNumberValue v = new JSONNumberValue(value);
		return v;
	}
	
	public static JSONValue<Boolean> newBooleanValue(boolean value) {
		JSONBooleanValue v = new JSONBooleanValue(value);
		return v;
	}
	
	public static JSONValue<Date> newDateValue(Date value) {
		JSONDateValue v = new JSONDateValue(value);
		return v;
	}
	
	public static JSONValue<JSONObject> newJSONObjectValue(JSONObject value) {
		JSONObjectValue v = new JSONObjectValue(value);
		return v;
	}
	
	public static JSONValue<JSONArray> newJSONArrayValue(JSONArray value) {
		JSONArrayValue v = new JSONArrayValue(value);
		return v;
	}
	
	public static JSONValue<NullObject> newJSONNullValue() {
		JSONNullValue v = new JSONNullValue(new NullObject());
		return v;
	}
	
	@SuppressWarnings("unchecked")
    public static JSONValue<?> createFromObject(Object o) {
		JSONValue<?> v = null;
		
		if (o instanceof String) {
			v = newStringValue((String)o);
		} else if (o instanceof Number) {
			v = newNumberValue((Number)o);
		} else if (o instanceof Boolean) {
			v = newBooleanValue((Boolean)o);
		} else if (o instanceof NullObject) {
			v = newJSONNullValue();
		} else if (o instanceof Map) {
			v = (JSONValue<?>) newJSONObjectValue(newJSONObject((Map<String, Object>)o));
		} else if (o instanceof List) {
			v =  (JSONValue<?>) newJSONArrayValue(newJSONArray((List<Object>)o));
		} else if (o instanceof Date) {
			v = (JSONValue<?>) newDateValue((Date)o);
		}
		
		return v;
		
	}
	
	

}
