package com.ghotibown.json.factory;

import java.text.DateFormat;
import java.util.Date;

import com.ghotibown.json.JSONValueType;


public class JSONDateValue extends AbstractJSONValue<Date> {

	public JSONDateValue(Date value) {
	    super(value);
	    // TODO Auto-generated constructor stub
    }

	@Override
    public JSONValueType getType() {
	    return JSONValueType.DATE;
    }

	@Override
    public boolean isPrimitive() {
	    
	    return true;
    }
	
	public boolean isArray() {
		return false;
	}
	
	public String toString() {
		
		return "\"" + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG).format(getValue()) + "\"";
		
	}

}
