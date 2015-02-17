package com.ghotibown.json.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONListNode;
import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValue;

abstract class AbstractListNode extends AbstractJSONNode implements JSONListNode, Iterable<JSONValue<?>> {
	

	private List<JSONValue<?>> jsonList = new ArrayList<JSONValue<?>>();

	public AbstractListNode() {
		super();
	}

	
	public void add(JSONValue<?> value) {
		jsonList.add(value);
	}

	
    public JSONValue<?> get(int index) {
	    return jsonList.get(index);
    }

	
    public Iterator<JSONValue<?>> iterator() {
	    return jsonList.iterator();
    }

	
    public JSONValue<?> remove(int index) {
	    return jsonList.remove(index);
    }

	
    public void clear() {
	    jsonList.clear();
	    
    }

	
	public void addAll(List<?> list) {
		for (Object val : list) {
			JSONValue<?> value = null;
			
			if (val instanceof String) {
				value = new JSONStringValue(val.toString());
			} else if (val instanceof Boolean) {
				value = new JSONBooleanValue(Boolean.valueOf( (Boolean) val));
			} else if (val instanceof Number) {
				value = new JSONNumberValue((Number)val);
			} else if (val instanceof JSONObject) {
				value = new JSONObjectValue((JSONObject)val);
			} else if (val instanceof JSONArray) {
				value = new JSONArrayValue((JSONArray)val);
			}
			
			add(value);
		}

	}
	
	public int size() {
		return jsonList.size();
	}
	
	
	public List<JSONValue<?>> getValues() {
		return jsonList;
	}
	
	@Override
	public JSONValue<?> getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
