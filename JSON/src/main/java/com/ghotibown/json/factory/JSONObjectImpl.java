package com.ghotibown.json.factory;

import java.util.Map.Entry;

import com.ghotibown.json.JSONValue;

class JSONObjectImpl extends AbstractJSONObject {

	public JSONObjectImpl() {
		super();
	}
	
	@Override
	public String toJSONString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		int size = this.size();
		int pos = 0;
		for (Entry<String, JSONValue<?>> entry : elements()) {
			String key = entry.getKey();
			String value = entry.getValue().toString();
			builder.append("\"" + key + "\"").append(":").append(value);
			if (pos < (size - 1)) {
				builder.append(",");
			}
			pos++;
		}
		
		builder.append("}");
		
		return builder.toString();
	}
	
	public String toString() {
		return toJSONString();
	}
}
