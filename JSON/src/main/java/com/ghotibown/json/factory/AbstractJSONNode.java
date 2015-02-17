package com.ghotibown.json.factory;

import com.ghotibown.json.JSONNode;
import com.ghotibown.json.JSONValue;

abstract class AbstractJSONNode implements JSONNode {
	
	
	
	public AbstractJSONNode() {
		
	}

	public abstract JSONValue<?> getValue();

	
	public String toJSONString() {
		return getValue().toString();
	}

}
