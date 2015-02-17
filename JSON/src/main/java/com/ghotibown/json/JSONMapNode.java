package com.ghotibown.json;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.ghotibown.json.exception.JSONInvalidValueTypeException;
import com.ghotibown.json.exception.JSONValueNotFoundException;

/**
 * Base interface for JSON Associative Array objects (e.g., {@linkplain JSONObject}
 * 
 * @author jearley
 *
 */
public interface JSONMapNode extends JSONNode {

    /**
     * Add a key value pair to the map. If the named pair already exists, the value is updated
     * 
     * @param key
     *            the entry name
     * @param value
     *            the {@linkplain JSONValue}
     */
    void put(String key, JSONValue<?> value);

    /**
     * Adds a key-value pair to the map. Values can be of any valid value type and will be converted to the appropriate
     * <code>JSONValue<?></code> instance
     * 
     * @param key
     *            the entry name
     * @param value
     *            the value
     * @throws JSONInvalidValueTypeException
     *             thrown if the value is not a valid value type (see {@link JSONValueType})
     */
    void put(String key, Object value) throws JSONInvalidValueTypeException;

    /**
     * 
     * @param map
     */
    void putAll(Map<String, JSONValue<?>> map);

    /**
     * Imports a generic map and creates an internal map representation of String, JSONValue&lt;?&gt; pairs
     * 
     * @param map
     *            the associative array map object containing the key value pairs to import
     * @throws JSONInvalidValueTypeException
     *             thrown if any of the values is not a valid value type (see {@link JSONValueType})
     */
    void putAllRaw(Map<String, Object> map) throws JSONInvalidValueTypeException;

    /**
     * Clears all values from this mapped object
     */
    void clear();

    /**
     * returns the number of entries in this mapped object
     * 
     * @return the size of the current map's entries
     */
    int size();

    /**
     * Returns an interable collection of all the map's values
     * 
     * @return an iterable collection of all the maps values
     */
    Collection<JSONValue<?>> values();

    Iterable<String> keys();

    /**
     * Returns a value based on a specific key
     * 
     * @param key
     *            the entry's key
     * @return the value of the entry
     * @throws JSONValueNotFoundException
     */
    JSONValue<?> get(String key) throws JSONValueNotFoundException;

    /**
     * Serializes the internal map's String, JSONValue&lt;?&gt; pairs into a generic map of String, Object pairs. Useful when you need to
     * integrate with other code that doesn't work with JSONValue objects
     * 
     * @return a Map of String, Object pairs
     */
    Map<String, Object> getMap();

    /**
     * Returns the set of the map's String, JSONValue pairs
     * 
     * @return the set of the map's String, JSONValue pairs
     */
    Set<Map.Entry<String, JSONValue<?>>> elements();

    /**
     * Returns an array of each entry's keys
     * 
     * @return a String array of each entry's keys
     */
    String[] names();

    /**
     * Returns whether or not a named entry exists in the map
     * 
     * @param key
     *            the key to evaluate
     * @return <code>true</code> if the key exists; <code>false</code> otherwise
     */
    boolean containsKey(String key);

    /**
     * Removes an entry from the map
     * 
     * @param key
     *            the specified entry's key
     * @return The entry's value
     */
    JSONValue<?> remove(String key);

}
