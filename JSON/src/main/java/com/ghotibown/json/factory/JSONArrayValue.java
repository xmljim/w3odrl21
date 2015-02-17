package com.ghotibown.json.factory;

import com.ghotibown.json.JSONArray;
import com.ghotibown.json.JSONValueType;

class JSONArrayValue extends AbstractJSONValue<JSONArray> {

	public JSONArrayValue(JSONArray value) {
	    super(value);
    }

	@Override
    public JSONValueType getType() {
	    return JSONValueType.ARRAY;
    }

	@Override
    public boolean isPrimitive() {
	    return false;
    }
	
	public boolean isArray() {
		return true;
	}
	
	
	@Override
	public String toString() {
		return getValue().toJSONString();
	}

}
