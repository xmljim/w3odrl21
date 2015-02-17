package com.ghotibown.json;

import com.ghotibown.json.exception.JSONInvalidValueTypeException;

/**
 * The JSONObject interface.  Represents an associative array of key, value pairs, where the value can be
 * any valid value type.  It extends from the {@linkplain JSONMapNode} interface an primarily contains convenience 
 * methods for putting or accessing explicit value types
 * @author jearley
 *
 */
public interface JSONObject extends JSONMapNode {
	

	/**
	 * Adds or replaces a number value
	 * @param key the key
	 * @param n the number
	 */
	void put(String key, Number n);
	
	/**
	 * Adds or replaces a String value
	 * @param key the key
	 * @param s the string value
	 */
	void put(String key, String s);
	
	/**
	 * Adds or replaces a boolean value
	 * @param key the key
	 * @param b the boolean value
	 */
	void put(String key, boolean b);
	
	/**
	 * Adds or replaces a {@linkplain JSONArray} value
	 * @param key the key
	 * @param a the JSONArray
	 */
	void put(String key, JSONArray a);
	
	/**
	 * Adds or replaces a {@linkplain JSONObject} value
	 * @param key the key
	 * @param o the JSONObject
	 */
	void put(String key, JSONObject o);
	
	void putNull(String key);
	
	JSONObject getJSONObject(String key) throws JSONInvalidValueTypeException;
	
	JSONArray getJSONArray(String key) throws JSONInvalidValueTypeException;
	
	Number getNumber(String key) throws JSONInvalidValueTypeException;
	
	long getLong(String key) throws JSONInvalidValueTypeException;
	
	int getInt(String key) throws JSONInvalidValueTypeException;
	
	boolean getBoolean(String key) throws JSONInvalidValueTypeException;
	
	String getString(String key) throws JSONInvalidValueTypeException;
	
	
	

}
