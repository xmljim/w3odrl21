package com.ghotibown.json.jpath;

import com.ghotibown.json.JSONNode;
import com.ghotibown.json.JSONValue;

public interface JPathExpression {

	JSONValue<?> find(String path, JSONNode context);
}
