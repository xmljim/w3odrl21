package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValueType;

class JSONBooleanValue extends AbstractJSONValue<Boolean> {

	public JSONBooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public JSONValueType getType() {
		return JSONValueType.BOOLEAN;
	}
	
	public String toString() {
		return getValue().toString();
	}
	
	public boolean isArray() {
		return false;
	}
	
	public boolean isPrimitive() {
		return true;
	}

}
