package com.ghotibown.json.factory;

import com.ghotibown.json.JSONObject;
import com.ghotibown.json.JSONValueType;

class JSONObjectValue extends AbstractJSONValue<JSONObject> {

	public JSONObjectValue(JSONObject value) {
	    super(value);
	    
    }

	@Override
    public JSONValueType getType() {
	    return JSONValueType.OBJECT;
    }
	
	public String toString() {
		return getValue().toJSONString();
	}
	
	public boolean isPrimitive() {
		return false;
	}
	
	public boolean isArray() {
		return false;
	}

}
