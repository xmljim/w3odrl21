package com.ghotibown.json.factory;

import com.ghotibown.json.JSONValue;
import com.ghotibown.json.JSONValueType;

/**
 * @author  jearley
 */
abstract class AbstractJSONValue<T> implements JSONValue<T> {
	/**
     * @uml.property  name="_value"
     */
	private T _value;
	
	public AbstractJSONValue(T value) {
		_value = value;
	}

	
	public T getValue() {
		return _value;
	}

	/**
     * @uml.property  name="type"
     * @uml.associationEnd  readOnly="true"
     */
	
	public abstract JSONValueType getType();
	
	public  void setValue(T value)  {
		_value = value;
	}
	
	public abstract boolean isPrimitive();

}
