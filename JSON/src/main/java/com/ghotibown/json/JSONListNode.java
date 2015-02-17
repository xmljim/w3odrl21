package com.ghotibown.json;

import java.util.Iterator;
import java.util.List;

public interface JSONListNode extends JSONNode, Iterable<JSONValue<?>> {
	
	void add(JSONValue<?> value);
	
	void addAll(List<?> list);
	
	JSONValue<?> get(int index);
	
	Iterator<JSONValue<?>> iterator();
	
	JSONValue<?> remove(int index);
	
	void clear();
	
	int size();
	
	List<JSONValue<?>> getValues();
}
