package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValueType;

class JSONStringValue extends AbstractJSONValue<String> {

	public JSONStringValue(String value) {
	    super(value);
    }

	@Override
    public JSONValueType getType() {
	    return JSONValueType.STRING;
    }

	public boolean isPrimitive() {
		return true;
	}
	
	public boolean isArray() {
		return false;
	}
	
	public String toString() {
		return "\"" + getValue() + "\"";
	}
}
