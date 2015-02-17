package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValueType;
import com.ghotibown.json.NullObject;

class JSONNullValue extends AbstractJSONValue<NullObject> {

	public JSONNullValue(NullObject value) {
	    super(value);
	    
    }

	@Override
    public JSONValueType getType() {
	    return JSONValueType.NULL;
    }

	@Override
    public boolean isPrimitive() {
	    // TODO Auto-generated method stub
	    return true;
    }
	
	public boolean isArray() {
		return false;
	}
	
	@Override
	public NullObject getValue() {
		return null;
	}
	
	public String toString() {
		return "null";
	}

}
