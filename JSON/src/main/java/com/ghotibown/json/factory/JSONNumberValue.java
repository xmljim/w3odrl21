package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValueType;

class JSONNumberValue extends AbstractJSONValue<Number> {

	public JSONNumberValue(Number value) {
	    super(value);

    }

	@Override
	public JSONValueType getType() {
		return JSONValueType.NUMBER;
	}
	
	public String toString() {
		return getValue().toString();
	}

	public boolean isPrimitive() {
		return true;
	}
	
	public boolean isArray() {
		return false;
	}
}
