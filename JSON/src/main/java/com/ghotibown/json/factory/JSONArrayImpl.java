package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValue;


class JSONArrayImpl extends AbstractJSONArray implements Iterable<JSONValue<?>> {
	
	@Override
	public String toJSONString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		
		for (int i = 0; i < this.size(); i++) {
			builder.append(get(i).toString());
			if (i < (size() - 1)) {
				builder.append(",");
			}
		}
		
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return toJSONString();
	}

}
